package com.f2x.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.f2x.utils.MakeRequestCreateUser.getRequest;
import static com.f2x.utils.UtilProperties.getData;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUser {
    @Given("^quiero editar la informacion de un usuario$")
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
}
