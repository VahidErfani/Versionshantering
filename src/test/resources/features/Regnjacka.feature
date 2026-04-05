Feature: Cross browser testing - DuckDuckgo

  Scenario Outline: Sök regnjacka i olika webbläsare
    Given jag öppnar webbläsaren i "<browser>"
    And jag går till "https://duckduckgo.com"
    When jag söker efter "regnjacka"
    And jag klickar på naturkompaniet
    Then ska titeln innehålla "Regnjackor | Köp online | Naturkompaniet"

    Examples:
      | browser |
      | Chrome  |
      | Firefox |
      | Edge    |


