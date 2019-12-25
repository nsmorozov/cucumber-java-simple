package io.cucumber.simple.pages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemView {

    private String title;
    private Boolean isChecked;
}
