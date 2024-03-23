package com.f2x.stepdefinitions;

import com.f2x.questions.QuestionResponseBody;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.f2x.utils.MakeRequestCreateUser.getRequestRegister;
import static com.f2x.utils.MakeString.getStringRegisterId;
import static com.f2x.utils.MakeString.getStringRegisterToken;
import static com.f2x.utils.UtilProperties.getData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class Login {
    @Given("^quiero realizar el logueo exitoso$")
    public void quieroRealizarUnLogueoExitoso() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }
    @When("^ingreso las credenciales (.*?),(.*?)$")
    public void ingresoLasCredenciales(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                Post.to(getData("path.login")).with(request ->request.body(getRequestRegister(email,password)))
        );
    }

    @And("debe retornar el campo token")
    public void debeRetornarElCampoToken() {
        theActorInTheSpotlight().should(
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringRegisterToken()))
        );
    }

    @Given("quiero realizar el logueo con parametros incompletos")
    public void quieroRealizarElLogueoConParametrosIncompletos() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^ingreso solo (.*?)$")
    public void ingresoSolo(String email) {
        theActorInTheSpotlight().attemptsTo(
                Post.to(getData("path.login")).with(request ->request.body(getRequestRegister(email)))
        );
    }
}
