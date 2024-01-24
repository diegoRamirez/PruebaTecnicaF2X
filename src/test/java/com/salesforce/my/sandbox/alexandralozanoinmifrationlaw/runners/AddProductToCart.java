package com.salesforce.my.sandbox.alexandralozanoinmifrationlaw.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/addProductToCart.feature",
        glue = "com/salesforce/my/sandbox/alexandralozanoinmifrationlaw/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class AddProductToCart {
}
