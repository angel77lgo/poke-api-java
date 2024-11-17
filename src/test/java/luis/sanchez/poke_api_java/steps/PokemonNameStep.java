package luis.sanchez.poke_api_java.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.servlet.http.HttpServletRequest;
import luis.sanchez.poke_api_java.models.xml.GetPokemonResponse;
import luis.sanchez.poke_api_java.services.PokemonService;
import luis.sanchez.poke_api_java.services.RequestLoggerService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonNameStep {
    private String pokemonName;
    private GetPokemonResponse getPokemonResponse;

    private PokemonService pokemonService;
    private RequestLoggerService requestLoggerService;
    private HttpServletRequest httpServletRequest;

    @Given("The pokemon name is {string}")
    public void thePokemonNameIs(String pokemonName) {
        requestLoggerService = mock(RequestLoggerService.class);
        httpServletRequest = mock(HttpServletRequest.class);

        when(httpServletRequest.getRemoteAddr()).thenReturn("127.0.0.1");

        pokemonService = new PokemonService(requestLoggerService, httpServletRequest);

        this.pokemonName = pokemonName;

    }

    @When("I consult the pokemon details")
    public void iConsultThePokemonDetails() throws IOException {
        getPokemonResponse = pokemonService.getPokemonDetailByName(pokemonName);
    }

    @Then("the request name is {string}")
    public void theRequestNameIs(String expectedName) {
        assertNotNull(getPokemonResponse);
        assertEquals(expectedName, getPokemonResponse.getName());
    }
}
