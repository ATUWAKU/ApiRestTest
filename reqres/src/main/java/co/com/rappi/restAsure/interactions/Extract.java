package co.com.rappi.restAsure.interactions;

import co.com.rappi.restAsure.models.ResponseLstResources;
import co.com.rappi.restAsure.models.ResponseLstUsers;
import co.com.rappi.restAsure.models.ResponseSingleUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static co.com.rappi.restAsure.utils.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Extract implements Interaction {

    private String url;

    public Extract(String url) {
        this.url = url;
    }

    public static Performable response(String url) {
        return instrumented(Extract.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (url.toLowerCase()){
            case LIST_USERS:
                ResponseLstUsers respLstUser = SerenityRest.lastResponse().jsonPath().getObject("",ResponseLstUsers.class);
                actor.remember(BODYRESP,respLstUser);
                break;
            case SINGLE_USER:
                ResponseSingleUser respUser = SerenityRest.lastResponse().jsonPath().getObject("",ResponseSingleUser.class);
                actor.remember(BODYRESP,respUser);
                break;
            case LIST_RESOURCES:
                ResponseLstResources respLstReso = SerenityRest.lastResponse().jsonPath().getObject("",ResponseLstResources.class);
                actor.remember(BODYRESP,respLstReso);
                break;
        }
        actor.remember(CODERESP, SerenityRest.lastResponse().getStatusCode());
        actor.remember(URLREQUESTED, url);

    }
}
