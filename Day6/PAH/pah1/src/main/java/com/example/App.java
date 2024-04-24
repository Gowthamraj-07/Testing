package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        driver.get("https://www.moneycontrol.com/");  
        driver.manage().window().maximize();  
        driver.navigate().refresh();
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Reliance Industries")).click();
        String name=driver.findElement(By.xpath("//*[@id='stockName']/h1")).getText();
        System.out.println(name);
        WebElement funds=driver.findElement(By.linkText("Mutual Funds"));
        Actions actions=new Actions(driver);
        actions.moveToElement(funds).perform();
        driver.findElement(By.linkText("SIP Return")).click();
        WebElement fundChoice=driver.findElement(By.id("ff_id"));
        Select select = new Select(fundChoice);
        select.selectByValue("AA");
        WebElement scheme=driver.findElement(By.id("im_id"));
        Select select2 = new Select(scheme);
        select2.selectByValue("MAA587");
        driver.findElement(By.name("invamt")).sendKeys("100,000");
        WebElement frequency=driver.findElement(By.id("frq"));
        Select select3 = new Select(frequency);
        select3.selectByValue("mtly");
        driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
        driver.findElement(By.id("endt")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
        String period=driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[1]")).getText();
        String period_val=driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[2]")).getText();
        System.out.println(period+" : "+period_val);
        String invest=driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]/td[1]")).getText();
        String invest_val=driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]/td[2]")).getText();
        System.out.println(invest+" : "+invest_val);
        
            
        
    }
}
