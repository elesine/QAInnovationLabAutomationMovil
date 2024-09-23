package com.nttdata.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.mockito.internal.stubbing.DefaultLenientStubber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SaucePrincipalScreen extends PageObject {

    private static final String HEADER_ID = "com.saucelabs.mydemoapp.android:id/header";
    private static final String PRODUCTS_XPATH = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']";
    private static final String PRODUCTS_ID = "com.saucelabs.mydemoapp.android:id/productRV";
    private static final String PRODUCTS_LIST_XPATH = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup";

    //android.widget.ScrollView[@content-desc="Scrollview manages views in given screen size"]

    public boolean estoyAplicacion(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_ID)));
        return header.isDisplayed();
    }
    public boolean hayProductos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCTS_XPATH)));
        return header.isDisplayed();
    }

//    public void scrollAndClick(String visibleText) {
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
//    }


    public boolean buscoProducto(String producto) {
        List<WebElement> productos = getDriver().findElements(By.xpath(PRODUCTS_LIST_XPATH));
        System.out.println("tamanio lista  : " + productos.size());

        WebElement productoItemText = null;
        int contador =0;
        for (WebElement productoItem : productos) {
            contador++;
            productoItemText = productoItem.findElement(By.className("android.widget.TextView"));
            System.out.println("PRODUCTO DE LA LISTA " + productoItemText.getText());
            if(Objects.equals(producto, productoItemText.getText())) {
                System.out.println("El producto existe " + productoItemText.getText());
                productoItem.click();
                return true;
           }
            //Cada cuatro elementos hacer scroll una pantalla abajo
            if (contador > 1 && contador%4 == 0) {
                getDriver().findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
            }
        }
        return false;
    }
}
