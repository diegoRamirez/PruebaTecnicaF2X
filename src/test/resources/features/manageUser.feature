Feature: Administrar usuarios

  Scenario Outline: Crear un nuevo usuario

#    Este escenario consiste en crear un nuevo usuario ingresando su nombre y su trabajo
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 201 y que retorne el nombre y teléfono ingresado y un id.

    Given quiero crear un nuevo usuario
    When ingreso los datos <NAME>,<JOB>
    Then el status code debe ser 201
    And debe retornar los datos ingresados <NAME>, <JOB>

    Examples:
      |NAME                      |JOB        |
      |Ramón Valdéz              |Desempleado|
      |Señor barriga             |Arrendador |

  Scenario Outline: Editar usuario

#    Este escenario consiste en editar exitosamente la información de un usuario
#    utilizando un método PUT. Se validará que el status code sea 200 y que en el response regresen los datos como se ingresaron
#    en el request



    Given quiero editar la informacion de un usuario
    When edito los datos del <ID>,<NAME>,<JOB>
    Then el status code debe ser 200
    And debe retornar los datos ingresados <NAME>, <JOB>

    Examples:
      |ID|NAME                      |JOB        |
      |1 |Ramón Valdéz              |Desempleado|
      |2 |Señor barriga             |Arrendador |

  Scenario Outline: obtener los datos de un usuario a traves de su ID

#    Este escenario consiste en consumir el servicio GET que a través del ID del usuario
#    permite obtener toda la información de este.
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 200 y que el email, nombre y apellido retornados, coincidan con
#    los parametrizados para la prueba.


    Given quiero consultar los datos de un usuario
    When realizo la consulta con el id <ID>
    Then el status code debe ser 200
    And los datos deben ser <EMAIL>, <FIRST_NAME>, <LAST_NAME>

    Examples:
      |ID|EMAIL                     |FIRST_NAME      |LAST_NAME      |
      |2 |janet.weaver@reqres.in    |Janet           |Weaver         |
      |1 |george.bluth@reqres.in    |George          |Bluth          |

  Scenario Outline: Validar respuesta cuando el ID del usuario no existe

#    Este escenario consiste en consumir el servicio GET que a través del ID del usuario
#    permite obtener toda la información de este, ingresando un ID que no existe y de esta manera validar
#    el código de respuesta.
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 404


    Given quiero consultar los datos de un usuario
    When realizo la consulta con el id <ID>
    Then el status code debe ser 404


    Examples:
      |ID   |
      |9999 |
      |10000|

  Scenario Outline: Eliminar un usuario

#    Este escenario consiste en eliminar un usuario y validar que el status code del response sea el correcto

    Given quiero eliminar un usuario
    When elimino el usuario con el id <ID>
    Then el status code debe ser 204


    Examples:
      |ID|
      |2 |
      |3 |