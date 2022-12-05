package co.com.tevolvers.certification.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static co.com.tevolvers.certification.utils.Contantes.CREAR;

public class CrearBooking implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(CREAR).with(
                        requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .body((String) actor.recall("json"))
                                .relaxedHTTPSValidation()
                )
        );
        actor.remember("codigoRespuesta", SerenityRest.lastResponse().getStatusCode());
        SerenityRest.lastResponse().prettyPrint();
    }

    public static CrearBooking deLaPeticion() {
        return Tasks.instrumented(CrearBooking.class);
    }
}
