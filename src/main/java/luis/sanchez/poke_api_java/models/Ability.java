package luis.sanchez.poke_api_java.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ability {
    private Ability2 ability;
    private boolean is_hidden;
    private int slot;
}

@Getter
@Setter
@ToString
class Ability2 {
    private String name;
    private String url;
}
