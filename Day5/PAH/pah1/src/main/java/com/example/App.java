package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();;
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.name("q")).sendKeys("Shoes"+Keys.ENTER);
        String value=driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).getText();
        if(value.contains("Shoes"))
          System.out.println("Contains the text");
        else
          System.out.println("Does not contain the text");
   
        WebElement Men=driver.findElement(By.xpath("//*[@id='ui-id-5']"));
        Actions action = new Actions(driver);
        action.moveToElement(Men).perform();
 
        WebElement Tops= driver.findElement(By.linkText("Tops"));
        action.moveToElement(Tops).perform();
      
        driver.findElement(By.linkText("Hoodies & Sweatshirts")).click();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]")).click();
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[4]/ol/li[3]")).click();
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='option-label-size-143-item-168']")).click();
        driver.findElement(By.xpath("//*[@id='option-label-color-93-item-56']")).click();
        WebElement qty=driver.findElement(By.name("qty"));
        qty.clear();
        qty.sendKeys("3");
        driver.findElement(By.id("product-addtocart-button")).submit();
    }
}
