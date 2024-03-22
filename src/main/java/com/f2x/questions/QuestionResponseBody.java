package com.f2x.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class QuestionResponseBody implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.then().extract().body().asString();
    }

    public static QuestionResponseBody value() {
        return new QuestionResponseBody();
    }
}
