Feature: Registro de usuarios

  Scenario Outline: Registrar satisfactoriamente un usuario

#    Este escenario consiste en registrar satisfactoriamente un usuario.
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 200 y que en el response vengan los campos Id y Token.

    Given quiero registrar un nuevo usuario
    When registro los datos <EMAIL>,<PASSWORD>
    Then el status code debe ser 200
    And debe retornar los campos id y token

    Examples:
      |EMAIL                     |PASSWORD      |
      |eve.holt@reqres.in        |pistol        |

  Scenario Outline: Registro de usuario con error

#    Este escenario consiste intentar un registro con un error para validar el código de error.


    Given quiero registrar un nuevo usuario
    When registro solo el <EMAIL>
    Then el status code debe ser 400
    And debe retornar mensaje de error

    Examples:
      |EMAIL                     |
      |sydney@fife               |
