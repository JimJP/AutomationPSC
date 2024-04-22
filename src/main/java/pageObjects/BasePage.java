package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants_Vars;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        action = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void visitUrl(String url) { //Sirve para navegar a una dirección url de una página
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public WebElement findElement(By locator) { //Sirve para localizar todos los elementos con  el objeto By
        return driver.findElement(locator);
    }

    public void type(String inputText, By locator) { //Sirve para escribir texto en textfield
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(inputText);
    }

    public void selectDropDownByValue(By locator, String valueToSelect) { //Selecciona un dropdown (combobox) por su valor del atributo value
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByValue(valueToSelect);

    }

    public void selectDropDownByIndex(By locator, int valueToSelect) { //Selecciona un dropdown (combobox) por su orden [0, 1, 2, etc]
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByIndex(valueToSelect);

    }

    public void selectDropDownByText(By locator, String valueToSelect) { //Selecciona un dropdown (combobox) por su nombre del atributo name
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByVisibleText(valueToSelect);

    }

    public void hoverOverElement(By locator) { //Sirve para pasar por encima el mouse de un elemento web
        WebElement hoverOverElement = driver.findElement(locator);
        action.moveToElement(hoverOverElement).perform();
    }

    public void click(By locator) { //Hace clic izquierdo
        WebElement click = driver.findElement(locator);
        action.click(click).perform();
    }

    public void dobleClick(By locator) { //Doble clic izquierdo sobre un elemento web
        WebElement dobleClick = driver.findElement(locator);
        action.doubleClick(dobleClick).perform();
    }

    public void rightClick(By locator) { //clic derecho sobre un elemento web
        WebElement rightClick = driver.findElement(locator);
        action.contextClick(rightClick).perform();
    }

    public void mouseDown(By locator) { //Hace clic a un elemento para bajar el mouse
        WebElement mouseDown = driver.findElement(locator);
        action.clickAndHold(mouseDown).perform();
    }

    public void mouseUp(By locator) { //Hace clic a un elemento para subir el mouse
        WebElement mouseUp = driver.findElement(locator);
        action.release(mouseUp).perform();
    }

    public void focusOnButton(By locator) { //Hace clic a un elemento, en este caso boton y le genera focus (enfoque)
        WebElement focusOnButton = driver.findElement(locator);
        action.moveToElement(focusOnButton).click().build().perform();
    }

    public void moveToElementByLocator(By locator){
        WebElement moveToElement = driver.findElement(locator);
        action.moveToElement(moveToElement).perform();
    }

    public String getValueFromTable(String locator, int row, int column) { // Sirve para ubicar dentro de un elemento web Table una fila y su columna e imprimir su valor con system.out.println
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return findElement(cellINeed).getText();
    }

    private WebElement findElement(String cellINeed) {
        return null;
    }

    public void setValueOnTable(By locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        findElement(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) { //Sirve para alternar o seleccionar un nuevo frame
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchParentFrame() { //Sirve para regresar nuevamente al frame inicial
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() { //Sirve para quitar las alertas en las páginas
        try {    //Los try y catch sirven para manejar errores y nos diga donde exactamente es el error especifico
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException exception) {
            exception.getMessage();
        }
    }

    public void validateText(By locator, String textToValidate) {
        Assert.assertEquals(textToValidate, findElement(locator).getText());
    }

    public String textFromElement(By locator) { //Sirve para devoler una cadena de texto de un webelement
        return findElement(locator).getText();
    }

    public boolean elementEnable(By locator) { //Esto sirve para validar si un elementoweb (por ejm botón) esta habilitado para ser interacturado
        return findElement(locator).isEnabled();
    }

    public boolean elementIsDisplayed(By locator) { //Esto va devolver si es True o False al encontrar cierto elementoweb
        return findElement(locator).isDisplayed();
    }

    public boolean webElementIsDisplayed(WebElement element) { //Esto va devolver si es True o False al encontrar cierto elementoweb
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("No se encontró el elemento en el metodo webElementIsDisplayed");
            return  false;
        }
    }

    public boolean elementIsSelected(By locator) { //Esto nos devuelve si está o no seleccionado un elemento de tipo select (combobx)
        return findElement(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(By locator) { //Nos devuelve toda una lista de elementos por ejemplo en un buscador por palabra clave y arroja varios string que coinciden, luego se puede interactuar con c/u de ellos
        return driver.findElements(locator);
    }

    public void waitForByLocatorToBeClickeableAndClick(By locator) { //Espera 10 seg a que el elemento sea clickeable y le hace clic
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (TimeoutException e){
            System.out.println("El elemento no está visible o no a sido localizado para hacer clic luego de tiempo de espera");
            e.printStackTrace();
        }
    }
    public void waitForByLocatorToBeClickeableAndWrite(String inputText, By locator){ //Espera 10 seg a que el elemento sea clickeable y escribe texto
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(inputText);
    }

    public void waitForByLocatorPresenceOfElementLocated(By locator) { //Espera 10 seg hasta que aparezca la presencia del elemento en la página
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForByLocatorPresenceOfElementLocatedAndClick(By locator) { //Espera 10 seg hasta que aparezca la presencia del elemento en la página
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForByLocatorPresenceOfElementLocatedAndWrite(String inputText, By locator) { //Espera 10 seg hasta que aparezca la presencia del elemento en la página
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(inputText);
    }

    public void waitForByLocatorVisibilityOfElementLocated(By locator){ //Espera 10 seg hasta que el elemento se muestre en el código y este visible en la página
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForByLocatorInvisibilityOfElementLocated(By locator){ //Espera hasta que elemento desaparezca para continuar con la lógica
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForByLocatorAndClickAndWriteAndEnter(String inputText, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void assertTrueGetTextAttributeForText(String mensaje, By locator){ //Valida que el mensaje de tipo String sea el mismo webelement
        WebElement webElementLocator = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(webElementLocator));
        Assert.assertEquals(webElementLocator.getText(), mensaje);
    }

    public void byLocatorClear(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
    }

    public void  waitForWebElementClickableAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForWebElementPresence(WebElement element){  // Espera explícita para esperar a que el elemento sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveToWebElement(WebElement element){
        action.moveToElement(element).perform();
    }

}
