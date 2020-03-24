package com.sophos.gorest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/gorest_api.feature",
        glue = "com.sophos.gorest.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class GoRest {
}