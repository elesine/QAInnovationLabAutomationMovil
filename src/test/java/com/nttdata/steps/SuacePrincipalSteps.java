package com.nttdata.steps;

import com.nttdata.screens.SaucePrincipalScreen;
import org.junit.Assert;

public class SuacePrincipalSteps {
    SaucePrincipalScreen home;

    public void validarAplicacion() {
        Assert.assertTrue("No estoy en la aplicacion. ",home.estoyAplicacion());
    }

    public void validarHayProductos() {
        Assert.assertTrue("No hay productos. ",home.hayProductos());
    }

    public void buscoProducto(String producto) {
        Assert.assertTrue("La categoría no existe", home.buscoProducto(producto));
    }
}
