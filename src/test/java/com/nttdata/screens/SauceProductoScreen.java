package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceProductoScreen extends PageObject {

    private static final String UNIDADES_XPATH = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']";
    private static final String BUTTONCARRITO_ID = "com.saucelabs.mydemoapp.android:id/cartBt";
    private static final String TEXTUNIDADESCARRITO_ID = "com.saucelabs.mydemoapp.android:id/cartTV";

    public boolean agregarUnidades(int unidades) {
        WebElement quantityInput = getDriver().findElement(By.xpath(UNIDADES_XPATH));
        System.out.println("Productos cantidad " + quantityInput.getText());
        // Limpia el campo antes de establecer el nuevo valor
        quantityInput.clear();
        System.out.println("Productos cantidad limpio: " + quantityInput.getAttribute("value"));
        //Envio la cantidad
        quantityInput.sendKeys(String.valueOf(unidades));
        System.out.println("Productos cantidad agregado: " + quantityInput.getAttribute("value"));

        return quantityInput.isDisplayed();
    }

    public boolean agregarCarrito() {
        WebElement btnAddCarrito = getDriver().findElement(By.id(BUTTONCARRITO_ID));
        btnAddCarrito.click();
        return btnAddCarrito.isDisplayed();
    }

    public int obtenerCantidadProductosAgregados() {
        WebElement unidades = getDriver().findElement(By.id(TEXTUNIDADESCARRITO_ID));
        return Integer.parseInt(unidades.getText());
    }

}
