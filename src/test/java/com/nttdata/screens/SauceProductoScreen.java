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
    private static final String INCREMENTADOR_XPATH = "//android.widget.ImageView[@content-desc='Increase item quantity']";
    public boolean agregarUnidades(int unidades) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UNIDADES_XPATH)));
        System.out.println("Productos cantidad " + quantityInput.getText());
        //Agregar hasta la cantidad
        WebElement btnIncrementar = getDriver().findElement(By.xpath(INCREMENTADOR_XPATH));
        for(int i =0 ; i < unidades-1; i++){
            btnIncrementar.click();
        }
        System.out.println("Productos cantidad agregado: " + quantityInput.getText());

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
