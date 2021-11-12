package co.com.rappi.restAsure.questions;

import co.com.rappi.restAsure.exceptions.ApiUrlException;
import co.com.rappi.restAsure.models.ResponseLstResources;
import co.com.rappi.restAsure.models.ResponseLstUsers;
import co.com.rappi.restAsure.models.ResponseSingleUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.rappi.restAsure.utils.Constants.*;

public class InResponse implements Question<Boolean> {

    private Actor actor;
    private static boolean isTheCode;

    public InResponse(Actor actor) {
        this.actor = actor;
    }

    private String extractResp(){

        String origin = actor.recall(URLREQUESTED);

        switch (origin.toLowerCase()){
            case LIST_USERS:
                ResponseLstUsers respLstUser = actor.recall(BODYRESP);
                return respLstUser.getSupport().getUrl();
            case SINGLE_USER:
                ResponseSingleUser respUser = actor.recall(BODYRESP);
                return respUser.getSupport().getUrl();
            case LIST_RESOURCES:
                ResponseLstResources respLstReso = actor.recall(BODYRESP);
                return respLstReso.getSupport().getUrl();
            default:
                throw new ApiUrlException();
        }
    }

    public static InResponse codeIs(Actor actor) {
        isTheCode = true;
        return new InResponse(actor);
    }

    public static InResponse urlSupportIs(Actor actor) {
        isTheCode = false;
        return new InResponse(actor);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if(isTheCode){
            int codeObt = actor.recall(CODERESP);
            return codeObt == SUCCRESPCODE;
        }

        return extractResp().equals(URLRESPONSE);

    }
}
