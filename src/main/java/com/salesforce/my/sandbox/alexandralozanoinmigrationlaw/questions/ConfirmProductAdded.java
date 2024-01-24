package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.ShoppingBag.PRODUCT_DETAIL_BAG;

public class ConfirmProductAdded implements Question<Boolean> {
    private final String expectedText;

    public ConfirmProductAdded(String expectedText){
        this.expectedText= expectedText;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        String textShoppingBag= PRODUCT_DETAIL_BAG.resolveFor(actor).getText();
        return expectedText.equals(textShoppingBag);
    }

    public static ConfirmProductAdded isEqualTo(String expectedText){
        return new ConfirmProductAdded(expectedText);
    }
}
