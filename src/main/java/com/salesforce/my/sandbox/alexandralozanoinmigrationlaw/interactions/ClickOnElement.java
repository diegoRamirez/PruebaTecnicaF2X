package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOnElement implements Interaction {
    Target element;

    public ClickOnElement(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

        Click.on(element);
    }

    public static ClickOnElement inTheButton(Target element){
        return Tasks.instrumented(ClickOnElement.class,element);
    }
}
