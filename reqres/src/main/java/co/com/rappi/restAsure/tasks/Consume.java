package co.com.rappi.restAsure.tasks;

import co.com.rappi.restAsure.models.ResponseLstUsers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.rappi.restAsure.utils.Constants.BODYRESP;
import static co.com.rappi.restAsure.utils.Constants.CODERESP;
import static co.com.rappi.restAsure.utils.HeaderParamsApi.CONTENT_TYPE_JSON;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Consume implements Interaction {

    private String url;


    public Consume(String url) {
        this.url = url;
    }

    public static Performable api(String url) {
        return instrumented(Consume.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
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
