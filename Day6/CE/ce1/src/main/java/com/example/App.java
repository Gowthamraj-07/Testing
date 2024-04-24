package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");  
        driver.manage().window().maximize();  
        driver.navigate().refresh();
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Reliance Industries")).click();
        String name=driver.findElement(By.xpath("//*[@id='stockName']/h1")).getText();
        System.out.println(name);
        driver.findElement(By.linkText("Mutual Funds")).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)","");
        driver.findElement(By.linkText("SIP")).click();
    }
}
