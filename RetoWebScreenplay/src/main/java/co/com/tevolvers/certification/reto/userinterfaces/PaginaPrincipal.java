package co.com.tevolvers.certification.reto.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {
    public static final Target PRODUCTOS = Target.the("productos")
            .locatedBy("(//div[@class='shop_now_slider'])[{0}]");
}
