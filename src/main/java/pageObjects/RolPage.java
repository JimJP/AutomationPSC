package pageObjects;

import org.openqa.selenium.By;

public class RolPage extends BasePage{

    By btnModuloSiscoPsc = By.xpath("//a[contains(@title,'SISTEMA DE CONTROL SISCO  - PAGINA CONEXION SCA')]");
    By labelValidarUser = By.xpath("//span[contains(.,'E00850 JOSE JIM JULCA PALOMINO')]"); //Validar ingreso Modulo Sisco
    By divAfterValidarUser = By.cssSelector(".dx-overlay-wrapper");
    By listboxRol = By.xpath("//div[contains(@class,'dx-dropdowneditor-input-wrapper dx-selectbox-container')]"); //ComboBox Rol
    By listboxSelectRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'USUARIO')]"); //Selecionar Rol Usuario PSC
    By divAfterSelectRol = By.cssSelector(".dx-overlay-wrapper");
    By btnModuloPsc = By.xpath("//a[@class='btn btn-sq-lg button-square m-2'][contains(.,'PSC')][2]"); //Seleccionar modulo PSC

    public RolPage() {
        super(driver);
    }

    public void ingresoModuloSisco() {
        click(btnModuloSiscoPsc);
    }

    public void seleccionarRolYModuloPsc(){
        waitForByLocatorPresenceOfElementLocated(labelValidarUser); //espero que el elemento este presente en un max de 10 seg
        waitForByLocatorInvisibilityOfElementLocated(divAfterValidarUser);
        waitForByLocatorToBeClickeableAndClick(listboxRol);
        waitForByLocatorToBeClickeableAndClick(listboxSelectRol);
        waitForByLocatorInvisibilityOfElementLocated(divAfterSelectRol);
        waitForByLocatorToBeClickeableAndClick(btnModuloPsc);
    }
}
