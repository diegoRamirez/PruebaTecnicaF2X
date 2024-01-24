package com.salesforce.my.sandbox.alexandralozanoinmigrationlaw.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.*;

public class ShadowClick implements Interaction{
private String selectorShadowHost;
private String selectorShadowRoot;

    public ShadowClick(String selectorShadowHost, String selectorShadowRoot) {
        this.selectorShadowHost = selectorShadowHost;
        this.selectorShadowRoot = selectorShadowRoot;
    }
    @Override
    public <T extends Actor> void performAs(T t) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        WebElement shadowHost = driver.findElement(By.xpath(selectorShadowHost));
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",shadowHost);
        shadowRoot.findElement(By.cssSelector(selectorShadowRoot)).click();

    }

    public static ShadowClick inTheButton(String selectorShadowHost, String selectorShadowRoot){
        return Tasks.instrumented(ShadowClick.class,selectorShadowHost,selectorShadowRoot);
    }


}
