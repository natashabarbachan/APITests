package steps;

import actions.BerryActions;
import actions.ItemActions;
import actions.EvolutionTriggerActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class ItemSteps {

    String itemName, url, categoryName, pokemonName, limit;
    Integer statusCode;
    List<String> allBerries;

    @Given("an item named {string}")
    public void getItemByName(String itemName) {
        ItemActions itemAPI = new ItemActions();
        url = itemAPI.getItemURLByName(itemName);
    }

    @When("the url for this item id is requested")
    public void getCategoryNameByItemId() {
        ItemActions itemAPI = new ItemActions();
        categoryName = itemAPI.getCategoryNameByItemId(url);
    }

    @Then("the category name should be {string}")
    public void validateCategoryName(String expectedCategoryName) {
        Assert.assertEquals(expectedCategoryName, categoryName);
    }

    @Given("a non-existent item called {string}")
    public void getNonExistentItem(String nonExistentItem) {
        this.itemName = nonExistentItem;
    }

    @When("the url for this item is requested")
    public void getNonExistentItem() {
        ItemActions itemAPI = new ItemActions();
        statusCode = itemAPI.getNonExistentItem(itemName);
    }

    @Then("the status code should be {int} Not Found")
    public void validateStatusCode(Integer expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCode);
    }

//  Evolution Trigger
    @Given("it has a evolution trigger named {string}")
    public void itHasEvolutionTriggerByName(String name) {
        EvolutionTriggerActions evolutionTriggerAPI = new EvolutionTriggerActions();
        url = evolutionTriggerAPI.getEvolutionTriggerURLByName(name);
    }

    @When("the url for this evolution trigger is requested")
    public void getPokemonNameByEvolutionTriggerId() {
        EvolutionTriggerActions evolutionTriggerAPI = new EvolutionTriggerActions();
        pokemonName = evolutionTriggerAPI.getPokemonNameByEvolutionTriggerId(url);
    }

    @Then("the {string} is returned")
    public void validatePokemonName(String expectedPokemonName) {
        Assert.assertEquals(expectedPokemonName, pokemonName);
    }

//  Berries
    @Given("there are {string} berries")
    public void thereAreBerries(String limit) {
        this.limit = limit;
    }

    @When("limit the berry endpoint")
    public void limitTheBerryEndpoint() {
        BerryActions berryAPI = new BerryActions();
        allBerries = berryAPI.getTheFirst10Berries(limit);
    }

    @Then("print the name of the first 10 berries")
    public void itShouldPrintAllTheNames() {
        allBerries.forEach(System.out::println);
    }

}
