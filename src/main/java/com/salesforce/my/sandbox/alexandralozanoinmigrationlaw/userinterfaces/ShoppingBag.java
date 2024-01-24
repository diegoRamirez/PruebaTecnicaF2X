package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingBag {
    public static  final Target PRODUCT_DETAIL_BAG=
            Target.the("product detail shopping bag").
                    locatedBy(" //*[@class='title19 primary  jsx-2835692965 normal ellipsis line-clamp-2    ']");
}
