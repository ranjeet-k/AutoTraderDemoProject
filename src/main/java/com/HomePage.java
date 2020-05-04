package com;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    //WebDriver driver=new ChromeDriver();
     //public static void main(String args[]){


    WebDriver driver;


//    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
//    driver=new ChromeDriver();
//    public WebElement browseByMake=driver.findElement(By.xpath("//button[contains(text(),'Browse by Make')]"));
//    public WebElement browseByStyle=driver.findElement(By.xpath("//button[contains(text(),'Browse by Style')]"));
//    public WebElement advancedSearch=driver.findElement(By.xpath("//a[contains(text(),'Advanced Search')]"));
//    public WebElement searchButton=driver.findElement(By.xpath("//button[@id='search']"));
//    public WebElement makeDropdown=driver.findElement(By.xpath("//select[@id='makeCode']"));
//    public WebElement modelDropdown=driver.findElement(By.xpath("//select[@id='ModelCode']"));
//    public WebElement autoTraderLogo=driver.findElement(By.xpath("//img[@class='display-inline-block display-lg-none ae-img']"));

    // }

     public void openBrowser() throws InterruptedException {

         System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
         driver=new ChromeDriver();
         driver.navigate().to("https://www.autotrader.com/");
         driver.manage().window().maximize();
         Thread.sleep(5000);

     }

     public void verifyLinks(){
         WebElement browseByMake=driver.findElement(By.xpath("//button[contains(text(),'Browse by Make')]"));
         WebElement browseByStyle=driver.findElement(By.xpath("//button[contains(text(),'Browse by Style')]"));
         WebElement advancedSearch=driver.findElement(By.xpath("//a[contains(text(),'Advanced Search')]"));
         WebElement searchButton=driver.findElement(By.xpath("//button[@id='search']"));
         WebElement makeDropdown=driver.findElement(By.xpath("//select[@id='makeCode']"));
         WebElement modelDropdown=driver.findElement(By.xpath("//select[@id='ModelCode']"));
         Assert.assertTrue("Elements are not visible",browseByMake.isDisplayed());
         Assert.assertTrue("Elements are not visible",browseByStyle.isDisplayed());
         Assert.assertTrue("Elements are not visible",advancedSearch.isDisplayed());
         Assert.assertTrue("Elements are not visible",searchButton.isDisplayed());
         Assert.assertTrue("Elements are not visible",makeDropdown.isDisplayed());
         Assert.assertTrue("Elements are not visible",modelDropdown.isDisplayed());
         driver.close();
     }

     public void verifyHomePage() throws InterruptedException {
         WebDriverWait wait = new WebDriverWait(driver, 50);
         WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'More about Home Services')]")));
         Assert.assertTrue("Element is not displayed",signIn.isDisplayed());

     }

     public void fillTheAdvancedSearchForm(){
         driver.findElement(By.xpath("//a[contains(text(),'Advanced Search')]")).click();
         driver.findElement(By.xpath("//input[@name=\"zip\"]")).sendKeys("30004");
         driver.findElement(By.xpath("//div[contains(text(),'Certified')]")).click();
         driver.findElement(By.xpath("//div[contains(text(),'Convertible')]")).click();
         driver.findElement(By.xpath("//select[@id='4101482096']")).sendKeys("2017");
         driver.findElement(By.xpath("//select[@id='258002540']")).sendKeys("2020");
         Select make=new Select(driver.findElement(By.xpath("//select[@id='1970425032']")));
         make.selectByValue("BMW");
         driver.findElement(By.xpath("//*[@type='submit' and contains(text(),'Search')]")).click();
     }



     public void getTheListOfResults(){
         List<WebElement> totalResults=driver.findElements(By.xpath("//div[@class='text-left col-xs-8']"));
         System.out.println("Number of BMW car on the page is :"+totalResults.size());
        // Boolean bmw= false;
         for (WebElement result: totalResults
              ) {
            // bmw = result.getText().contains("BMW");
             Assert.assertTrue("Cars are not BMW",result.getText().contains("BMW"));
         }
         /*if (bmw == true){
             Assert.assertTrue("Cars are not BMW");
         }*/

     }







}
