package luis.sanchez.poke_api_java.controller;

import luis.sanchez.poke_api_java.models.xml.GetPokemonRequestId;
import luis.sanchez.poke_api_java.models.xml.GetPokemonRequestName;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;
import luis.sanchez.poke_api_java.services.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

import java.io.IOException;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/pokemon";
    private final PokemonService pokemonService;

    @Autowired
    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequestName")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequestName request) throws IOException {
        return pokemonService.getPokemonDetailByName(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequestId")
    @ResponsePayload
    public GetPokemonResponse getPokemonById(@RequestPayload GetPokemonRequestId request) throws IOException {
        return pokemonService.getPokemonDetailById(request.getId());
    }
}
