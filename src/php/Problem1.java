package php;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Task22Problem {
	
	@Test
	public void testSet() throws Exception {
		// Create a new instance of the Chrome driver
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			
			d.manage().deleteAllCookies();
	
			// Launch the URL
			d.get("https://phptravels.com/demo/");
			
			// Wait until an element is visible on the page
	        WebDriverWait wait = new WebDriverWait(d, Duration.ofMinutes(2)); // Wait for a maximum of 10 seconds
	         //wait.until(ExpectedCondition.visibilityOfElementLocated(By 		//visibilityOfElementLocated(By.id("myElement")));
			
			//verify the page The Internet
			assertEquals(d.getTitle(),"Book Your Free Demo Now - Phptravels");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
			//Enter First Name
			WebElement firstname = d.findElement(By.xpath("//input[@name='first_name']"));
			firstname.sendKeys("vinoth");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='last_name']")));
			//Enter Last Name
			WebElement lastname = d.findElement(By.xpath("//input[@name='last_name']"));
			lastname.sendKeys("N S");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Business Name']")));
			//Enter Business Name
			WebElement businessname = d.findElement(By.xpath("//input[@placeholder='Business Name']"));
			businessname.sendKeys("Guvi Business");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			//Enter email ID
			WebElement email = d.findElement(By.name("email"));
			email.sendKeys("testuser@gmail.com");
			
			Thread.sleep(2000);
		//Logic for sum verification
					//Locate number1
					WebElement number1 = d.findElement(By.xpath("//span[@id='numb1']"));
					String num1 = number1.getText();
					//Convert string into Integer
					int n1= Integer.parseInt(num1);
					
					//Locate number2
					WebElement number2 = d.findElement(By.xpath("//span[@id='numb2']"));
					String num2 = number2.getText();
					int n2 = Integer.parseInt(num2);
					
					//calculating sum of two numbers
					int sum = n1+n2;
					// converting this sum into string because sendkeys method will take String as a parameter
					String sum1 = Integer.toString(sum);
					
					//Enter sum value
					WebElement result = d.findElement(By.id("number"));
					result.sendKeys(sum1);
		
			// Click on submit
			d.findElement(By.xpath("//button[@id='demo']")).click();
			//Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center cw']")));
			//Verify ThankYou message
			WebElement message1 = d.findElement(By.xpath("//h2[@class='text-center cw']"));
			assertEquals(message1.getText(),"Thank you!");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-center cw']")));
			//Verify the description
			WebElement message2 = d.findElement(By.xpath("//p[@class='text-center cw']"));
			assertEquals(message2.getText(),"We have sent your demo credentials to your email please check your email to test demo website. if message not found inbox please check spam folder");
			
			//Thread.sleep(2000);
			
			//Take screenshot
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			//to copy screenshot into local folder & specify the file type
			FileUtils.copyFile(screenshotFile, new File("F:\\GUVI\\Screenshots\\task22.jpg"));
			Thread.sleep(2000);
			
			//Close the browser instance
			d.quit();
	}
}

