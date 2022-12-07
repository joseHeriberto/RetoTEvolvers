package co.com.tevolvers.certification.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.reto.userinterfaces.Productos.TOTAL;

public class ValidarPrecioTotal implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        String precioCalculado = actor.recall("precioTotal");

        boolean precioTotal = TOTAL.resolveFor(actor).getText()
                .replace("$", "").replace(",", "")
                .equals(precioCalculado.replace(",", "."));

        return precioTotal;
    }

    public static ValidarPrecioTotal precio() {
        return new ValidarPrecioTotal();
    }
}
