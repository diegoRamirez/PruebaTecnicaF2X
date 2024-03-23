Feature: Realizar operaciones con datos de usuario

  Scenario Outline: obtener los datos de un usuario a traves de su ID

#    Este escenario consiste en consumir el servicio GET que a través del ID del usuario
#    permite obtener toda la información de este.
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 200 y que el email, nombre y apellido retornados, coincidan con
#    los parametrizados para la prueba.


    Given quiero consultar los datos de un usuario
    When realizo la consulta con el id <ID>
    Then el codigo de respuesta debe ser  200
    And los datos deben ser <EMAIL>, <FIRST_NAME>, <LAST_NAME>

    Examples:
      |ID|EMAIL                     |FIRST_NAME      |LAST_NAME      |
      |2 |janet.weaver@reqres.in    |Janet           |Weaver         |
      |1 |george.bluth@reqres.in    |George          |Bluth          |


  Scenario Outline: Validar respuesta cuando el ID no existe

#    Este escenario consiste en consumir el servicio GET que a través del ID del usuario
#    permite obtener toda la información de este, ingresando un ID que no existe y de esta manera validar
#    el código de respuesta.
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 401


    Given quiero consultar los datos de un usuario
    When realizo la consulta con el id <ID>
    Then el codigo de respuesta debe ser  404


    Examples:
      |ID   |
      |9999 |
      |10000|