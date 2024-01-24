package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Product {
    public static  final Target ADD_CART = Target.the("home searcher").locatedBy("id:add-to-cart-button");
    public static  final Target PRODUCT_DETAIL= Target.the("product detail").locatedBy("(//div[@class='jsx-468546439 corner-details'])[2]/h1");

}
