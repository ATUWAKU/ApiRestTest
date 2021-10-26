package co.com.rappi.restAsure.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/ListUsers.feature",
        glue = "co.com.rappi.restAsure.stepDefinitions",
        snippets = SnippetType.CAMELCASE)

public class ListUsersRunner {
}
