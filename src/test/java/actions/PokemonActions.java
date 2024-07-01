package actions;

import io.restassured.response.Response;
import json.ResponseBodyPokemon;
import json.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class PokemonActions {

    String url = "https://pokeapi.co/api/v2/";

    private Response pokemonEndpoint(String name) {

        return
                given()
                        .log().all()
                        .when()
                        .get(url + "pokemon/" + name)
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    private Response pokemonAll(String limit) {

        return
                given()
                        .log().all()
                        .param("limit", limit)
                        .when()
                        .get(url + "pokemon")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    private Response pokemonEndpointByURLId(String url) {

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

    public String getName(String url) {
        return pokemonEndpointByURLId(url).getBody().path("name");
    }

    public int getPokemonId(String name){
        return pokemonEndpoint(name).getBody().path("id");
    }

    public String getPokemonAbility(String name){
        return pokemonEndpoint(name).getBody().path("abilities[1].ability.name");
    }

    public String getPokemonMove(String name){
        return pokemonEndpoint(name).getBody().path("moves[0].move.name");
    }

    public List<String> get150Pokemon(String limit){

        List<String> allPokemon = new ArrayList<>();

        //Printing First Time
        ResponseBodyPokemon responseBodyPokemon = pokemonAll(limit).getBody().as(ResponseBodyPokemon.class);
        responseBodyPokemon.getResults().forEach(result -> allPokemon.add(result.getName()));

        //Printing Second Time
        List<Result> responseResults = pokemonAll(limit).getBody().jsonPath().getList("results", Result.class);
        responseResults.forEach(result -> allPokemon.add(result.getName()));

        return allPokemon;
    }

    public String getPokemonURLByName(String limit, String name){

        List<Result> responseResults = pokemonAll(limit).getBody().jsonPath().getList("results", Result.class);
        Optional<Result> result = responseResults.stream().filter(r -> r.getName().equals(name)).findFirst(); // Usar forEach
        return result.get().getUrl();
    }
}