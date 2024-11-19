package luis.sanchez.poke_api_java.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonResponse {
    private int id;
    private String name;
    private List<Ability> abilities;
    private int base_experience;
    private List<HeldItem> held_items;
    private String location_area_encounters;
    private List<PokemonType> types;
}

