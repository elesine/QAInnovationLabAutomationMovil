package com.nttdata.stepsdefinitions;

import com.nttdata.screens.SaucePrincipalScreen;
import com.nttdata.steps.SuacePrincipalSteps;
import com.nttdata.steps.SuaceProductoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SauceLabsAppStepDef {

    @Steps
    SuacePrincipalSteps suacePrincipalSteps = null;
    SuaceProductoSteps suaceProductoSteps = null;

    int cantidad = 0;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        //valido que estoy dentro de la aplicacion
        this.suacePrincipalSteps = new SuacePrincipalSteps();
        this.suacePrincipalSteps.validarAplicacion();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        this.suacePrincipalSteps.validarHayProductos();
    }

    @When("agrego {} del siguiente producto {}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        //Buscar producto son el nombre dado y dar click
        this.suacePrincipalSteps.buscoProducto(producto);

        //En el Screen del Producto buscar las unidades y setterar con las unidades dadas
        this.suaceProductoSteps = new SuaceProductoSteps();
        this.suaceProductoSteps.agregarUnidadesProducto(unidades);
        //En el Screen del Producto buscar boton Add to cart y hacer click
        this.suaceProductoSteps.agregarCarrito();
        this.cantidad += unidades;
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        //En el Screen del Producto buscar el carrito en la parte superior y ver la cantidad
        //sea la suma de la cantidad dada en el paso anterior
        this.suaceProductoSteps.obtenerCantidadProductosAgregados(this.cantidad);
    }

}
