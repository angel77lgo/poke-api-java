Feature: Get Pokemon Details
  Scenario: Consult a exising pokemon
    Given The pokemon name is "pikachu"
    When I consult the pokemon details
    Then the request name is "pikachu"
  Scenario: Consult a existing pokemon by id
    Given The pokemon id is 1
    When I consult the pokemon details id
    Then the request name is "bulbasaur" id