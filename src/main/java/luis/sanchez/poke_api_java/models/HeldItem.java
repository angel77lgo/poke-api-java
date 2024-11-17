package luis.sanchez.poke_api_java.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class HeldItem {
    private Item item;
    private List<VersionDetail> version_details;
}

@Getter
@Setter
@ToString
class VersionDetail {
    private int rarity;
    private Version version;
}

@Getter
@Setter
@ToString
class Version {
    private String name;
    private String url;
}

