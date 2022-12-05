package co.com.tevolvers.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\actualizar_booking.feature",
        glue = "co\\com\\tevolvers\\certification\\stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ActualizarBookingRunner {
}
