package co.com.rappi.restAsure.tasks;

import co.com.rappi.restAsure.exceptions.ApiUrlException;
import co.com.rappi.restAsure.models.ResponseLstUsers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.rappi.restAsure.utils.Constants.*;
import static co.com.rappi.restAsure.utils.HeaderParamsApi.CONTENT_TYPE_JSON;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Consume implements Interaction {

    private final String API_SINGLE_USER = "api/users/2";
    private final String API_LIST_RESOURCES = "api/unknown";
    private final String API_LIST_USERS = "api/users?page=2";
    private String url;
    private String apiName;

    public Consume(String apiName) {
        this.apiName = apiName;
    }

    public static Performable api(String api) {
        return instrumented(Consume.class, api);
    }

    private String consultUrlApi(String api){
        switch (api.toLowerCase()){
            case SINGLE_USER:
                return API_SINGLE_USER;

            case LIST_RESOURCES:
                return API_LIST_RESOURCES;

            case LIST_USERS:
                return API_LIST_USERS;
            default:
                throw new ApiUrlException();
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        url = consultUrlApi(apiName);
        actor.attemptsTo(
                Get.resource(url).with(
                        request -> request
                                .header(
                                CONTENT_TYPE_JSON.getKey(),CONTENT_TYPE_JSON.getValue())
                                .log().all()
                        )

        );



    }


}
