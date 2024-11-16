package luis.sanchez.poke_api_java.models.xml;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "GetPokemonRequest", namespace = "http://example.com/pokemon")
public class GetPokemonRequest {
    private String name;
}
