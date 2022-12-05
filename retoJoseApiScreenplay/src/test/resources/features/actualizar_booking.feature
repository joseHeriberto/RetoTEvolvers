#Autor Jose Heriberto Arias Andica
  #language: es

Característica: Yo como usuario deseo actualizar Booking

  @crearBooking
  Esquema del escenario: realizar la operacion de crear Booking
    Dado yo realizo la peticion para generar el token <username> y <password>
    Cuando realizo la peticion de actualizar Booking
      | id   | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   | username   | password   |
      | <id> | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> | <username> | <password> |
    Entonces deberia ver la respuesta exitosa de actualizar Booking validando el nombre <firstname>
    Ejemplos:
      | id    | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds | username | password    |
      | 39840 | Ruperto   | Renacuajo | 222        | true        | 2019-01-01 | 2020-01-01 | dinner          | admin    | password123 |