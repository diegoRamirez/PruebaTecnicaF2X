package com.f2x.stepdefinitions;

import com.f2x.models.User;
import com.f2x.questions.QuestionResponseBody;
import com.f2x.questions.QuestionStatusCode;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.f2x.utils.MakeString.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GetSingleUser {
    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }
    @Given("^quiero consultar los datos de un usuario$")
    public void quieroConsultarLosDatosDeUnUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^realizo la consulta con el id (.*?)$")
    public void realizoLaConsultaConElId(String id) {
        theActorInTheSpotlight().attemptsTo(
                Get.resource("/api/users/"+id)
        );
    }

    @Then("el codigo de respuesta debe ser  {int}")
    public void elCodigoDeRespuestaDebeSer(int statusCode) {
        assertThat(theActorInTheSpotlight().asksFor(QuestionStatusCode.value())).isEqualTo(statusCode);
    }

    @And("^los datos deben ser (.*?),(.*?),(.*?)$")
    public void losDatosDebenSer(String email, String firstName, String lastName) {
        User user = new User(email, firstName, lastName, "");
        theActorInTheSpotlight().should(
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringFirstname(user))),
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringLastName(user) )),
                seeThat("El body del response", QuestionResponseBody.value(),containsString(getStringEmail(user) ))

        );
    }
}
