package com.nttdata.stepsdefinitions;

import com.nttdata.steps.GuruLoginSteps;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.RaissaLoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RaissaStepsDef {
    private WebDriver driver;
    private Scenario scenario;

    private RaissaLoginSteps raissaLoginSteps;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }
    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("Estoy en la pagina de inicio de Raissa")
    public void estoyEnLaPaginaDeInicioDeRaissa() {
        driver.get("https://raissamotors.com/login");
        screenShot();
    }

    @When("ingreso mis usuario {string} y password {string}")
    public void ingresoMisUsuarioYPassword(String user, String password) {
        raissaLoginSteps = new RaissaLoginSteps(driver);
        raissaLoginSteps.typeUser(user);
        raissaLoginSteps.typePassword(password);
        screenShot();
    }

    @Then("hago click en boton inciar")
    public void hagoClickEnBotonInciar() {
        raissaLoginSteps.login();
        screenShot();
    }

    @And("valido que estoy logueado correctamente en Raissa")
    public void validoQueEstoyLogueadoCorrectamenteEnRaissa(){

    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
