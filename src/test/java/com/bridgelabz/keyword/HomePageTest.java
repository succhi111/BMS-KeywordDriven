package com.bridgelabz.keyword;

import com.bridgelabz.keyword.engine.KeywordEngine;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.bridgelabz.keyword.base.BaseClass.driver;

public class HomePageTest {
    KeywordEngine keywordEngine;

    public String verifyHomePageTitle() {

        return driver.getTitle();
    }

    @Test
    public void verifyHomePageTitleTest() {

        Assert.assertEquals(verifyHomePageTitle(), "ovie Tickets, Plays, Sports, Events & Cinemas near Mumbai - BookMyShow");
    }

    @Test
    public void homePageTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("homePage");

    }
}


