package com.ex.selenny.pommel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LosersPage {

    @FindBy(css = "#ls-row-HLN-L > td.name-col.align-left > a")
    private WebElement loser;

    public String getLoserResult() {
        return this.loser.getText();
    }
}