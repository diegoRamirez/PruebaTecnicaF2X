package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.ResultSearch.PRODUCT;

public class TheSelect implements Task {
    private String productName;

    public TheSelect(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PRODUCT.of(productName))
        );
    }

    public static TheSelect ofProduct(String productName){
        return Tasks.instrumented(TheSelect.class, productName);
    }
}
