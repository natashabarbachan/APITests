package json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
public class Result {

    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;

    public String getName()  {
        return name;
    }

    public String getUrl()  {
        return url;
    }
}