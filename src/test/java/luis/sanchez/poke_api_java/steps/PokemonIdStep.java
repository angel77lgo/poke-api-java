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

public class PokemonIdStep {
    private int pokemonId;
    private GetPokemonResponse getPokemonResponse;

    private PokemonService pokemonService;
    private RequestLoggerService requestLoggerService;
    private HttpServletRequest httpServletRequest;

    @Given("The pokemon id is {int}")
    public void thePokemonIdIs(int pokemonId) {
        requestLoggerService = mock(RequestLoggerService.class);
        httpServletRequest = mock(HttpServletRequest.class);

        pokemonService = new PokemonService(requestLoggerService, httpServletRequest);
        this.pokemonId = pokemonId;
    }

    @When("I consult the pokemon details id")
    public void iConsultThePokemonDetailsId() throws IOException {
        getPokemonResponse = pokemonService.getPokemonDetailById(pokemonId);
    }

    @Then("the request name is {string} id")
    public void theRequestIdIs(String excpectedName) {
        assertNotNull(getPokemonResponse);
        assertEquals(excpectedName, getPokemonResponse.getName());
    }

}
