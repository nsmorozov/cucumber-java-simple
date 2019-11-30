package io.cucumber.simple;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.simple.pages.Item;
import io.cucumber.simple.pages.MainPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class TodoSteps {

    @Given("I open todos application")
    public void iOpenTodosApplication() {
        open("http://todomvc.com/examples/react/#/");
    }

    @Then("I add new item with the name {string}")
    public void iAddNewItemWithTheName(String itemName) {
        new MainPage().addItem(itemName);
    }

    @Then("Item with name {string} was added")
    public void itemWithNameWasAdded(String itemName) {
        List<Item> addedItems = new MainPage().getAllItems();
        System.out.println();
    }
}
