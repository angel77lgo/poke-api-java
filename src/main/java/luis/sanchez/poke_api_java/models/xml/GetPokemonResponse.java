package luis.sanchez.poke_api_java.models.xml;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import luis.sanchez.poke_api_java.models.Ability;
import luis.sanchez.poke_api_java.models.HeldItem;
import luis.sanchez.poke_api_java.models.PokemonType;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@XmlRootElement(name = "GetPokemonResponse")
public class GetPokemonResponse {
    private int id;
    private String name;
    private List<Ability> abilities;
    private int baseExperience;
    private List<HeldItem> heldItems;
    private String locationAreaEncounters;
    private List<PokemonType> types;
}
