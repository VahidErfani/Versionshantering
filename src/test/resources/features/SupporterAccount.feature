Feature: Registrera ny supporter

  Scenario: Skapa konto, allt går bra

    Given jag är på registreringssidan
    When jag fyller i alla mina personuppgifter korrekt
    And jag godkänner alla villkor
    And jag klickar på knappen för att gå med
    Then ska jag få se en bekräftelse

  Scenario: Efternamn saknas

    Given jag är på registreringssidan
    When jag fyller i allt förutom efternamn
    And jag godkänner alla villkor
    And jag klickar på knappen för att gå med
    Then ska jag se ett felmeddelande som säger "Last Name is required"


  Scenario: Lösenord matchar inte

    Given jag är på registreringssidan
    When jag fyller i allt korrekt men med olika lösenord "okej55" och "okej23"
    And jag godkänner alla villkor
    And jag klickar på knappen för att gå med
    Then ska jag se ett felmeddelande som säger "Password did not match"


  Scenario: Terms och conditions är inte godkänt

    Given jag är på registreringssidan
    When jag fyller i alla mina personuppgifter korrekt
    And jag godkänner alla villkor förutom terms and condition
    And jag klickar på knappen för att gå med
    Then ska jag se ett felmeddelande som säger "You must confirm that you have read and accepted our Terms and Conditions"


  Scenario Outline: Registrera ny supporter VG

    Given jag öppnar registreringssidan i "<webblasare>"
    When jag fyller i alla mina personuppgifter korrekt
    And jag godkänner alla villkor
    And jag klickar på knappen för att gå med
    Then ska jag få se en bekräftelse





    Examples:
      | webblasare |
      | chrome     |
      | edge       |
      | firefox    |
