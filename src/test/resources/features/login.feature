Feature: Login de usuarios

  Scenario Outline: Loguearse de manera exitosa con email y password

#    Este escenario consiste realizar un login exitoso y obtener el token de autenticación


    Given quiero realizar el logueo exitoso
    When ingreso las credenciales <EMAIL>,<PASSWORD>
    Then el status code debe ser 200
    And debe retornar el campo token

    Examples:
      |EMAIL                     |PASSWORD      |
      |eve.holt@reqres.in        |cityslicka    |

  Scenario Outline: Loguearse con parametros incompletos

#    Este escenario consiste realizar un login con parámetros incompletos y validar el mensaje de error


    Given quiero realizar el logueo con parametros incompletos
    When ingreso solo <EMAIL>
    Then el status code debe ser 400
    And debe retornar mensaje de error

    Examples:
      |EMAIL                     |
      |eve.holt@reqres.in        |