package io.cucumber.simple.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import utils.Timeouts;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class MainPage extends BasePage {

    private static final String ITEM_INPUT = "input[class='new-todo']";
    private static final String ITEM_LIST = "ul[class='todo-list']";
    private static final String ITEM_VIEW = ".//li[div[@class='view']]";

    public MainPage() {
        $(ITEM_INPUT).waitUntil(Condition.visible, Timeouts.ELEMENT_LOAD);
    }

    public void addItem(String itemName) {
        $(ITEM_INPUT)
                .setValue(itemName)
                .sendKeys(Keys.ENTER);
    }


    public List<ItemView> getAllItemViews() {
        return $(ITEM_LIST).$$("li").stream()
                .map(s -> new ItemView(s.$("label").getText(), s.getAttribute("class").contains("completed")))
                .collect(Collectors.toList());
    }

    private List<Item> getItemByName(String itemName){
        return $$x(ITEM_VIEW).stream()
                .filter(e -> e.$("label").getText().equalsIgnoreCase(itemName))
                .map(Item::new)
                .collect(Collectors.toList());
    }

    public void toggleAllItems(String itemName){
        List<Item> elementList = getItemByName(itemName);
        elementList.forEach(e -> {
            System.out.println("clicking on " + e.getTitle());
            e.toggleItem();
        });
    }
}
