package luis.sanchez.poke_api_java.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ability {
    private Ability2 ability;
    private boolean is_hidden;
    private int slot;
}

@Getter
@Setter
class Ability2 {
    private String name;
    private String url;
}
