package io.cucumber.simple;

import io.cucumber.java.en.Given;

public class StepDefinitions {

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        System.out.println("Works for me");
        belly.eat(cukes);
    }
}
