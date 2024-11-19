package luis.sanchez.poke_api_java.models.xml;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name = "GetPokemonRequestId", namespace = "http://example.com/pokemon")
public class GetPokemonRequestId {
    private int id;
}
