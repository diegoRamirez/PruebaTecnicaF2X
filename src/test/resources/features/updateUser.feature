Feature: Editar información de usuarios

  Scenario Outline: Editar usuario

#    Este escenario consiste en editar exitosamente la información de un usuario
#    utilizando un método PUT. Se validará que el status code sea 200 y que en el response regresen los datos como se ingresaron
#    en el request



    Given quiero editar la informacion de un usuario
    When edito los datos del <ID>,<NAME>,<JOB>
    Then el status code debe ser  200
    And debe retornar los datos ingresados <NAME>, <JOB>

    Examples:
     |ID|NAME                      |JOB        |
     |1 |Ramón Valdéz              |Desempleado|
     |2 |Señor barriga             |Arrendador |