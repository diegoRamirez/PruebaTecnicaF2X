package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenUrl implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
               Open.url("https://www.falabella.com.co/falabella-co")
        );

    }

    public static OpenUrl goTo(){
        return instrumented(OpenUrl.class);
    }
}
