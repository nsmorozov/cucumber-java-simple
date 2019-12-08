package io.cucumber.simple.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

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

    private List<SelenideElement> getItemByName(String itemName){
        return $$x(ITEM_VIEW).stream().filter(e -> e.$("label").getText().equalsIgnoreCase(itemName)).collect(Collectors.toList());
    }

    public void toggleItem(String itemName){
        List<SelenideElement> elementList = getItemByName(itemName);
        elementList.stream().findFirst().orElseThrow(NoSuchElementException::new).$("input").click();
    }

    public void toggleAllItems(String itemName){
        List<SelenideElement> elementList = getItemByName(itemName);
        elementList.forEach(e -> {
            System.out.println("clicking on " + e.getText());
            e.$("input").click();
        });
    }
}
