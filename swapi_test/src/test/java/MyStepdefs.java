import com.google.gson.Gson;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test",
        glue = "java"
)
public class MyStepdefs {
    private final String baseUrl = "https://swapi.co/api/";


    @Given("^I prepare configuration$")
    public void iPrepareConfiguration() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("111");
    }

    @When("^I search Jedi by \"([^\"]*)\"$")
    public void iSearchJediBy(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String response = restTemplate.exchange(baseUrl + "people/" + "1/",
                HttpMethod.GET,entity,String.class).getBody();

//        Jedy jedy = new Gson().fromJson(response, Jedy.class);
    }

    @When("^I search planet by \"([^\"]*)\" and population \"([^\"]*)\"$")
    public void iSearchPlanetByAndPopulation(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I must check whether the movie \"([^\"]*)\" belongs to \"([^\"]*)\" and his planet$")
    public void iMustCheckWhetherTheMovieBelongsToAndHisPlanet(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
