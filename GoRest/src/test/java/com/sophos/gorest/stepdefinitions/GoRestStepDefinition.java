package com.sophos.gorest.stepdefinitions;

import com.sophos.gorest.models.Photo;
import com.sophos.gorest.questions.VerifyConsume;
import com.sophos.gorest.tasks.GetApi;
import com.sophos.gorest.tasks.PostApi;
import com.sophos.gorest.util.load.ServicePhotoData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GoRestStepDefinition {
    private Actor goRestUser = Actor.named("goRestUser");
    private ServicePhotoData photoData = new ServicePhotoData();
    private String json;

    @Given("^Load photo data$")
    public void loadPhotoData(Map<String, String> dataTable) {
        json = photoData.loadData(dataTable);
    }

    @When("^Create a photo with the post method$")
    public void createWithPostMethod() {
        goRestUser.attemptsTo(PostApi.method(json));
    }

    @And("^Consult a photo with the get method$")
    public void consultWithGetMethod() {
        goRestUser.attemptsTo(GetApi.method());
    }

    @Then("^Verify the creation$")
    public void verifyTheCreation() {
        Photo photo = Serenity.sessionVariableCalled("photoModel");
        goRestUser.should(seeThat(VerifyConsume.checkToResponse(photo)));

    }

}
