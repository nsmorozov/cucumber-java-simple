package io.cucumber.simple.pages;

import com.codeborne.selenide.SelenideElement;

public class Item {

    private SelenideElement root;

    public Item(SelenideElement root) {
        this.root = root;
    }

    public String getTitle() {
        return root.$("label").getText();
    }

    public boolean isChecked() {
        return root.getAttribute("class").equalsIgnoreCase("completed");
    }

    public void toggleItem() {
        root.$("input").click();
    }
}
