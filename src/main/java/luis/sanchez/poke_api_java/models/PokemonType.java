package luis.sanchez.poke_api_java.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonType {
   private int slot;
   private InnerPokemonType type;
}

@Getter
@Setter
class InnerPokemonType {
   private String name;
   private String url;
}
