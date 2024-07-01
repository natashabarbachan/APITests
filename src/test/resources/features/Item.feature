# language: en
# encoding: utf-8

Feature: Item

  Scenario: Validate Item category
    Given an item named "great-ball"
    When the url for this item id is requested
    Then the category name should be "standard-balls"

  Scenario: (Negative Scenario) Validate Status Code when the searched item does not exist
    Given a non-existent item called "abc"
    When the url for this item is requested
    Then the status code should be 404 Not Found