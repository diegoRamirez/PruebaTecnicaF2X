# Prueba Técnica de Automatización de API para F2X

Este es un proyecto esta construido para implementar la prueba técnica de F2X que consiste en automatizar pruebas para el API REST de https://reqres.in/.
En el, se crearon tres features con diferentes escenarios que se listan a continuación:

### login
Este feature contiene dos escenarios relacionados con la funcionalidad de login:
1. Loguearse de manera exitosa con email y password
2. Loguearse con parámetros incompletos

### RegisterUser
En este feature se agregaron los escenarios concernientes al registro de usuarios así:
1. Registro de usuarios
2. Registro de usuarios con error

### manageUser
En este feature se encuentran  los escenarios necesarios para validar el correcto funcionamiento del CRUD de usuarios.
Los escenarios planteados son los siguientes:
1. Crear un nuevo usuario
2. Editar usuario
3. Obtener los datos de un usuario a traves de su ID
4. Validar respuesta cuando el ID del usuario no existe
5. Eliminar un usuario


### Estructura del proyecto
El proyecto cuenta con una estructura diseñada para implementar el patron screenplay
```Gherkin
src
  + main
    + java
      + models
      + questions
      + utils
  + test
    + java
      + runners
      + stepDefinitions                        
    + resources
      + features

Para facilitar la implementación del patrón screenplay, se crearon carpetas así:

### models
En este paquete se creo la clase User para modelar las propiedades del usuario

### questions
En este paquete se encuentran las clases utilizadas para realizar las aserciones y validaciones de acuerdo al patrón scrennplay

### utils
Se creó este paquete para implementar clases con utilidades transversales

### test/java
Dentro de este paquete se encuentran los runners para ejecutar los test y los stepDefinitions que son la capa donde se desarrolla la lógica para la implementación de los test.           
    
```






 

 




  
