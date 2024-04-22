package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants_Vars;

import java.time.Duration;

public class LoginPage extends BasePage{

    By input_User = By.id("txtUsuario"); // Ingrese usuario
    By input_Password = By.id("txtPassword"); // Ingrese contaseña
    By btn_IniciarSesion = By.id("btnIngresar"); // Botón Ingresar
    By txt_Logo = By.id("logo-titulo"); // Logo al iniciar sesion

    public LoginPage() {
        super(driver);
    }

    public void login (){
        type(Constants_Vars.USER_DESARROLLO, input_User);
        type(Constants_Vars.USER_PASSWORD_DESARROLLO, input_Password);
        click(btn_IniciarSesion);
    }

    public void validarInicioSesion() {
        WebElement txt_LogoWebElemnt = findElement(txt_Logo); //El elemento localizado en By tuvo que ser encapsulado en un WebElement para que pueda interactuar con el Assertion

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(txt_LogoWebElemnt));
        Assert.assertTrue( "Sistema Integrado de Seguridad", txt_LogoWebElemnt.isDisplayed());
    }
}
