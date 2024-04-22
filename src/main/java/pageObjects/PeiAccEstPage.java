package pageObjects;

import org.openqa.selenium.By;

public class PeiAccEstPage extends BasePage{

    By menuAccionesEstrategicas = By.xpath("//span[contains(.,'Acciones estratégicas')]");
    By validarIngresoMenuAccionesEstrategicas = By.xpath("//b[contains(.,'Acciones Estratégicas')]");
    By seleccionarAcciones = By.xpath("//div[contains(@data-dx_placeholder,'Seleccionar una accion')]");
    By seleccionarNuevo = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'Nuevo')]");
    By validarIngresoNuevoAccionEstrategica = By.xpath("//h6[@class='caption'][contains(.,'Registro de Acciones Estratégicas')]");
    By seleccionarComboBoxPei = By.xpath("(//div[contains(@data-dx_placeholder,'Seleccione')])[2]"); //El elemento es dinamico por eso se ubica por su ubicación en el DOM
    By seleccionarPei = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'2024-2025 Versión 2')]");
    By seleccionarComboBoxObjetivo = By.xpath("(//div[contains(@data-dx_placeholder,'Seleccione')])[3]");
    By seleccionarObjetivo = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'OBJ TEST 1')]");

    public PeiAccEstPage() {
        super(driver);
    }

    public void ingresarMenuAccionesEstrategicas(){
        try { //Si el elemento está presente se continua con la lógica del código, sino se detiene con una excepción
            //Thread.sleep(1000);
            waitForByLocatorVisibilityOfElementLocated(menuAccionesEstrategicas); //Valido que el elemento este en el código y visible para el usuario
            waitForByLocatorToBeClickeableAndClick(menuAccionesEstrategicas);
        } catch (Exception e) {
            System.out.println("El elemento Acciones Estrategicas no ha podido ser clickeado");
        }
    }

    public void seleccionarNuevaAccionEstrategica(){
        waitForByLocatorPresenceOfElementLocated(validarIngresoMenuAccionesEstrategicas);
        click(seleccionarAcciones);
        click(seleccionarNuevo);
        waitForByLocatorPresenceOfElementLocated(validarIngresoNuevoAccionEstrategica);
    }

    public void completarFormularioAccionesEstrategicas(){
        click(seleccionarComboBoxPei);
        click(seleccionarPei);
    }

    public void mostrarMensajeAccionEstrategicaCreada(){

    }
}
