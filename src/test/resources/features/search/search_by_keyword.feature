Feature: Conocer, aprender, interactuar con diferentes elementos
  de paginas de prueba.

  @ClickBotonLoginFacebook @Facebook
  Scenario Outline: interactuar con el boton Log in utilizando distintos metodos
    Given que el usuario se encuentre en la pagina inicial de facebook
    When da click en el boton log in utilizando el metodo "<metodo>"
    Then visualizara la pagina de facebook con el texto "Find your account and log in."
    Examples:
      | metodo         |
      | ContainingText |
      | WithNameOrId   |
