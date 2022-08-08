package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LinioLoginSteps;
import com.nttdata.steps.RaissaLoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioStepsDef {

    private WebDriver driver;
    private Scenario scenario;

    private LinioLoginSteps linioLoginSteps;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

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


    @Given("Estoy en la pagina de inicio de Linio")
    public void estoyEnLaPaginaDeInicioDeLinio() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @When("ingreso mis usuario {string} y password {string} en Linio")
    public void ingresoMisUsuarioYPasswordEnLinio(String user, String password) {
        linioLoginSteps = new LinioLoginSteps(driver);
        linioLoginSteps.typeUser(user);
        linioLoginSteps.typePassword(password);
        screenShot();
    }

    @Then("hago click en boton inciar sesion")
    public void hagoClickEnBotonInciarSesion() {
        linioLoginSteps.login();
        screenShot();
    }


    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @And("valido mensaje de credenciales erroneas {string}")
    public void validoMensajeDeCredencialesErroneas(String expectedTitle) {
        String title =  inventorySteps(driver).getTitle();
        //prueba: validamos el título del error
        Assertions.assertEquals(expectedTitle, title);
    }
}
