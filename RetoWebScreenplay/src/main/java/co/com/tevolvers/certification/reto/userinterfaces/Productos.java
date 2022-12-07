package co.com.tevolvers.certification.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Productos {

    public static final Target PRODUCTO = Target.the("selecciona el producto")
            .locatedBy("(//li//a[@class='productName ng-binding'])[{0}]");

    public static final Target AGREGAR_UNIDAD = Target.the("agregar unidades adicionales")
            .located(By.xpath("//div[@class='plus']"));

    public static final Target SELECCIONAR_ITEM = Target.the("seleccionar el item")
            .located(By.xpath("//a[@class='ng-binding']"));

    public static final Target AGREGAR_CARRITO = Target.the("agrega productos al carrito")
            .located(By.xpath("//button[@name='save_to_cart']"));

    public static final Target CHECKOUT = Target.the("checkout")
            .located(By.xpath("//button[@name='check_out_btn']"));

    public static final Target CARRITO = Target.the("ir al carrito")
            .located(By.xpath("//a[@id= 'shoppingCartLink']"));

    public static final Target PRECIO_UNITARIO = Target.the("precio total")
            .located(By.xpath("(//h2[@class='roboto-thin screen768 ng-binding'])[1]"));

    public static final Target CANTIDAD_PRODUCTOS = Target.the("cantidad de productos")
            .located(By.xpath("(//td[@class='smollCellquantityMobile']//label[@class='ng-binding'])[{0}]"));

    public static final Target PRECIO_TOTAL_PRODUCTOS = Target.the("precio total de productos")
            .located(By.xpath("//td[@class='smollCell']//p[@class='price roboto-regular ng-binding']"));

    public static final Target TOTAL = Target.the("total")
            .located(By.xpath("(//td//span[@class='roboto-medium ng-binding'])[2]"));

    public static final Target LOGO = Target.the("volver a la pagina principal")
            .located(By.xpath("//div[@class='logo']"));
}
