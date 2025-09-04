package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading7Page {

    public LoopPracticeDynamicLoading7Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "alert")
    public WebElement doneMessage;

    @FindBy (xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;

    @FindBy (xpath ="//a[@href='dynamic_loading/7.html']")
    public WebElement getDynamicLoading7;
}