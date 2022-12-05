package co.com.tevolvers.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarCodigoRespuesta implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return actor.recall("codigoRespuesta");
    }

    public static ValidarCodigoRespuesta creacion() {
        return new ValidarCodigoRespuesta();
    }
}
