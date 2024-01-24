package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final String SHADOW_HOST_POPUP = "//*[@class='airship-html-prompt-shadow']";
    public static final String SHADOW_BUTTON_ACCEPT = "div > div > div.airship-alert-buttons > button.airship-btn.airship-btn-accept";

    public static  final Target POPUP_OFFERS_CONFIRMATION = Target.the("popup offers confirmation").locatedBy("(//*[@id='testId-notification'])[1]");
    public static  final Target CLOSE_BUTTON_POPUP_OFFERS_CONFIRMATION = Target.the("close button popup offers confirmation").locatedBy("(//button[@id='testId-notification-close-btn'])[1]");
    public static  final Target SEARCHER = Target.the("home searcher").locatedBy("//input[@id='testId-SearchBar-Input']");


}
