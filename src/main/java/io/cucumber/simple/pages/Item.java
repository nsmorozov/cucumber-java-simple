package io.cucumber.simple.pages;

public class Item {

    private String title;
    private Boolean isChecked;

    public Item(String title, Boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }
}
