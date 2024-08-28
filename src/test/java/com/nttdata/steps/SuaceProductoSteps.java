package com.nttdata.steps;

import com.nttdata.screens.SaucePrincipalScreen;
import com.nttdata.screens.SauceProductoScreen;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;

public class SuaceProductoSteps {
    SauceProductoScreen producto;

    public void agregarUnidadesProducto(int unidades) {
        Assert.assertTrue("No se encuentra los items de cantidad. ",producto.agregarUnidades(unidades));
    }

    public void agregarCarrito() {
        Assert.assertTrue("No se encuentra el boton Agregar Carrito. ",producto.agregarCarrito());
    }

    public void obtenerCantidadProductosAgregados(int cantidadIngresada) {
        int cantidadCarrito = producto.obtenerCantidadProductosAgregados();
        //validar si las cantidades son iguales
        Assert.assertEquals(cantidadIngresada, cantidadCarrito);
    }

}
