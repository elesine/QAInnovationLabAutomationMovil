package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SaucePrincipalScreen extends PageObject {

    private static final String HEADER_ID = "com.saucelabs.mydemoapp.android:id/header";
    private static final String PRODUCT_XPATH = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']";
    private static final String PRODUCTS_ID = "com.saucelabs.mydemoapp.android:id/productRV";

    public boolean estoyAplicacion(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_ID)));
        return header.isDisplayed();
    }
    public boolean hayProductos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(PRODUCT_XPATH)));
        return header.isDisplayed();
    }

    public boolean buscoProducto(String producto) {
        List<WebElement> productos = getDriver().findElements(By.id(PRODUCTS_ID));
        WebElement link = null;
        for (WebElement productoItem : productos) {
            if(Objects.equals(productos, productoItem.getText())) {
                link.click();
                return true;
            }
        }
        return false;
    }
}
