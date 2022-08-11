@LoginLinio

Feature: Login Linio
  Scenario: Login  incorrecto a Linio
    Given Estoy en la pagina de inicio de Linio
    When ingreso mi usuario "david22android@gmail.com" y password "movistar16" en Linio
    And hago click en boton inciar sesion
    Then valido que estoy logueado con usuario "David Angel"
    And hago click en boton mejores calificados
    And hago click en un producto
    And hago click en añadir carrito
    And valido que se añadió al carrito