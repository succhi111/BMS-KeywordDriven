package com.bridgelabz.keyword;

import com.bridgelabz.keyword.engine.KeywordEngine;
import org.testng.annotations.Test;

public class RatingTest {

    KeywordEngine keywordEngine;

    @Test
    public void ratingTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("ratingPage");

    }
}


