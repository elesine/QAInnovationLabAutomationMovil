package com.nttdata.steps;

import com.nttdata.screens.SaucePrincipalScreen;
import com.nttdata.screens.SauceProductoScreen;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;

public class SuaceProductoSteps {
    SauceProductoScreen producto = null;

    public void agregarUnidadesProducto(int unidades) {
        this.producto = new SauceProductoScreen();
        Assert.assertTrue("No se encuentra los items de cantidad. ",this.producto.agregarUnidades(unidades));
    }

    public void agregarCarrito() {
        Assert.assertTrue("No se encuentra el boton Agregar Carrito. ",this.producto.agregarCarrito());
    }

    public void obtenerCantidadProductosAgregados(int cantidadIngresada) {
        int cantidadCarrito = this.producto.obtenerCantidadProductosAgregados();
        //validar si las cantidades son iguales
        Assert.assertEquals(cantidadIngresada, cantidadCarrito);
    }

}
