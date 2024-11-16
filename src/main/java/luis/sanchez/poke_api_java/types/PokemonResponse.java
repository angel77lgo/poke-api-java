package luis.sanchez.poke_api_java.types;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

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

