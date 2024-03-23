Feature: Administrar usuarios

  Scenario Outline: Crear un nuevo usuario

#    Este escenario consiste en crear un nuevo usuario ingresando su nombre y su trabajo
#    Para validar el correcto funcionamiento del servicio, se verificará que el código
#    de respuesta sea 201 y que retorne el nombre y teléfono ingresado y un id.



    Given quiero crear un nuevo usuario
    When ingreso los datos <NAME>,<JOB>
    Then el status code debe ser  201
    And debe retornar los datos ingresados <NAME>, <JOB>

    Examples:
      |NAME                      |JOB        |
      |Ramón Valdéz              |Desempleado|
      |Señor barriga             |Arrendador |