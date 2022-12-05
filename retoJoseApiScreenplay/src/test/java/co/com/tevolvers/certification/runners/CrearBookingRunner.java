package co.com.tevolvers.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\crear_booking.feature",
        glue = "co\\com\\tevolvers\\certification\\stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@crearBooking"
)
public class CrearBookingRunner {
}
