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

    @When("ingreso mi usuario {string} y password {string} en Linio")
    public void ingresoMiUsuarioYPasswordEnLinio(String user, String password) {
        linioLoginSteps = new LinioLoginSteps(driver);
        linioLoginSteps.typeUser(user);
        linioLoginSteps.typePassword(password);
        screenShot();
    }

    @And("hago click en boton inciar sesion")
    public void hagoClickEnBotonInciarSesion() {
        linioLoginSteps.login();
        screenShot();
    }

    @Then("valido que estoy logueado con usuario {string}")
    public void validoQueEstoyLogueadoConUsuario(String name) {
        linioLoginSteps.getTitle();
        screenShot();
    }



    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @And("hago click en boton mejores calificados")
    public void hagoClickEnBotonMejoresCalificados() {
        linioLoginSteps.bestClick();
        screenShot();
    }

    @And("hago click en un producto")
    public void hagoClickEnUnProducto() {
        linioLoginSteps.productClick();
        screenShot();
    }

    @And("hago click en añadir carrito")
    public void hagoClickEnAñadirCarrito() {
        linioLoginSteps.carClick();
        screenShot();
    }

    @And("valido que se añadió al carrito")
    public void validoQueSeAñadióAlCarrito() {
        linioLoginSteps.getMessageTitle();
        screenShot();
    }
}
