Feature: List users from the List Users Api
  As an automator I want to consume the API to test it.

  @LstUser
  Scenario: Consume the List User api
    When The system consumes the Api_Consult_Single_User api
    Then The system validates that the response is successful