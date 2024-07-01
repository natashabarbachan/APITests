package actions;

import io.restassured.response.Response;
import json.Result;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class ItemActions {

    String url = "https://pokeapi.co/api/v2/";

    private Response itemEndpoint() {
        return
                given()
                        .log().all()
                        .when()
                        .get(url + "item")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .response();
    }

    private Response specificItemEndpointById(String url) {
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

    private Integer specificNonExistentItem(String nonExistentItem) {
        return
                given()
                        .log().all()
                        .when()
                        .get(url + "item/" + nonExistentItem)
                        .then()
                        .log().all()
                        .extract()
                        .response().statusCode();
    }

    public String getItemURLByName(String itemName){
        List<Result> responseResults = itemEndpoint().getBody().jsonPath().getList("results", Result.class);
        Optional<Result> result = responseResults.stream().filter(r -> r.getName().equals(itemName)).findFirst();
        return result.get().getUrl();
    }

    public String getCategoryNameByItemId(String url) {
        return specificItemEndpointById(url).getBody().path("category.name");
    }

    public Integer getNonExistentItem(String nonExistentItem) {
//        return specificNonExistentItem(nonExistentItem).getBody().prettyPrint();
        return specificNonExistentItem(nonExistentItem);
    }

}
