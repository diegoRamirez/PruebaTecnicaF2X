package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.HomePage.SEARCHER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformSearch implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue( "Televisor").into(SEARCHER),
                Hit.the(Keys.ENTER).into(SEARCHER)
        );
    }

    public static PerformSearch performSearch(){
        return instrumented(PerformSearch.class);
    }
}
