package co.com.tevolvers.certification.reto.stepdefinitions;

import co.com.tevolvers.certification.reto.models.Producto;
import co.com.tevolvers.certification.reto.questions.ValidarPrecioTotal;
import co.com.tevolvers.certification.reto.tasks.AgregarProducto;
import co.com.tevolvers.certification.reto.tasks.IrACarrito;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ComprarProductoStepDefinition {

    @Managed(driver = "chrome")
    static WebDriver driver;

    @Before
    public void configuracion() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        OnStage.theActorCalled("Jose");
    }

    @Dado("^que el usuario ingresa a la pagina principal$")
    public void queElUsuarioIngresaALaPaginaPrincipal() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.advantageonlineshopping.com/#/"));
    }


    @Cuando("^el usuario selecciona los productos y agregar varias cantidades$")
    public void elUsuarioSeleccionaLosProductosYAgregarVariasCantidades(List<Producto> productos) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProducto.alCarrito(productos));
        OnStage.theActorInTheSpotlight().attemptsTo(IrACarrito.deCompras());
    }

    @Entonces("^deberia ver que el precio total coincida con la suma de los valores de los productos$")
    public void deberiaVerQueElPrecioTotalCoincidaConLaSumaDeLosValoresDeLosProductos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(ValidarPrecioTotal.precio(), Matchers.is(true)));
    }


}
