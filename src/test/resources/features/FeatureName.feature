Feature: Hantera min att göra lista

  Background:
    Given jag skapar en lista

  Scenario: Lägga till en ny uppgift
    When jag lägger till "mjölk" i listan
    And jag lägger till "bröd" i listan
    And jag markerar uppgift 1 som klar
    And jag markerar uppgift 2 som klar
    Then ska listan innehålla 2 uppgift
    And ska listan ha 2 färdig uppgift


  Scenario: Lägga till en ny uppgift
    When jag lägger till "pizzabröd" i listan
    And jag lägger till "mozzarella" i listan
    And jag lägger till "kebab" i listan
    And jag markerar uppgift 1 som klar
    And jag markerar uppgift 2 som klar
    And jag markerar uppgift 3 som klar
    Then ska listan innehålla 3 uppgift
    And ska listan ha 3 färdig uppgift


  Scenario: Markera en uppgift som inte existerar
    When jag lägger till "mjölk" i listan
    And jag markerar uppgift 5 som klar
    Then ska listan innehålla 1 uppgift
    And ska listan ha 0 färdig uppgift

  Scenario: Lura systemet
    When jag lägger till "mjölk" i listan
    And jag markerar uppgift 100 som klar
    Then ska listan ha 0 färdig uppgift

  Scenario: Dubbelklicka på klar
    When jag lägger till "mjölk" i listan
    And jag markerar uppgift 1 som klar
    And jag markerar uppgift 1 som klar
    Then ska listan ha 1 färdig uppgift

  Scenario: Radera en uppgift från listan
    When jag lägger till "mjölk" i listan
    And jag lägger till "bröd" i listan
    And jag raderar uppgift 1
    Then ska listan innehålla 1 uppgift