package luis.sanchez.poke_api_java.types;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HeldItem {
    private Item item;
    private List<VersionDetail> version_details;
}

@Getter
@Setter
class VersionDetail {
    private int rarity;
    private Version version;
}

@Getter
@Setter
class Version {
    private String name;
    private String url;
}

