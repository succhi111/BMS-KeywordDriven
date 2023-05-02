package com.bridgelabz.keyword.engine;

import com.bridgelabz.keyword.base.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KeywordEngine {

    public WebDriver driver;
    public Properties properties;
    BaseClass baseClass;
    WebElement element;

    public static Workbook workbook;
    public static Sheet sheet;

    public String scenario_sheet_path = System.getProperty("user.dir") + "/src/main/resources/BMS-KEYWORD.xlsx";

    public void starExecution(String sheetName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(scenario_sheet_path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetName);

        int c = 0;
        for (int r = 0; r < sheet.getLastRowNum(); r++) {

            try {
                String locatorType = sheet.getRow(r + 1).getCell(c + 1).toString().trim();
                String locatorValue = sheet.getRow(r + 1).getCell(c + 2).toString().trim();
                String action = sheet.getRow(r + 1).getCell(c + 3).toString().trim();
                String value = sheet.getRow(r + 1).getCell(c + 4).toString().trim();


                switch (action) {
                    case "openBrowser":
                        baseClass = new BaseClass();

                        properties = baseClass.initializeProperties();

                        if (value.isEmpty() || value.equals("NA")) {
                            driver = baseClass.launchBrowser(properties.getProperty("browser"));
                        } else {
                            driver = baseClass.launchBrowser(value);
                        }
                        break;
                    case "enterUrl":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(properties.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;

                    case "quit":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.quit();
                        break;
                    case "close":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.close();
                        break;
                    default:
                        break;
                }

                switch (locatorType) {
                    case "id":
                        Thread.sleep(10000);
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(4000);
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "name":
                        Thread.sleep(5000);
                        element = driver.findElement(By.name(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(4000);
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "xpath":
                        Thread.sleep(5000);
                        element = driver.findElement(By.xpath(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(5000);
                            System.out.println("Element displayed: " + element.isDisplayed());
                        } else if (action.equalsIgnoreCase("isSelected")) {
                            element.isSelected();
                        } else if (action.equalsIgnoreCase("isEnabled")) {
                            element.isEnabled();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "cssSelector":
                        Thread.sleep(5000);
                        element = driver.findElement(By.cssSelector(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();

                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(4000);
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("isSelected")) {
                            element.isSelected();
                        } else if (action.equalsIgnoreCase("isEnabled")) {
                            element.isEnabled();
                        } else if (action.equalsIgnoreCase("getTitle")) {
                            driver.getTitle();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "className":
                        Thread.sleep(5000);
                        element = driver.findElement(By.className(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(4000);
                            element.isDisplayed();

                        } else if (action.equalsIgnoreCase("isSelected")) {
                            element.isSelected();

                        } else if (action.equalsIgnoreCase("isEnabled")) {
                            element.isEnabled();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "tagName":
                        Thread.sleep(5000);
                        element = driver.findElement(By.tagName(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            Thread.sleep(4000);
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("isSelected")) {
                            element.isSelected();
                        } else if (action.equalsIgnoreCase("isEnabled")) {
                            element.isEnabled();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "linkText":
                        Thread.sleep(5000);
                        element = driver.findElement(By.linkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                            Thread.sleep(5000);
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    case "partialLinkText":
                        element = driver.findElement(By.partialLinkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
