package luis.sanchez.poke_api_java.models.xml;


import lombok.Getter;
import lombok.Setter;
import luis.sanchez.poke_api_java.models.Ability;
import luis.sanchez.poke_api_java.models.HeldItem;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name = "GetPokemonResponse")
public class GetPokemonResponse {
    private int id;
    private String name;
    private List<Ability> abilities;
    private int baseExperience;
    private List<HeldItem> heldItems;
    private String locationAreaEncounters;
}
