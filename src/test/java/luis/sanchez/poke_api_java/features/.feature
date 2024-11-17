Feature: Get Pokemon Details
  Scenario: Consult a exising pokemon
    Given The pokemon name is "pikachu"
    When I consult the pokemon details
    Then the request name is "pikachu"