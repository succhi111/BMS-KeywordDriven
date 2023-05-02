package com.bridgelabz.keyword;

import com.bridgelabz.keyword.engine.KeywordEngine;
import org.testng.annotations.Test;

public class BookMovieTest {
    KeywordEngine keywordEngine;

    @Test
    public void bookMovieTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("bookMovie");

    }
}

