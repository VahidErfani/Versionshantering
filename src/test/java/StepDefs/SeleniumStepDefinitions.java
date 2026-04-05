package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumStepDefinitions {
    WebDriver driver;

    @Given("jag öppnar webbläsaren i {string}")
    public void jag_öpnar_webbläsaren_i(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

    }

    @Given("jag går till {string}")
    public void jag_går_till(String url) {

        driver.get(url);

    }

    @When("jag söker efter {string}")
    public void jag_söker_efter(String sökord) {


    }

    @When("jag klickar på naturkompaniet")
    public void jag_klickar_på_naturkompaniet() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#r1-2")).click();

}

@Then("ska titeln innehålla {string}")
    public void ska_titel_innehålla(String expectedTitle) {
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);

        driver.quit();
}


    }

