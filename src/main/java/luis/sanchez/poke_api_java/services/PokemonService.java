package luis.sanchez.poke_api_java.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import luis.sanchez.poke_api_java.models.PokemonResponse;
import luis.sanchez.poke_api_java.models.dto.RequestLoggerDto;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://pokeapi.co/api/v2/pokemon/";
    private final RequestLoggerService requestLoggerService;
    private final HttpServletRequest request;

    public PokemonService(RequestLoggerService requestLoggerService, HttpServletRequest request) {
        this.requestLoggerService = requestLoggerService;
        this.request = request;
    }

    public GetPokemonResponse getPokemonDetailByName(String name) throws IOException {
        String finalUrl = baseUrl.concat(name);
        System.out.println("URL: " + finalUrl);
        PokemonResponse pokemonResponse = restTemplate.getForObject(finalUrl, PokemonResponse.class);
        GetPokemonResponse getPokemonResponse = mapToSoapResponse(pokemonResponse);

        ObjectMapper objectMapper = new ObjectMapper();

        String responsePayload = objectMapper.writeValueAsString(getPokemonResponse);
        String requestPayload = "{\"name\": \"" + name + "\"}";

        createLogRequest("getPokemonDetailByName", responsePayload, requestPayload);

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

    private void createLogRequest(String method, String responsePayload, String requestPayload) {
        String ipOrigin = request.getRemoteAddr();

        // Create log request
        LocalDateTime requestTime = LocalDateTime.now();

        RequestLoggerDto requestLoggerDto = new RequestLoggerDto();

        requestLoggerDto.setIpOrigin(ipOrigin);
        requestLoggerDto.setRequestTime(requestTime);
        requestLoggerDto.setRequestMethod(method);

        requestLoggerDto.setRequestPayload(requestPayload);
        requestLoggerDto.setResponsePayload(responsePayload);

        requestLoggerService.createLogRequest(requestLoggerDto);

    }

}
