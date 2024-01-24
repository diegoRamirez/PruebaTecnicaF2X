package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.interactions.ClickOnElement.inTheButton;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.HomePage.CLOSE_BUTTON_POPUP_OFFERS_CONFIRMATION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClosePopupOffersConfirmation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                inTheButton(CLOSE_BUTTON_POPUP_OFFERS_CONFIRMATION)

        );
    }

    public static ClosePopupOffersConfirmation closePopup(){
        return instrumented(ClosePopupOffersConfirmation.class);
    }
}
