#Autor Jose Heriberto Arias Andica
  #language: es

Característica: Yo como usuario deseo consultar Booking


  Esquema del escenario: realizar la operacion de consultar Booking
    Cuando realizo la peticion de consultar Booking
      | id | <id> |
    Entonces deberia ver la respuesta exitosa de consultar Booking con codido de respuesta 200
    Ejemplos:
      | id  |
      |39840 |