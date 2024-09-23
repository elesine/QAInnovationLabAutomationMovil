package com.nttdata.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.runner.BaseTestRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.nttdata.stepsdefinitions",
        tags ="@CarritoDeCompras"
)
public class CucumberTestSuite {
}
