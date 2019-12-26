package io.cucumber.simple;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.simple.pages.ItemView;
import io.cucumber.simple.pages.MainPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
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
        List<ItemView> addedItemViews = new MainPage().getAllItemViews();
        assertThat(addedItemViews).extracting(ItemView::getTitle).containsAnyOf(itemName);
    }

    @Then("I mark item with the name {string} done")
    public void iMarkItemWithTheNameDone(String itemName) {
        new MainPage().toggleAllItems(itemName);
        System.out.println();
    }

    @Then("Items should be checked")
    public void itemsShouldBeChecked(List<String> items) {
        System.out.printf("");
    }
}
