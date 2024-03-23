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
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.f2x.utils.MakeRequestCreateUser.getRequest;
import static com.f2x.utils.MakeString.*;
import static com.f2x.utils.UtilProperties.getData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ManageUser {
    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("quiero crear un nuevo usuario")
    public void quieroCrearUnNuevoUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^ingreso los datos (.*?),(.*?)$")
    public void ingresoLosDatos(String name, String job) {
        theActorInTheSpotlight().attemptsTo(
                Post.to(getData("path.create.user")).with(request ->request.body(getRequest(name,job)))
        );
    }

    @Then("el status code debe ser {int}")
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

    @Given("quiero editar la informacion de un usuario")
    public void quieroEditarLaInformacionDeUnUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }
    @When("^edito los datos del (.*?),(.*?),(.*?)$")
    public void editoLosDatosDel(String id, String name, String job) {
        theActorInTheSpotlight().attemptsTo(
                Put.to(getData("path.update.user")+ id).with(request ->request.body(getRequest(name,job)))
        );
    }

    @Given("quiero consultar los datos de un usuario")
    public void quieroConsultarLosDatosDeUnUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^realizo la consulta con el id (.*?)$")
    public void realizoLaConsultaConElId(String id) {
        theActorInTheSpotlight().attemptsTo(
                Get.resource(getData("path.get.user")+id)
        );
    }

    @Then("el codigo de respuesta debe ser {int}")
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

    @Given("quiero eliminar un usuario")
    public void quieroEliminarUnUsuario() {
        Actor actor = theActorCalled("Diego");
        actor.can(CallAnApi.at(getData("url.base.endpoint")));
    }

    @When("^elimino el usuario con el id (.*?)$")
    public void eliminoElUsuarioConElId(String id) {
        theActorInTheSpotlight().attemptsTo(
                Delete.from(getData("path.get.user")+id)
        );
    }
}
