# language: en
# encoding: utf-8

Feature: Evolution Trigger

  Scenario Outline: Validate PokemonName for each Evolution Trigger
    Given it has a evolution trigger named "<name>"
    When the url for this evolution trigger is requested
    Then the "<pokemonName>" is returned

    Examples:
      | name    | pokemonName |
      | level-up   | ivysaur  |
      | trade | alakazam     |
      | use-item | raichu    |
      | shed     | shedinja  |
      | spin     | alcremie  |
      | tower-of-darkness | urshifu |
      | tower-of-waters   | urshifu |
      | three-critical-hits | sirfetchd |
      | take-damage         | runerigus |
      | other               | pawmot    |
      | agile-style-move    | wyrdeer   |
      | strong-style-move   | overqwil  |
      | recoil-damage       | basculegion |