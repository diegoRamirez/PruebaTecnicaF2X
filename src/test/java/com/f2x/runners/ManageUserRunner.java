package com.f2x.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/manageUser.feature",
        glue = "com/f2x/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ManageUserRunner {
}
