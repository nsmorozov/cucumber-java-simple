package io.cucumber.simple;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        Belly belly = new Belly();
        System.out.println("Works for me");
        belly.eat(cukes);
    }

    @Then("I open home page")
    public void iOpenHomePage() {
        open("https://www.google.com");
        System.out.println();
    }
}
