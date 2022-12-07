#author: Jose Heriberto Arias Andica

  #language: es


Característica: Yo como usuario quiero agregar productos al carrito de compras y validar el total a pagar

  Esquema del escenario: Seleccionar y agregar los productos al carrito de compras
    Dado que el usuario ingresa a la pagina principal
    Cuando el usuario selecciona los productos y agregar varias cantidades
      | cantproductos   |cantinudad|
      | <cantproductos> |<cantinudad>|
    Entonces deberia ver que el precio total coincida con la suma de los valores de los productos

    Ejemplos:
      | cantproductos |cantinudad|
      | 2             |2         |