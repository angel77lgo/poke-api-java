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
    public int base_experience;
    public List<HeldItem> held_items;
    public String location_area_encounters;
}

