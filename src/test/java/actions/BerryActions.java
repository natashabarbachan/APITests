package actions;

import io.restassured.response.Response;
import json.ResponseBodyPokemon;
import json.Result;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BerryActions {

    String url = "https://pokeapi.co/api/v2/";

    private Response berryAll(String limit) {

        return
                given()
                        .log().all()
                        .param("limit", limit)
                        .when()
                        .get(url + "berry")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    public List<String> getTheFirst10Berries(String limit){
        List<String> allBerry = new ArrayList<>();
        List<Result> responseResults = berryAll(limit).getBody().jsonPath().getList("results", Result.class);
        responseResults.forEach(result -> allBerry.add(result.getName()));
        return allBerry;
    }
}
