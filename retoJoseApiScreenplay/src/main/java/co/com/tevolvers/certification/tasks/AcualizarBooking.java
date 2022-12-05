package co.com.tevolvers.certification.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.List;
import java.util.Map;

import static co.com.tevolvers.certification.utils.Contantes.ACTUALIZAR;

public class AcualizarBooking implements Task {

    List<Map<String,String>>datos;

    public AcualizarBooking(List<Map<String, String>> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(ACTUALIZAR+datos.get(0).get("id"))
                        .with(requestSpecification -> requestSpecification
                                .header("Authorisation","Basic")
                                .header("Content-Type","application/json")
                                .header("Cookie","token=\""+actor.recall("token")+"\"")
                                .body((String) actor.recall("json"))
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().prettyPrint();

    }

    public static AcualizarBooking actualizar(List<Map<String, String>> datos){
        return Tasks.instrumented(AcualizarBooking.class, datos);
    }
}
