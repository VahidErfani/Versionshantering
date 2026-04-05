package StepDefs;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import todo.TodoList;

public class MyStepdefs {

    TodoList todoList;

    @Given("jag skapar en lista")
    public void jag_skapar_en_lista() {
        todoList = new TodoList();

    }

    @When("jag lägger till {string} i listan")
    public void jag_lägger_till_i_listan(String uppgift) {
        todoList.addTask(uppgift);

    }

    @When("jag markerar uppgift {int} som klar")
    public void jag_markerar_uppgift_som_klar(int nummer) {
        todoList.completeTask(nummer - 1);
    }

    @Then("ska listan innehålla {int} uppgift")
    public void ska_listan_innehålla_uppgift(int förväntatAntal) {
        int antalUppgifter = todoList.getNbrOfTasks();

        System.out.println("Antal uppgifter totalt: " + antalUppgifter);

        Assert.assertEquals(förväntatAntal, antalUppgifter);


    }

    @Then("ska listan ha {int} färdig uppgift")
    public void ska_listan_ha_färdig_uppgift(int förväntatAntal) {
        int färdigaUppgifter = todoList.getFinishedTasks();

        System.out.println("Antal färdiga uppgift: " + färdigaUppgifter);

        Assert.assertEquals(förväntatAntal, färdigaUppgifter);
    }

    @Before
    public void setUp() {
        todoList = new TodoList();

    }

    @After
    public void tearDown() {
        todoList = null;
    }


}