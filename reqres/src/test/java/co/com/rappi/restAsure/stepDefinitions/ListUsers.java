package co.com.rappi.restAsure.stepDefinitions;

import co.com.rappi.restAsure.exceptions.BodyRespException;
import co.com.rappi.restAsure.exceptions.CodeResponseException;
import co.com.rappi.restAsure.interactions.Extract;
import co.com.rappi.restAsure.questions.InResponse;
import co.com.rappi.restAsure.tasks.Consume;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.rappi.restAsure.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ListUsers {

    @Before
    public void setup(){
        setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(BASE_URL_API)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^The system consumes the (.*) api$")
    public void theSystemConsumesTheUserListingApi(String api) {
        theActorCalled(NAME_ACTOR).attemptsTo(
                Consume.api(api),
                Extract.response(api)
        );


    }

    @Then("^The system validates that the response is successful$")
    public void theSystemValidatesThatTheResponseIsSuccessful() {
        theActorInTheSpotlight().should(
                seeThat(InResponse.codeIs(theActorInTheSpotlight()), x -> x.equals(true)).orComplainWith(CodeResponseException.class, MSGEXCCODE),
                seeThat(InResponse.urlSupportIs(theActorInTheSpotlight()), x -> x.equals(true)).orComplainWith(BodyRespException.class, MSGEXCBODY)
        );

    }


}
