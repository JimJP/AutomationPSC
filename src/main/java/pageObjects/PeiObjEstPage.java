package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class PeiObjEstPage extends BasePage {

    //LOCALIZADORES NUEVO REGISTRO OBJETIVOS ESTRATEGICOS
    By menuObjetivosEstrategicos = By.xpath("//div[@class='dx-item-content dx-treeview-item-content'][contains(.,'Objetivos estratégicos')]"); //Menú Objetivos Estrategicos
    By validarIngresoMenuObjetivosEstrategicos = By.xpath("//b[contains(.,'Listado de Objetivos Estratégicos')]");
    By seleccionarAcciones = By.xpath("//div[contains(@data-dx_placeholder,'Seleccionar una accion')]");
    By seleccionarAccionNuevo = By.xpath("//div[@class='dx-item dx-list-item'][contains(.,'Nuevo')]");
    By validarIngresoNuevoObjetivosEstrategicos = By.xpath("//h6[@class='caption'][contains(.,'Registrar Objetivo Estratégico')]");
    By seleccionarComboBoxPei = By.xpath("(//input[contains(@class,'dx-texteditor-input')])[4]"); //Se utiliza para seleccionar el cuarto elemento <input> que contiene la clase 'dx-texteditor-input'
    By seleccionarPei = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'2024-2025 Versión 2')]");
    By seleccionarComboBoxObjNac = By.xpath("(//input[@class='dx-texteditor-input'])[5]"); //Se utiliza para seleccionar el cuarto elemento <input> que contiene la clase 'dx-texteditor-input'
    By seleccionarObjNac = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Gestionar el territorio de manera sostenible')]");
    By seleccionarComboBoxObjNacEsp = By.xpath("(//input[contains(@class,'dx-texteditor-input')])[6]");
    By seleccionarObjNacEsp = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Reducir la vulnerabilidad ante el riesgo de desastres')]");
    By campoEnunciado = By.xpath("//input[contains(@name,'enunciadoOE')]");
    By campoDescripcion = By.xpath("//textarea[contains(@class,'dx-texteditor-input')]");
    By campoExplicacionRelCas = By.xpath("//div[contains(@class,'ql-editor')]");
    By seleccionarComboBoxPrioridad = By.xpath("(//input[contains(@class,'dx-texteditor-input')])[12]");
    By seleccionarPrioridad = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'3')]");
    By btnGuardar = By.xpath("//cgr-button[@buttontype='primary'][contains(.,'Guardar')]");
    By msjRegistroExitoso = By.xpath("//p[contains(.,'El registro se realizó correctamente')]");

    //LOCALIZADORES EDITAR REGISTRO OBJETIVO ESTRATEGICO
    By seleccionarComboBoxEstadoPei = By.xpath("//input[contains(@aria-required,'true')]");
    By seleccionarEstadoPei = By.xpath("//span[contains(.,'En Proceso')]");
    By btnBuscarObjEst = By.xpath("//span[@class='dx-button-text'][contains(.,'Buscar')]");
    By siguientePaginaGrilla = By.xpath("//div[@class='dx-page'][contains(.,'2')]");
    By validarIngresoEditarObjetivoEstrategico = By.xpath("//h6[@class='caption'][contains(.,'Modificar Objetivo Estratégico')]");
    By editarSeleccionarObjNac = By.xpath("(//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Garantizar una sociedad justa, democrática, pacífica')])[1]");
    By editarSeleccionarObjNacEsp = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Garantizar intervenciones públicas')]");
    By editarSeleccionarPrioridad = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'5')]");
    By editarCantAccionesEstrategicas = By.xpath("//input[@autocomplete='off'][contains(@id,'cantAccEstrategicas')]");
    By editarCodigo = By.xpath("//input[@name='codigoOE'][contains(@role,'textbox')]");
    By btnGuardarEditar = By.xpath("//div[@class='dx-button-content'][contains(.,'Guardar')]");
    By msjEdicionExitoso = By.xpath("//p[contains(.,'La modificación se realizó correctamente')]");
    By cerrarMsjEdicionExitoso = By.xpath("//div[@class='dx-button-content'][contains(.,'Cerrar')]");

    //LOCALIZADORES ELIMINAR REGISTRO OBJETIVO ESTRATEGICO
    By aceptarMensajeEliminacion = By.xpath("//div/cgr-button/dx-button[contains(@aria-label,'Si')]");
    By msjEliminacionExitosa = By.xpath("//p[contains(.,'Acción ejecutada con éxito')]");
    By cerrarMsjEliminacionExitoso = By.xpath("//div/cgr-button/dx-button[contains(@aria-label,'Cerrar')]");

    // LOCALIZADOR DINAMICOS

    WebElement btnEditarObjetivoEstrategico;
    WebElement BtnEditarObjetivoEstrategico(String nombreOeEditar) {
        //El simbolo '%s' linea abajo indica que el texto será almacenado en la variable String nombreOE
        String xpathBtnEditObjetivoEstrategico = String.format("//tr[td[contains(text(),'%s')]]/td/div/span/dx-button[@aria-label='edit']", nombreOeEditar);
        btnEditarObjetivoEstrategico = driver.findElement(By.xpath(xpathBtnEditObjetivoEstrategico));
        return btnEditarObjetivoEstrategico;
    }

    WebElement btnEliminarObjetivoEstrategico;
    WebElement BtnEliminarObjetivoEstrategico(String nombreOeEliminar){
        //El simbolo '%s' linea abajo indica que el texto será almacenado en la variable String nombreOeEliminar
        String xpathBtnEliminarObjetivoEstrategico = String.format("//tr[td[contains(text(),'%s')]]/td/div/span/dx-button[@aria-label='remove']", nombreOeEliminar);
        btnEliminarObjetivoEstrategico = driver.findElement(By.xpath(xpathBtnEliminarObjetivoEstrategico));
        return btnEliminarObjetivoEstrategico;
    }

    public PeiObjEstPage() {
        super(driver);
    }

    // CREAR NUEVO REGISTRO OBJETIVO ESTRATEGICO
    public void ingresarMenuObjetivosEstrategicos() {
        try { //Si el elemento está presente se continua con la lógica del código, sino se detiene con una excepción
            //Thread.sleep(1000);
            waitForByLocatorVisibilityOfElementLocated(menuObjetivosEstrategicos); //Valido que el elemento este en el código y visible para el usuario
            waitForByLocatorToBeClickeableAndClick(menuObjetivosEstrategicos);
        } catch (Exception e) {
            System.out.println("El elemento Objetivo Estrategico no ha podido ser clickeado");
        }
    }

    public void seleccionarNuevoRegistroObjEst() {
        waitForByLocatorPresenceOfElementLocated(validarIngresoMenuObjetivosEstrategicos); //espero que aparezca el elemento para continuar con la logica
        click(seleccionarAcciones);
        click(seleccionarAccionNuevo);
    }

    public void completarFormularioObjEst(String enunciado, String descripcion, String explicacion) { //Los String son los campos de texto del formulario
        waitForByLocatorPresenceOfElementLocated(validarIngresoNuevoObjetivosEstrategicos); //espero que aparezca el elemento para continuar con la logica
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxPei);
        click(seleccionarPei);
        click(seleccionarComboBoxObjNac);
        click(seleccionarObjNac);
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxObjNacEsp);
        waitForByLocatorToBeClickeableAndClick(seleccionarObjNacEsp);
        click(campoEnunciado);
        waitForByLocatorPresenceOfElementLocatedAndWrite(enunciado, campoEnunciado);
        click(campoDescripcion);
        waitForByLocatorToBeClickeableAndWrite(descripcion, campoDescripcion);
        click(campoExplicacionRelCas);
        waitForByLocatorToBeClickeableAndWrite(explicacion, campoExplicacionRelCas);
        click(seleccionarComboBoxPrioridad);
        click(seleccionarPrioridad);
        click(btnGuardar);
    }

    public void validarRegistroExitoso() {
        waitForByLocatorVisibilityOfElementLocated(msjRegistroExitoso); //espero que el elemento este visible
        assertTrueGetTextAttributeForText("El registro se realizó correctamente", msjRegistroExitoso); //asertion donde el texto es lo esperado vs el webelement
    }
    //EDITAR REGISTRO OBJETIVO ESTRATEGICO

    public void utbicarRegistroGrillaEditar() throws InterruptedException {
        waitForByLocatorPresenceOfElementLocated(validarIngresoMenuObjetivosEstrategicos);
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxEstadoPei);
        waitForByLocatorToBeClickeableAndClick(seleccionarEstadoPei);
        waitForByLocatorToBeClickeableAndClick(btnBuscarObjEst);


        // INTERACTUAR CON LA TABLA Y HACER CLIC AL ÍCONO EDITAR
        String nombreOeEditar = "A ENUNCIADO AUTOMATION JJP"; //Viene de localizadores dinamicos donde se construyó el xpath manualmente por texto a buscar

        try {
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BtnEditarObjetivoEstrategico(nombreOeEditar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BtnEditarObjetivoEstrategico(nombreOeEditar));

        } catch (NoSuchElementException e) {
            System.out.println("El elemento no está presente en la primera página, buscando en la segunda página...");
            waitForByLocatorPresenceOfElementLocated(siguientePaginaGrilla);
            WebElement elementNextPagina = driver.findElement(siguientePaginaGrilla);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementNextPagina);
            waitForWebElementClickableAndClick(elementNextPagina);
            //waitForByLocatorPresenceOfElementLocated(siguientePaginaGrilla);
            System.out.println("antes de javascript");
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BtnEditarObjetivoEstrategico(nombreOeEditar));
            System.out.println("despues del primer javascript");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BtnEditarObjetivoEstrategico(nombreOeEditar));
        }

    }

    public void editarFormularioObjEst(String codigo, String enunciado, String descripcion, String explicacion, String accionesEst) {
        waitForByLocatorPresenceOfElementLocated(validarIngresoEditarObjetivoEstrategico);
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxObjNac);
        waitForByLocatorToBeClickeableAndClick(editarSeleccionarObjNac);
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxObjNacEsp);
        waitForByLocatorToBeClickeableAndClick(editarSeleccionarObjNacEsp);
        click(editarCodigo);
        byLocatorClear(editarCodigo);
        waitForByLocatorPresenceOfElementLocatedAndWrite(codigo, editarCodigo);
        click(campoEnunciado);
        byLocatorClear(campoEnunciado);
        waitForByLocatorPresenceOfElementLocatedAndWrite(enunciado, campoEnunciado);
        click(campoDescripcion);
        byLocatorClear(campoDescripcion);
        waitForByLocatorToBeClickeableAndWrite(descripcion, campoDescripcion);
        click(campoExplicacionRelCas);
        byLocatorClear(campoExplicacionRelCas);
        waitForByLocatorToBeClickeableAndWrite(explicacion, campoExplicacionRelCas);
        click(seleccionarComboBoxPrioridad);
        click(editarSeleccionarPrioridad);
        moveToElementByLocator(editarCantAccionesEstrategicas);
        //byLocatorClear(editarCantAccionesEstrategicas);
        //waitForByLocatorPresenceOfElementLocatedAndWrite(accionesEst, editarCantAccionesEstrategicas);
        waitForByLocatorAndClickAndWriteAndEnter(accionesEst, editarCantAccionesEstrategicas);
        moveToElementByLocator(btnGuardarEditar);
        waitForByLocatorToBeClickeableAndClick(btnGuardarEditar);
    }

    public void validarEdicionExitosa() {
        try {
            if (elementIsDisplayed(msjEdicionExitoso)) {
                click(cerrarMsjEdicionExitoso);
            }

        } catch (NoSuchElementException e) {
            System.out.println("La edición no fue exitosa, revisar...");
        }

    }

    //ELIMINAR REGISTRO GRILLA

    public void ubicarRegistroGrillaEliminar() throws InterruptedException {
        waitForByLocatorPresenceOfElementLocated(validarIngresoMenuObjetivosEstrategicos);
        waitForByLocatorToBeClickeableAndClick(seleccionarComboBoxEstadoPei);
        waitForByLocatorToBeClickeableAndClick(seleccionarEstadoPei);
        waitForByLocatorToBeClickeableAndClick(btnBuscarObjEst);


        // INTERACTUAR CON LA TABLA Y HACER CLIC AL ÍCONO EDITAR
        String nombreOeEliminar = "A ENUNCIADO AUTOMATION EDITADO"; //Viene de localizadores dinamicos donde se construyó el xpath manualmente por texto a buscar

        try {
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BtnEliminarObjetivoEstrategico(nombreOeEliminar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BtnEliminarObjetivoEstrategico(nombreOeEliminar));

        } catch (NoSuchElementException e) {
            System.out.println("El elemento no está presente en la primera página, buscando en la segunda página...");
            waitForByLocatorPresenceOfElementLocated(siguientePaginaGrilla);
            WebElement elementNextPagina = driver.findElement(siguientePaginaGrilla);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementNextPagina);
            waitForWebElementClickableAndClick(elementNextPagina);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BtnEliminarObjetivoEstrategico(nombreOeEliminar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BtnEliminarObjetivoEstrategico(nombreOeEliminar));
        }
    }

    public void confirmarMensajeEliminacion (){
        waitForByLocatorToBeClickeableAndClick(aceptarMensajeEliminacion);
    }

    public void validarEliminacionExitosa() {
        try {
            waitForByLocatorPresenceOfElementLocated(msjEliminacionExitosa);
            waitForByLocatorToBeClickeableAndClick(cerrarMsjEliminacionExitoso);

        } catch (NoSuchElementException e) {
            System.out.println("No se pudo cerrar el modal mediante el botón 'Cerrar'... Revisar");
        }

    }
}

