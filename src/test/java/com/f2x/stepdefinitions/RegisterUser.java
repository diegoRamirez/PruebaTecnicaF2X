package com.f2x.stepdefinitions;

import com.f2x.models.User;
import com.f2x.questions.QuestionResponseBody;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.f2x.utils.MakeRequestCreateUser.getRequest;
import static com.f2x.utils.MakeRequestCreateUser.getRequestRegister;
import static com.f2x.utils.MakeString.*;
import static com.f2x.utils.UtilProperties.getData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class RegisterUser {
    @Given("^quiero registrar un nuevo usuario$")
    public void quieroRegistrarUnNuevoUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }
    @When("^registro los datos (.*?),(.*?)$")
    public void registroLosDatos(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                Post.to(getData("path.register.user")).with(request ->request.body(getRequestRegister(email,password)))
        );
    }

    @And("debe retornar los campos id y token")
    public void debeRetornarLosCamposIdYToken() {

        theActorInTheSpotlight().should(
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringRegisterId())),
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringRegisterToken()))

        );
    }

    @When("^registro solo el (.*?)$")
    public void registroSoloEl(String email) {
        theActorInTheSpotlight().attemptsTo(
                Post.to(getData("path.register.user")).with(request ->request.body(getRequestRegister(email)))
        );
    }

    @And("debe retornar mensaje de error")
    public void debeRetornarMensajeDeError() {
    }
}
