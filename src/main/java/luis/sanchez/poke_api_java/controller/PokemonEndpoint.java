package luis.sanchez.poke_api_java.controller;

import luis.sanchez.poke_api_java.models.xml.GetPokemonRequest;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;
import luis.sanchez.poke_api_java.services.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/pokemon";
    private final PokemonService pokemonService;

    @Autowired
    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        System.out.println("Request: " + request.getName());
        return pokemonService.getPokemonDetailByName(request.getName());
    }
}
