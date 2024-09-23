@SauceLabsApp
Feature: Sauce Labs App

  @CarritoDeCompras
  Scenario Outline: Agregar en carrito de compras
    Given estoy en la aplicacion de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto <PRODUCTO>
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                    | UNIDADES |
      | Sauce Labs Backpack         | 5        |
      | Sauce Labs Fleece Jacket    | 3        |
      | Sauce Labs Bolt T-Shirt     | 3        |
      | Test.sllTheThings() T-Shirt | 3        |
      | Sauce Labs Onesie           | 1        |
      | Sauce Labs Bike Light       | 2        |
