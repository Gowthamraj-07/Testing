package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.get("https://demowebshop.tricentis.com/");
        String Homeurl="https://demowebshop.tricentis.com/";
        driver.findElement(By.linkText("Jewelry")).click();
        Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        if(url.contains("jewelry"))
            System.out.println("Verified - contains jewelry");
        else
          System.out.println("Failed - does not contain jewelry");
        driver.navigate().back();
        String Homeurl1=driver.getCurrentUrl();
        if(Homeurl.equals(Homeurl1))
          System.out.println("Same Url");
        else 
          System.out.println("Different Url");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
