package com.nttdata.steps;

import com.nttdata.screens.SaucePrincipalScreen;
import org.junit.Assert;
import org.mockito.internal.matchers.Null;

public class SuacePrincipalSteps {
    SaucePrincipalScreen home = null;

    public void validarAplicacion() {
        this.home = new SaucePrincipalScreen();
        Assert.assertTrue("No estoy en la aplicacion. ",this.home.estoyAplicacion());
    }

    public void validarHayProductos() {
        Assert.assertTrue("No hay productos. ",this.home.hayProductos());
    }

    public void buscoProducto(String producto) {
        System.out.println("Producto" + producto);
        Assert.assertTrue("El producto no existe", this.home.buscoProducto(producto));
    }
}
