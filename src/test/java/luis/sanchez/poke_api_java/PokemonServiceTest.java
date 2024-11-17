package luis.sanchez.poke_api_java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import luis.sanchez.poke_api_java.models.PokemonResponse;
import luis.sanchez.poke_api_java.models.dto.RequestLoggerDto;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;
import luis.sanchez.poke_api_java.services.PokemonService;
import luis.sanchez.poke_api_java.services.RequestLoggerService;

class PokemonServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RequestLoggerService requestLoggerService;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private PokemonService pokemonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPokemonDetailByNameSuccess() throws IOException {
        String name = "pikachu";
        String finalUrl = "https://pokeapi.co/api/v2/pokemon/" + name;

        PokemonResponse mockPokemonResponse = new PokemonResponse();

        mockPokemonResponse.setId(25);
        mockPokemonResponse.setName("pikachu");

        when(restTemplate.getForObject(finalUrl, PokemonResponse.class)).thenReturn(mockPokemonResponse);
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        GetPokemonResponse response = pokemonService.getPokemonDetailByName(name);

        // Assert
        assertNotNull(response);
        assertEquals("pikachu", response.getName());
        assertEquals(25, response.getId());

        verify(requestLoggerService, times(1)).createLogRequest(any(RequestLoggerDto.class));
    }
}
