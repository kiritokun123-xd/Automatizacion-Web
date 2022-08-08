@LoginRaissa

Feature: Login RaissaMotors
  Scenario: Login  correcto a Raissa
    Given Estoy en la pagina de inicio de Raissa
    When ingreso mis usuario "coseca@coseca.com" y password "123456"
    Then hago click en boton inciar
    And valido que estoy logueado correctamente en Raissa