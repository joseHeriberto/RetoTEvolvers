package co.com.tevolvers.certification.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static co.com.tevolvers.certification.utils.Contantes.CONSULTAR;

public class ConsultarBooking implements Task {

    public Map<String, String> datos;

    public ConsultarBooking(Map<String, String> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(CONSULTAR + datos.get("id")).with(requestSpecification -> requestSpecification
                        .header("Accept", "application/json")
                        .relaxedHTTPSValidation()
                )

        );
        actor.remember("codigoRespuesta", SerenityRest.lastResponse().getStatusCode());
        SerenityRest.lastResponse().prettyPrint();
    }

    public static ConsultarBooking consulta(Map<String, String> datos) {
        return Tasks.instrumented(ConsultarBooking.class, datos);
    }
}
