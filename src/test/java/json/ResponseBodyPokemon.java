package json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
public class ResponseBodyPokemon {

    @JsonProperty("count")
    public Integer count;
    @JsonProperty("next")
    public String next;
    @JsonProperty("previous")
    public String previous;
    @JsonProperty("results")
    public List<Result> results;

    public List<Result> getResults() {
        return  results;
    }

}