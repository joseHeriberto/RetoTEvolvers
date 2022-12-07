package co.com.tevolvers.certification.reto.tasks;

import co.com.tevolvers.certification.reto.models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.tevolvers.certification.reto.userinterfaces.PaginaPrincipal.PRODUCTOS;
import static co.com.tevolvers.certification.reto.userinterfaces.Productos.*;

public class AgregarProducto implements Task {

    List<Producto> productos;
    private int cantProductos;

    public AgregarProducto(List<Producto> productos) {
        this.productos = productos;
        this.cantProductos = Integer.parseInt(productos.get(0).getCantproductos());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int j = 1; j <= 5; j++) {
            actor.attemptsTo(
                    WaitUntil.the(PRODUCTOS.of(String.valueOf(j)), WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(PRODUCTOS.of(String.valueOf(j)))
            );

            for (int i = 1; i <= cantProductos; i++) {
                actor.attemptsTo(
                        WaitUntil.the(PRODUCTO.of(String.valueOf(i)), WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(PRODUCTO.of(String.valueOf(i))),
                        Click.on(AGREGAR_CARRITO),
                        Click.on(SELECCIONAR_ITEM)
                );
            }
            actor.attemptsTo(
                    Click.on(LOGO)
            );

        }

        actor.attemptsTo(
                WaitUntil.the(CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CARRITO)
        );
    }

    public static AgregarProducto alCarrito(List<Producto> productos) {
        return Tasks.instrumented(AgregarProducto.class, productos);
    }
}
