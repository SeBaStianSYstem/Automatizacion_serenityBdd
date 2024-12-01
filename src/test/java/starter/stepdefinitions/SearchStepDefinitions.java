package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

import java.util.Objects;


public class SearchStepDefinitions {
    private static final String paginaFacebook = "pages.facebook";

    @Given("que el usuario se encuentre en la pagina inicial de facebook")
    public void queElUsuarioSeEncuentreEnLaPaginaInicialDeFacebook() {
        COMMON_ACTOR.attemptsTo(
                Open.browserOn().thePageNamed(paginaFacebook)
        );
    }

    @When("da click en el boton log in utilizando el metodo {string}")
    public void clickBotonLogin(String metodo){
        if(Objects.equals(metodo, "ContainingText")){
            COMMON_ACTOR.attemptsTo(clickLoginButtonFacebookContainingText());
        }
        else if (Objects.equals(metodo,"WithNameOrId")) {
            COMMON_ACTOR.attemptsTo(clickLoginButtonFacebookWithNameOrId());
        }else {
            System.out.println("Metodo no disponible");
        }
    }

    @Then("visualizara la pagina de facebook con el texto {string}")
    public void assertionClickBotonLoginFacebook(String text){
        COMMON_ACTOR.should(seeThat(CommonQuestions.textEquals(text, textoEsperadoFacebookLogin)));
    }
}
