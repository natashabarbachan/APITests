# language: en
# encoding: utf-8

Feature: Berry

  Scenario: Print the first 10 berries
    Given there are "10" berries
    When limit the berry endpoint
    Then print the name of the first 10 berries