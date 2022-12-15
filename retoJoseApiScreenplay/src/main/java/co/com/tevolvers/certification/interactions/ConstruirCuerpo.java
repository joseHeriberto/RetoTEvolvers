package co.com.tevolvers.certification.interactions;

import co.com.tevolvers.certification.models.Bookingdates;
import co.com.tevolvers.certification.models.DatosPrueba;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class ConstruirCuerpo implements Interaction {
    public List<Map<String, String>> informacion;

    public ConstruirCuerpo(List<Map<String, String>> informacion) {
        this.informacion = informacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        Bookingdates bookingdates = new Bookingdates();
        DatosPrueba datosPrueba = new DatosPrueba();
        datosPrueba.setFirstname(informacion.get(0).get("firstname"));
        datosPrueba.setLastname(informacion.get(0).get("lastname"));
        datosPrueba.setTotalprice(Integer.parseInt(informacion.get(0).get("totalprice")));
        datosPrueba.setDepositpaid(Boolean.parseBoolean(informacion.get(0).get("depositpaid")));

        bookingdates.setCheckin(informacion.get(0).get("checkin"));
        bookingdates.setCheckout(informacion.get(0).get("checkout"));
        datosPrueba.setBookingdates(bookingdates);

        datosPrueba.setAdditionalneeds(informacion.get(0).get("additionalneeds"));

        String Json = gson.toJson(datosPrueba);
        actor.remember("json",Json);
    }

    public static ConstruirCuerpo deLaPeticion(List<Map<String, String>> informacion){
        return Tasks.instrumented(ConstruirCuerpo.class, informacion);
    }
}
