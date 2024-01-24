package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;

import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.interactions.ShadowClick;
import com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AcceptOffers implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ShadowClick.inTheButton(HomePage.SHADOW_HOST_POPUP,HomePage.SHADOW_BUTTON_ACCEPT)
        );

    }

    public static AcceptOffers acceptOffers(){
        return instrumented(AcceptOffers.class);
    }
}
