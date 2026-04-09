package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupporterStepDefs {

    WebDriver driver;

    @Given("jag är på registreringssidan")
    public void jag_är_på_registreringssidan() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Erfani/Documents/Skola/Register.html");

    }

    @When("jag fyller i alla mina personuppgifter korrekt")
    public void jag_fyller_i_alla_mina_personuppgifter_korrekt() {
        driver.findElement(By.cssSelector(".custom-date")).sendKeys("13051994");
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Vahid");
        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Erfani");
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys("okej55");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys("okej55");

    }

    @And("jag godkänner alla villkor")
    public void jag_godkänner_alla_villkor() {
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

    }

    @And("jag klickar på knappen för att gå med")
    public void jag_klickar_på_knappen_för_att_gå_med() {
        driver.findElement(By.cssSelector(".btn-big")).click();

    }

    @Then("ska jag få se en bekräftelse {string}")
    public void ska_jag_få_se_en_bekräftelse(String bekraftelse) {
        WebElement element = driver.findElement(By.cssSelector("h5.bold"));

        String actual = element.getText();
        String expected = bekraftelse;

        Assert.assertEquals(actual, expected);

    }

    @When("jag fyller i allt förutom efternamn")
    public void jag_fyller_i_allt_förutom_efternamn() {
        driver.findElement(By.cssSelector(".custom-date")).sendKeys("13051994");
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Vahid");
        driver.findElement(By.cssSelector("#member_lastname")).clear();
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys("okej55");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys("okej55");

    }

    @When("jag fyller i allt korrekt men med olika lösenord {string} och {string}")
    public void jag_fyller_i_allt_korrekt_men_med_olika_lösenord(String pw1, String pw2) {
        driver.findElement(By.cssSelector(".custom-date")).sendKeys("13051994");
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Vahid");
        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Erfani");
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']")).sendKeys("vahid_erfani@hotmail.com");
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(pw1);
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys(pw2);

    }

    @Then("ska jag se ett felmeddelande som säger {string}")
    public void ska_jag_se_ett_felmeddelande_som_säger(String felMeddelande) {
        vantaPaElement(By.cssSelector(".field-validation-error"));

        WebElement element = driver.findElement(By.cssSelector(".field-validation-error"));

        String actual = element.getText();
        String expected = felMeddelande;

        Assert.assertEquals(actual, expected);

    }

    @And("jag godkänner alla villkor förutom terms and condition")
    public void jag_godkänner_alla_villkor_förutom_terms_and_condition() {
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

    }

    @Given("jag öppnar registreringssidan i {string}")
    public void jag_öppnar_registreringssidan_i(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("file:///C:/Users/Erfani/Documents/Skola/Register.html");

    }


    private void vantaPaElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}