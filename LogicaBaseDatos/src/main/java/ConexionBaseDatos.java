import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.sql.*;

public class ConexionBaseDatos {

    ModeloConsulta modeloConsulta = new ModeloConsulta();

    Gson gson = new Gson();

    public String conexion() {
        String connectionUrl =
                "jdbc:sqlserver://SQL5074.site4now.net:1433;"
                        + "databaseName=db_a46019_test;"
                        + "user=db_a46019_test_admin;"
                        + "password=test1234;";

        return connectionUrl;
    }

    public void insertarDatos(String consulta) {

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(conexion());
             PreparedStatement statement = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

            resultSet = statement.getGeneratedKeys();


            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void consultaSQL(String consulta) throws JsonProcessingException {

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(conexion());
             Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                modeloConsulta.setCedula(resultSet.getString("cedula"));
                modeloConsulta.setNombres(resultSet.getString("nombres"));
                modeloConsulta.setApellido(resultSet.getString("apellido"));
                modeloConsulta.setTelefono(resultSet.getString("telefono"));
                modeloConsulta.setEdad(resultSet.getInt("edad"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        String json = gson.toJson(modeloConsulta);
        System.out.println("JSon de la respuesta de la consulta: " + json);

    }
}
