package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultSearch {
    public static  final Target PRODUCT = Target.the("product").locatedBy("(//*[contains(text(),'{0}')])[1]");


}
