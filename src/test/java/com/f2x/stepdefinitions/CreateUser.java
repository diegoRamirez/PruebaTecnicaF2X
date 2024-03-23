package com.f2x.stepdefinitions;

import com.f2x.models.User;
import com.f2x.questions.QuestionResponseBody;
import com.f2x.questions.QuestionStatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.f2x.utils.MakeRequestCreateUser.getRequest;
import static com.f2x.utils.MakeString.getStringJob;
import static com.f2x.utils.MakeString.getStringName;
import static com.f2x.utils.UtilProperties.getData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateUser {
    @Given("^quiero crear un nuevo usuario$")
    public void quieroCrearUnNuevoUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^ingreso los datos (.*?),(.*?)$")
    public void ingresoLosDatos(String name, String job) {
        theActorInTheSpotlight().attemptsTo(
                Post.to("/api/users").with(request ->request.body(getRequest(name,job)))
        );
    }

    @Then("el status code debe ser  {int}")
    public void elStatusCodeDebeSer(int statusCode) {
        assertThat(theActorInTheSpotlight().asksFor(QuestionStatusCode.value())).isEqualTo(statusCode);
    }

    @And("^debe retornar los datos ingresados (.*?),(.*?)$")
    public void debeRetornarLosDatosIngresados(String name, String job) {
        User user = new User("", name, "", job);
        theActorInTheSpotlight().should(
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringName(user))),
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringJob(user) ))
        );
    }
}
