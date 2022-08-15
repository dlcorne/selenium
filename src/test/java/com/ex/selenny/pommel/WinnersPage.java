package com.ex.selenny.pommel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WinnersPage {

    @FindBy(css = "#ls-row-RS1-L > td.name-col.align-left > a")
    private WebElement winner;

    public String getWinnerResult() {
        return this.winner.getText();
    }
}