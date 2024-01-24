package com.salesforce.my.sandbox.alexandralozanoinmifrationlaw.stepdefinitions;


import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.questions.ConfirmProductAdded;
import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;



public class addProductToCart {
private final String PRODUCT= "Televisor";

    @Given("I am located at Falabella's home")
    public void iAmLocatedAtFalabellaSHome() {

        theActorCalled("actor").wasAbleTo(
                OpenUrl.goTo(),
                AcceptOffers.acceptOffers()
        );
    }


    @When("I choose a product from the search engine")
    public void IChooseAProductFromTheSearchEngine()  {
        theActorInTheSpotlight().attemptsTo(
                PerformSearch.performSearch(),
                TheSelect.ofProduct(PRODUCT)
        );
    }

    @And("I add the product to the shopping cart")
    public void IAddTheProductToTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                Add.toCart()
        );
    }

    @Then("the product must appear in the shopping bag")
    public void theProductMustAppearInTheShoppingBag() {
        theActorInTheSpotlight().should(
                seeThat("the product is equal", ConfirmProductAdded.isEqualTo(theActorInTheSpotlight().recall("productDetail"))));

    }


}
