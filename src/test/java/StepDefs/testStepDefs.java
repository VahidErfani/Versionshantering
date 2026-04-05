package StepDefs;

import io.cucumber.java.en.Given;

public class testStepDefs {

    public class TestStepDefs {

        @Given("jag skriver ut ett meddelande i konsolen")
        public void testMeddelande() {
            System.out.println("******************************************");
            System.out.println("DET FUNGERAR! CUCUMBER HITTADE KODEN!");
            System.out.println("******************************************");
        }
    }
}
