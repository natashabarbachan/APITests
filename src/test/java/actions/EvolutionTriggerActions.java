package actions;

import io.restassured.response.Response;
import json.Result;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class EvolutionTriggerActions {

    String url = "https://pokeapi.co/api/v2/";

    private Response evolutionTriggerEndpoint() {
        return
                given()
                        .log().all()
                        .when()
                        .get(url + "evolution-trigger")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    private Response specificEvolutionTriggerEndpointById(String url) {
        return
                given()
                        .log().all()
                        .when()
                        .get(url)
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    public String getEvolutionTriggerURLByName(String itemName){
        List<Result> responseResults = evolutionTriggerEndpoint().getBody().jsonPath().getList("results", Result.class);
        Optional<Result> result = responseResults.stream().filter(r -> r.getName().equals(itemName)).findFirst();
        return result.get().getUrl();
    }

    public String getPokemonNameByEvolutionTriggerId(String url) {
        return specificEvolutionTriggerEndpointById(url).getBody().path("pokemon_species[0].name");
    }
}
