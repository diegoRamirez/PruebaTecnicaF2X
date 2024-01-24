package com.salesforce.my.sandbox.alexandralozanoinmifrationlaw.stepdefinitions;

import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.questions.PopupOffersConfirmIsVisible;
import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.AcceptOffers;
import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.OpenUrl;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.ClosePopupOffersConfirmation.closePopup;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class InteractionBestOffersPopup_step {

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }



    @Given("I am the home of falabella")
    public void iAmTheHomeOfFalabella() {

        theActorCalled("actor").
        wasAbleTo(
                OpenUrl.goTo()
        );
    }

    @When("The best offers popup appears and I confirm that I am interested")
    public void theBestOffersPopupAppearsAndIConfirmThatIAmInterested() {
        theActorInTheSpotlight().wasAbleTo(
                AcceptOffers.acceptOffers()
        );
    }

    @Then("A confirmation popup should appear")
    public void aConfirmationPopupShouldAppear()  {
        theActorInTheSpotlight().should(
                seeThat("Popup offers confirmation is visible", PopupOffersConfirmIsVisible.isVisible(), is(true)));
    }

    @And("Close the popup")
    public void closeThePopup()  {
        theActorInTheSpotlight().attemptsTo(closePopup());
    }
}
