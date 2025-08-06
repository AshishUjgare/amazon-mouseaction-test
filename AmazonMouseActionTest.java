package com.gqt.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class AmazonMouseActionTest {

	public static void main(String[] args) throws Exception {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		
		//Creation object of action class by passing driver as parameter
          Actions act = new Actions(driver);
          
          //Welcome Page 
          WebElement accountAndListSection = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
          WebElement yourAccountLink = driver.findElement(By.xpath("//span[text()='Your Account']"));
          
          
          
          //Hover over account list amd click on Your Account 
          
          act.moveToElement(accountAndListSection).pause(Duration.ofSeconds(2)).
          moveToElement(yourAccountLink).pause(Duration.ofSeconds(2)).click().build().perform();
          
          
          //Your Account Page 
          WebElement couponLink = driver.findElement(By.xpath("//a[text()='Coupons']"));
          WebElement yourOrders = driver.findElement(By.xpath("//div[@data-card-identifier='YourOrders']"));
          
          //Click on coupons
          
          act.moveToElement(couponLink).pause(Duration.ofSeconds(2)).click().build().perform();
          Thread.sleep(2000);
          
          driver.navigate().back();
          
          //Click on your orders
          act.moveToElement(yourOrders).pause(Duration.ofSeconds(2)).click().build().perform();
          Thread.sleep(2000);
          
          
          //your orders page 
          
          WebElement emailTf = driver.findElement(By.xpath("//input[@name='email']"));
          WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
          
          //Enter Mail and click on continue
          
          act.moveToElement(emailTf).pause(Duration.ofSeconds(2)).pause(Duration.ofSeconds(2)).sendKeys("ashish@jay.com").pause(Duration.ofSeconds(2))
          .moveToElement(continueBtn).pause(Duration.ofSeconds(1)).click().build().perform();
          
          //Error message check in password screen and Take sceenshot 
          Thread.sleep(2000);
          
          WebElement emailErrorMsg = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[1]"));
          
          if (emailErrorMsg.isDisplayed()) {
        	  System.out.println("Error Message Displayed");
        	  clickScreenshot(driver, "C:\\Users\\Ashish Ujgare\\OneDrive\\Desktop\\screenshots\\AmazonLoginError.jpeg");
        	  
          }
          
         
   
          
          

	}

	private static void clickScreenshot(ChromeDriver driver, String destLocation) throws IOException {
	//To convert webDriver object to take screenshot object 
		
		TakesScreenshot takeScreenshot =((TakesScreenshot) driver);
		
		
		// take screenshot as file
		
		File srcshot= takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		//Save file in destination folder
		
		File destFile = new File(destLocation);
		
		//copy the screenshot
		Files.copy(srcshot, destFile);
	}		
	

}
