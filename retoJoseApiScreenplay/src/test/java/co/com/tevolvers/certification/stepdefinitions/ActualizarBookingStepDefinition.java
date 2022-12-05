package co.com.tevolvers.certification.stepdefinitions;

import co.com.tevolvers.certification.interactions.ConstruirCuerpo;
import co.com.tevolvers.certification.questions.ValidarActualizacion;
import co.com.tevolvers.certification.tasks.AcualizarBooking;
import co.com.tevolvers.certification.tasks.ObtenerToken;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class ActualizarBookingStepDefinition {

    @Dado("^yo realizo la peticion para generar el token (.*) y (.*)$")
    public void yoRealizoLaPeticionParaGenerarElTokenAdminYPassword123(String username, String password) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ObtenerToken.token(username,password));
    }

    @Cuando("realizo la peticion de actualizar Booking")
    public void realizoLaPeticionDeActualizarBooking(List<Map<String, String>> datos) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ConstruirCuerpo.deLaPeticion((datos)));
        OnStage.theActorInTheSpotlight().wasAbleTo(AcualizarBooking.actualizar(datos));
        
    }

    @Entonces("^deberia ver la respuesta exitosa de actualizar Booking validando el nombre (.*)$")
    public void deberiaVerLaRespuestaExitosaDeActualizarBookingValidandoElNombreAlejandra(String nombre) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(ValidarActualizacion.actualizacion(), Matchers.equalTo(nombre)));
    }
}
