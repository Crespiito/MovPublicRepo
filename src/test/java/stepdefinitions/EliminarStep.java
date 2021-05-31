package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarStep {

    @Dado("me autentico con las credenciales")
    public void meAutenticoConLasCredenciales() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Margarita");
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://demoqa.com/Account/v1/"));
    }


    @Cuando("elimino el usuario creado")
    public void eliminoElUsuarioCreado() {
        theActorInTheSpotlight().attemptsTo(Post.to("User").with(request -> request.contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "    \"userName\": \"UsuarioQa\",\n" +
                        "    \"password\": \"Demo123*\"\n" +
                        "}\n")
                .relaxedHTTPSValidation()
        )) ;
    }

    @Entonces("valido la respuesta exitosa")
    public void validoLaRespuestaExitosa() {
        theActorInTheSpotlight().should(seeThatResponse("mensaje derespuiesta",response -> response.statusCode(204)));
    }

}
