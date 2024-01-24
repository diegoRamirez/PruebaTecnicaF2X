package starter.stepdefinitions;

import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.AcceptOffers;
import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks.OpenUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractionBestOffersPopup_step {
    private final Actor actor = Actor.named("actor");
    WebDriver webDriver = new ChromeDriver();

    @Given("I am the home of falabella")
    public void iAmTheHomeOfFalabella() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(
                OpenUrl.goTo()
        );
    }

    @When("The best offers popup appears and I confirm that I am interested")
    public void theBestOffersPopupAppearsAndIConfirmThatIAmInterested() {
        actor.wasAbleTo(
                AcceptOffers.acceptOffers()
        );
    }

    @Then("A confirmation popup should appear")
    public void aConfirmationPopupShouldAppear() {
    }
}
