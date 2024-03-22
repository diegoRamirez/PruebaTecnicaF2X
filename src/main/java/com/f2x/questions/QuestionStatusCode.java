package com.f2x.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class QuestionStatusCode implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.then().extract().statusCode();
    }

    public static QuestionStatusCode value() {
        return new QuestionStatusCode();
    }
}
