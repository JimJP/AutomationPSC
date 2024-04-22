package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PeiListadoPage extends BasePage{

    //LOCALIZADORES NUEVO PEI 2024-2026
    By menuListadoPei = By.xpath("//li/div/div/span[contains(.,'Listado PEI')]");
    By seleccionarBtnAcciones = By.xpath("//div[contains(@data-dx_placeholder,'Seleccionar una accion')]");
    By seleccionarAccionNuevoPei = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'Crear nuevo PEI')]");
    public PeiListadoPage() {
        super(driver);
    }

    public void ingresarMenuListadoPei(){
        try{
            waitForByLocatorToBeClickeableAndClick(menuListadoPei);
        } catch (NoSuchElementException e){
            System.out.println("El Menú Listado PEI no se encontró y no se pudo hacer clic");
        }

    }

    public void seleccionarNuevoRegistroPei(){
        waitForByLocatorPresenceOfElementLocatedAndClick(seleccionarBtnAcciones);
        waitForByLocatorPresenceOfElementLocatedAndClick(seleccionarAccionNuevoPei);

    }

    public void completarFormularioNuevoPei(){

    }

    public void validarRegistroExitosoNuevoPei(){

    }


}
