Feature: Webshop Navigation

  Scenario: Kontrollera Books-sidan laddas rätt
    Given jag är på startsidan för demowebshop
    When jag klickar på books
    Then ska rubriken vara books
