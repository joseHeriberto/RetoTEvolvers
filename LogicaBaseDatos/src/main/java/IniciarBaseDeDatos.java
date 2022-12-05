import com.fasterxml.jackson.core.JsonProcessingException;
import net.datafaker.Faker;

public class IniciarBaseDeDatos {


    public static void main(String[] args) throws JsonProcessingException {
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();

        Faker randomData = new Faker();

        String cedula = randomData.number().digits(10);
        String insertSql = "INSERT INTO persona" +
                "(cedula, nombres, apellido, telefono, edad)" +
                "VALUES('"+cedula+"', '"+randomData.name().firstName()+"', '"+randomData.name().lastName()
                +"', '"+randomData.number().digits(10)+"', "+randomData.number().digits(2)+")";

        conexionBaseDatos.insertarDatos(insertSql);

        String selectSql = "SELECT * FROM persona where cedula='"+cedula+"'";
        conexionBaseDatos.consultaSQL(selectSql);

    }
}
