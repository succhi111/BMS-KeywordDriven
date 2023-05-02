package com.bridgelabz.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static com.bridgelabz.base.BaseClass.driver;


public class Utility {
    public static void captureScreenshot() {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs((OutputType.FILE));

        File destinationFile = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + "_screenshot.png");

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}