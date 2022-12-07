package co.com.tevolvers.certification.reto.tasks;

import co.com.tevolvers.certification.reto.utils.CalcularPrecioTotal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.tevolvers.certification.reto.userinterfaces.Productos.PRECIO_TOTAL_PRODUCTOS;

public class IrACarrito implements Task {
    CalcularPrecioTotal calcularPrecioTotal = new CalcularPrecioTotal();

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> precios = Text.of(PRECIO_TOTAL_PRODUCTOS).viewedBy(actor).asList();

        actor.remember("precioTotal", String.format("%.2f", calcularPrecioTotal.precioTotal(precios)));
    }


    public static IrACarrito deCompras() {
        return Tasks.instrumented(IrACarrito.class);
    }
}
