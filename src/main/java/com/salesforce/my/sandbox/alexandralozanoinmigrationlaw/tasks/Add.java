package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.Product.ADD_CART;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.Product.PRODUCT_DETAIL;

public class Add implements Task {
    String productDetail;

    @Override
    public <T extends Actor> void performAs(T actor) {
        productDetail = PRODUCT_DETAIL.resolveFor(actor).getAttribute("data-name");
        actor.remember("productDetail", productDetail);
        actor.attemptsTo(

                Click.on(ADD_CART)
        );
    }

    public static Add toCart(){
        return Tasks.instrumented(Add.class);
    }
}
