#Autor Jose Heriberto Arias Andica
  #language: es

Característica: Yo como usuario deseo crear un Booking

  @crearBooking
  Esquema del escenario: realizar la operacion de crear Booking
    Cuando realizo la peticion de crear Booking
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin>    | <checkout>   | <additionalneeds> |
    Entonces deberia ver la respuesta exitosa de crear Booking con codigo 200
    Ejemplos:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Nepomuseno       | Torres   | 222        | true        | 2019-01-01 | 2020-01-01 | Lunch           |

