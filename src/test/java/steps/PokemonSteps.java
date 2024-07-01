package steps;

import actions.PokemonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PokemonSteps {

    String pokemonName, limit, pokemonAbility, pokemonMove, url;
    int pokemonNumber;
    List<String> allPokemon;

    @Given("it has a pokemon named {string}")
    public void it_has_a_pokemon_named(String name) {
        pokemonName = name.toLowerCase();
    }

    @Given("there is {string} pokemon")
    public void thereIsPokemon(String limit) {
        this.limit = limit;
    }

    @When("get id from pokemon endpoint")
    public void endpoint_of_pokemon_is_submitted() {
        PokemonActions pokeAPI = new PokemonActions();
        pokemonNumber = pokeAPI.getPokemonId(pokemonName);
    }

    @When("get ability from pokemon endpoint")
    public void getAbilityFromResponse() {
        PokemonActions pokeAPI = new PokemonActions();
        pokemonAbility = pokeAPI.getPokemonAbility(pokemonName);
    }

    @When("get move from pokemon endpoint")
    public void getMoveFromPokemonEndpoint() {
        PokemonActions pokeAPI = new PokemonActions();
        pokemonMove = pokeAPI.getPokemonMove(pokemonName);
    }

    @When("limit the pokemon endpoint")
    public void limitThePokemonEndpoint() {
        PokemonActions pokeAPI = new PokemonActions();
        allPokemon = pokeAPI.get150Pokemon(limit);
    }

    @When("get the url from pokemon {string}")
    public void getUrlFromPokemon(String pokemonName) {
        this.pokemonName = pokemonName;
        PokemonActions pokeAPI = new PokemonActions();
        url = pokeAPI.getPokemonURLByName(limit, pokemonName);
    }

    @Then("it should be the same name on pokemon endpoint")
    public void itShouldBeTheSameNameOnPokemonEndpoint() {
        String currentPokemonName;
        PokemonActions pokeAPI = new PokemonActions();
        currentPokemonName = pokeAPI.getName(url);

//        System.out.println("Expected Pokemon Name: " + pokemonName);
//        System.out.println("Current Pokemon Name: " + currentPokemonName);
        Assert.assertEquals(pokemonName, currentPokemonName);
    }

    @Then("the id {int} is returned")
    public void the_code_is_returned(int id) {
        Assert.assertEquals(id, pokemonNumber);
    }

    @Then("the ability {string} is returned")
    public void theAbilityIsReturned(String ability) {
        Assert.assertEquals(ability, pokemonAbility);
    }

    @Then("the move {string} is returned")
    public void theMoveIsReturned(String move) {
        Assert.assertEquals(move, pokemonMove);
    }

    @Then("it should print all the names")
    public void itShouldPrintAllTheNames() {
        allPokemon.forEach(System.out::println);
    }
}
