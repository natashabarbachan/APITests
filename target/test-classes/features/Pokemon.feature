# language: en
# encoding: utf-8

Feature: Pokemon

  Scenario Outline: Validate Pokemon ID
    Given it has a pokemon named "<name>"
    When get id from pokemon endpoint
    Then the id <number> is returned

    Examples:
      | name    | number |
      | Ditto   | 132    |
      | Pikachu | 25     |

  Scenario: Validate Pokemon Ability
    Given it has a pokemon named "Ditto"
    And get ability from pokemon endpoint
    Then the ability "imposter" is returned

  Scenario: Validate Pokemon Move
    Given it has a pokemon named "Ditto"
    When get move from pokemon endpoint
    Then the move "transform" is returned

  Scenario: Print all 150 Pokemon
    Given there is "150" pokemon
    When limit the pokemon endpoint
    Then it should print all the names

  Scenario: Validate URL using paginate endpoint
    Given there is "150" pokemon
    When get the url from pokemon "venusaur"
    Then it should be the same name on pokemon endpoint

#  Scenario: Validate Accuracy and Short_effect
#    Given it has a pokemon named "Ditto"
#    When get the move URL
#    Then it should be validate the fields
#      | Accuracy    | 95                                                 |
#      | ShortEffect | Inflicts regular damage with no additional effect. |

