package luis.sanchez.poke_api_java.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/luis/sanchez/poke_api_java/features",
        glue = "luis.sanchez.poke_api_java.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CucumberRunTest {
}
