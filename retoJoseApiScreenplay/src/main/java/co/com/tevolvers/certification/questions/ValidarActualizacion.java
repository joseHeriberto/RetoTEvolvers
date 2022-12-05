package co.com.tevolvers.certification.questions;

import co.com.tevolvers.certification.models.DatosPrueba;
import co.com.tevolvers.certification.models.Token;
import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarActualizacion implements Question {
    Gson gson = new Gson();


    @Override
    public Object answeredBy(Actor actor) {

        String json = SerenityRest.lastResponse().asString();
        DatosPrueba token = gson.fromJson(json, DatosPrueba.class);
        return token.getFirstname();
    }

    public static ValidarActualizacion actualizacion() {
        return new ValidarActualizacion();
    }
}
