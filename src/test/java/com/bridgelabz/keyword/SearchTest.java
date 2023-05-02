package com.bridgelabz.keyword;

import com.bridgelabz.keyword.engine.KeywordEngine;
import org.testng.annotations.Test;

public class SearchTest {
    KeywordEngine keywordEngine;

    @Test
    public void searchTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("searchPage");

    }
}


