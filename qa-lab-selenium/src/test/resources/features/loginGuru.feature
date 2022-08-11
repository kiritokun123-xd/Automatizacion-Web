@LoginGuru

Feature: Login Guru Bank
  Scenario: Login  a Guru
    Given Estoy en la pagina de inicio de Guru
    When ingreso mis credenciales "david22android@gmail.com" y "movistar16"
    Then hago click en boton login
    And valido que estoy logueado correctamente