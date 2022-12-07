package co.com.tevolvers.certification.reto.utils;

import java.util.List;

public class CalcularPrecioTotal {

    float precioProducto =0;

    public Float precioTotal(List<String> precios){
        for (String precio:precios ) {
            String precioProduct = precio.replace("$","").replace(",","").trim();
            precioProducto +=Float.parseFloat(precioProduct);
        }
        return precioProducto;
    }
}
