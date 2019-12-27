package io.cucumber.simple;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.simple.pages.Item;
import io.cucumber.simple.pages.MainPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

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
        List<Item> addedItems = new MainPage().getItems();
        assertThat(addedItems).extracting(Item::getTitle).containsAnyOf(itemName);
    }

    @Then("I mark all items with the name {string} done")
    public void iMarkItemWithTheNameDone(String itemName) {
        new MainPage().toggleAllItems(itemName);
        System.out.println();
    }

    @Then("Items should be checked")
    public void itemsShouldBeChecked(List<String> expectedItems) {
        List<Item> items = new MainPage().getItems().stream().filter(Item::isChecked).collect(Collectors.toList());
        assertThat(items).as(format("All items %s should be checked", expectedItems))
                .extracting(Item::getTitle)
                .containsAll(expectedItems);
    }

    @When("I mark single item with the name {string}")
    public void iMarkSingleItemWithTheName(String itemName) {
        new MainPage().checkItem(itemName);
    }

    @Then("Counter should show {string}")
    public void counterShouldShow(String counterStatus) {
        assertThat(new MainPage().getCounterMessage())
                .as("Counter message should contain correct number of left items")
                .isEqualToIgnoringCase(counterStatus);
    }
}
