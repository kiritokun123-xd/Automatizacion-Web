@LoginLinio

Feature: Login Linio
  Scenario: Login  incorrecto a Linio
    Given Estoy en la pagina de inicio de Linio
    When ingreso mis usuario "david22android@gmail.com" y password "noespassword" en Linio
    Then hago click en boton inciar sesion
    And valido mensaje de credenciales erroneas