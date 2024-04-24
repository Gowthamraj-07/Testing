package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Phones")).click();
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(3000);
        String name=driver.findElement(By.xpath("//*[@id='tbodyid']/h2")).getText();
        System.out.println(name);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        String title=driver.getTitle();
        Dimension pageSize = driver.manage().window().getSize();
        System.out.println(title);
        System.out.println(pageSize);
        driver.quit();
    }
}
