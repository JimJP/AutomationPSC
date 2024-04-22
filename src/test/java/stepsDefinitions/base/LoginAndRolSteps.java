package stepsDefinitions.base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.RolPage;
import utils.Constants_Vars;

public class LoginAndRolSteps extends BasePage {

    public LoginAndRolSteps() {
        super(driver);
    }

    LoginPage loginPage = new LoginPage();
    RolPage rolPage = new RolPage();

    @Given("^Inicio sesión en AppBuilder Desarrollo$")
    public void iniciarSesionAppBuilder() {
        visitUrl(Constants_Vars.URL_DESAROLLO);
        loginPage.login();
        loginPage.validarInicioSesion();
    }

    @Given("Ingreso al modulo SISCO")
    public void ingresoModuloSisco(){
        rolPage.ingresoModuloSisco();
    }
    @And("Selecciono el rol Usuario PSC e ingreso al sistema")
    public void seleccionarRolYModuloPsc(){
        rolPage.seleccionarRolYModuloPsc();
    }

}
