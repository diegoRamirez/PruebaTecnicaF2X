package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import static com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces.HomePage.POPUP_OFFERS_CONFIRMATION;

public class PopupOffersConfirmIsVisible implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.stateOf(POPUP_OFFERS_CONFIRMATION).answeredBy(actor).isVisible();
    }
    public static PopupOffersConfirmIsVisible isVisible(){

        return new PopupOffersConfirmIsVisible();
    }


}
