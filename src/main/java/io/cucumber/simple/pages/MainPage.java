package io.cucumber.simple.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import utils.Timeouts;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    private static final String ITEM_INPUT = "input[class='new-todo']";
    private static final String ITEM_VIEW = ".//li[div[@class='view']]";
    private static final String ITEM_COUNTER_MESSAGE = ".todo-count>*";

    public MainPage() {
        $(ITEM_INPUT).waitUntil(Condition.visible, Timeouts.ELEMENT_LOAD);
    }

    public void addItem(String itemName) {
        $(ITEM_INPUT)
                .setValue(itemName)
                .sendKeys(Keys.ENTER);
    }

    private List<Item> getItemByName(String itemName){
        return $$x(ITEM_VIEW).stream()
                .filter(e -> e.$("label").getText().equalsIgnoreCase(itemName))
                .map(Item::new)
                .collect(Collectors.toList());
    }

    public List<Item> getItems() {
        return $$x(ITEM_VIEW).stream()
                .map(Item::new)
                .collect(Collectors.toList());
    }

    public void checkItem(String itemName) {
        List<Item> elementList = getItemByName(itemName);
        if (!elementList.get(0).isChecked()) {
            elementList.get(0).toggleItem();
        }
    }

    public void unCheckItem(String itemName) {
        List<Item> elementList = getItemByName(itemName);
        if (elementList.get(0).isChecked()) {
            elementList.get(0).toggleItem();
        }
    }

    public void toggleAllItems(String itemName){
        List<Item> elementList = getItemByName(itemName);
        elementList.forEach(e -> {
            System.out.println("Clicking on " + e.getTitle());
            e.toggleItem();
        });
    }

    public String getCounterMessage() {
        StringBuilder b = new StringBuilder();
        $$(ITEM_COUNTER_MESSAGE).forEach(e -> {
            if(!e.text().isEmpty()) {
                b.append(e.text()).append(" ");
            }
        });
        return b.toString().trim();
    }
}
