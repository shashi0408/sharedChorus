Feature: As an internet user,I want to know which Chorus services
  are available to me,so that I can decide on the service I want to order

  @UI
Scenario Outline: Search for address and check the available services
    Given Go to the Chorus Service
When User want to check service on particular address <Address>
    Then User verifies the possible services and prints the results
    Examples:
    |Address                      |
    |   1/33 Littlejohn Street    |


