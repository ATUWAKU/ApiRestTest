Feature: List users from the List Users Api
  As an automator I want to consume the API to test it.

  Scenario: Consume the List User api
    When The system consumes the Api_List_Resources api
    Then The system validates that the response is successful