package com.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.get("https://economictimes.indiatimes.com/et-now/result");
        driver.manage().window().maximize();;
        driver.findElement(By.linkText("Mutual Funds")).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)","");
        WebElement amc=driver.findElement(By.id("amcSelection"));
        Select select= new Select(amc);
        select.selectByValue("8");
        Thread.sleep(1000);
        WebElement scheme=driver.findElement(By.id("schemenm"));
        Select select2=new Select(scheme);
        select2.selectByValue("15765");
        driver.findElement(By.id("anchor3")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//*[@id='installment_type']/li/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_type']/li/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();
        WebElement row = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        List<WebElement>td=row.findElements(By.tagName("td"));
        for(WebElement data:td)
        {
            System.out.println(data.getText());
        }


    }
}
