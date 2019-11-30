package io.cucumber.simple.pages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private String title;
    private Boolean isChecked;
}
