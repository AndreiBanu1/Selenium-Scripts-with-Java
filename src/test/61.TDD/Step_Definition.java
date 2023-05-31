import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.selenium.testing.Validator;

public class Step_Definition {
    @Given("^User have Provided the credentials$")
    public void Setup(){
        System.out.println("Credential Received, Starting Validation");
    }

    @Then("^Verify the password$")
    public void Verify_Password() {
        Validator es = new Validator();
        System.out.println(es.Password_isValid("Andrei123"));
    }

    @Then("^Verify the username$")
    public void Verify_Username() {
        Validator es = new Validator();
        System.out.println(es.Password_isValid("Andrei"));
    }
}