package co.com.tevolvers.certification.stepdefinitions;

import co.com.tevolvers.certification.interactions.ConstruirCuerpo;
import co.com.tevolvers.certification.questions.ValidarCodigoRespuesta;
import co.com.tevolvers.certification.tasks.CrearBooking;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static co.com.tevolvers.certification.utils.Contantes.BASE_URL;

public class CrearBookingStepDefinitions {

    @Before
    public void configuracionInicioApi(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Jose").whoCan(CallAnApi.at(BASE_URL));


    }

    @Cuando("realizo la peticion de crear Booking")
    public void realizoLaPeticionDeCrearBooking(List<Map<String, String>> datosPrueba) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ConstruirCuerpo.deLaPeticion(datosPrueba));
        OnStage.theActorInTheSpotlight().wasAbleTo(CrearBooking.deLaPeticion());

    }
    @Entonces("deberia ver la respuesta exitosa de crear Booking")
    public void deberiaVerLaRespuestaExitosaDeCrearBooking() {

    }

    @Entonces("deberia ver la respuesta exitosa de crear Booking con codigo {int}")
    public void deberiaVerLaRespuestaExitosaDeCrearBookingConCodigo(int codigo) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(ValidarCodigoRespuesta.creacion(), Matchers.equalTo(codigo)));

    }
}
