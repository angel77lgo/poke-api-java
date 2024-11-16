package luis.sanchez.poke_api_java.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import luis.sanchez.poke_api_java.models.PokemonResponse;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://pokeapi.co/api/v2/pokemon/";

    public GetPokemonResponse getPokemonDetailByName(String name) {
        String finalUrl = baseUrl.concat(name);
        System.out.println("URL: " + finalUrl);
        PokemonResponse pokemonResponse = restTemplate.getForObject(finalUrl, PokemonResponse.class);
        GetPokemonResponse getPokemonResponse = mapToSoapResponse(pokemonResponse);

        return getPokemonResponse;
    }

    private GetPokemonResponse mapToSoapResponse(PokemonResponse pokemonResponse) {
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();

        getPokemonResponse.setId(pokemonResponse.getId());
        getPokemonResponse.setName(pokemonResponse.getName());
        getPokemonResponse.setAbilities(pokemonResponse.getAbilities());
        getPokemonResponse.setBaseExperience(pokemonResponse.getBase_experience());
        getPokemonResponse.setHeldItems(pokemonResponse.getHeld_items());
        getPokemonResponse.setLocationAreaEncounters(pokemonResponse.getLocation_area_encounters());

        return getPokemonResponse;
    }
}
