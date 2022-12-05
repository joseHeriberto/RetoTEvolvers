package co.com.tevolvers.certification.stepdefinitions;

import co.com.tevolvers.certification.questions.ValidarCodigoRespuesta;
import co.com.tevolvers.certification.tasks.ConsultarBooking;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.Map;

public class ConsultarBookingStepDefinition {
    @Cuando("realizo la peticion de consultar Booking")
    public void realizoLaPeticionDeConsultarBooking(Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarBooking.consulta(datos));

    }
    @Entonces("deberia ver la respuesta exitosa de consultar Booking")
    public void deberiaVerLaRespuestaExitosaDeConsultarBooking() {

    }

    @Entonces("deberia ver la respuesta exitosa de consultar Booking con codido de respuesta {int}")
    public void deberiaVerLaRespuestaExitosaDeConsultarBookingConCodidoDeRespuesta(int codigo) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(ValidarCodigoRespuesta.creacion(), Matchers.equalTo(codigo)));
    }
}
