package io.cucumber.simple.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final String ITEM_INPUT = "input[class='new-todo']";
    private static final String ITEM_LIST = "ul[class='todo-list']";

    public MainPage() {
        $(ITEM_INPUT).waitUntil(Condition.visible, ELEMENT_LOAD_TIMEOUT);
    }

    public void addItem(String itemName) {
        $(ITEM_INPUT)
                .setValue(itemName)
                .sendKeys(Keys.ENTER);
    }


    public List<Item> getAllItems() {
        return $(ITEM_LIST).$$("li").stream()
                .map(s -> new Item(s.$("label").getText(), s.getAttribute("class").contains("completed")))
                .collect(Collectors.toList());
    }
}
