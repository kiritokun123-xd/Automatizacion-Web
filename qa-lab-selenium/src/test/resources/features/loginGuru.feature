@LoginGuru

Feature: Login Guru Bank
  Scenario: Login  a Guru
    Given Estoy en la pagina de inicio de Guru
    When ingreso mis credenciales "mngr430317" y "desAjEm"
    Then hago click en boton login
    And valido que estoy logueado correctamente