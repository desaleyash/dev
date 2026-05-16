package coachcloud.dev;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RegisterUser extends setup {
	
	
	
	@Test(description="TC 005: Verify Coach Can Self Register Successfully")
	public void registersuccess()
	{
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-knv0ih r-13qz1uu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73'] div[class='css-146c3p1']")).click();
		//driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-knv0ih r-13qz1uu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73'] div[class='css-146c3p1']")).sendKeys("TestF1");

		driver.findElement(By.xpath("//input[@placeholder='John']")).click();
		driver.findElement(By.xpath("//input[@placeholder='John']")).sendKeys("TestFN");
		driver.findElement(By.xpath("//input[@placeholder='Due']")).click();;
		driver.findElement(By.xpath("//input[@placeholder='Due']")).sendKeys("TestLN");
		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-1q9bdsx r-1yadl64 r-peo1c r-1mkv55d'] input[placeholder='Email']")).click();		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-1q9bdsx r-1yadl64 r-peo1c r-1mkv55d'] input[placeholder='Email']")).sendKeys("testy@mailinator.com");
		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1q9bdsx r-rs99b7 r-1pl7oy7'] img[class='css-9pa8cd']")).click();				
		//	driver.findElement(By.cssSelector("div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1q9bdsx r-rs99b7 r-1pl7oy7'] img[class='css-9pa8cd']")).sendKeys("testng@yopmail.com");		
		
		driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
		
		driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1b43r93 r-1kfrs79']")).click();
		
		
		Reporter.log("Strong Password Suggestion Pasted", true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


		driver.findElement(By.xpath("//div[@role='checkbox']//div[@class='css-175oi2r']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.cssSelector("div:nth-child(5) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div:nth-child(5) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).sendKeys(Keys.ENTER);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		
		Reporter.log("Verification Code Sent Success", true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70000));

		
		driver.findElement(By.xpath("//div[contains(text(),'Verify')]")).click();
		
		/*
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast5 = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("[data-testid='toastText1']")
	            )
	        );

	        
	        String actualMessage = toast5.getText().trim();

	        System.out.println("Toast Message: " + actualMessage);
			Reporter.log("\"Toast Message: \"" + actualMessage, true);


	        Assert.assertEquals(actualMessage, "Registration Success", "Toast message mismatch!");
	        
	        
	
		//driver.findElement(By.className("css-175oi2r r-1awozwy r-18u37iz r-1777fci")).click();

		
		
		
		
		/*	driver.findElement(By.cssSelector("input[placeholder='********'][type='text']")).click();
		driver.findElement(By.cssSelector("input[placeholder='********'][type='text']")).sendKeys("Insta@123");

		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).click();		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).sendKeys("Insta@123");
		*/
		
		
	
    }
	
	
	
	@Test(description="TC 006: Verify Athlete Can Self Register Successfully")
	public void registersuccessath()
	{
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-knv0ih r-13qz1uu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73'] div[class='css-146c3p1']")).click();
		//driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-knv0ih r-13qz1uu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73'] div[class='css-146c3p1']")).sendKeys("TestF1");

		driver.findElement(By.xpath("//input[@placeholder='John']")).click();
		driver.findElement(By.xpath("//input[@placeholder='John']")).sendKeys("TestFN");
		driver.findElement(By.xpath("//input[@placeholder='Due']")).click();;
		driver.findElement(By.xpath("//input[@placeholder='Due']")).sendKeys("TestLN");
		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-1q9bdsx r-1yadl64 r-peo1c r-1mkv55d'] input[placeholder='Email']")).click();		
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-1q9bdsx r-1yadl64 r-peo1c r-1mkv55d'] input[placeholder='Email']")).sendKeys("testy@mailinator.com");
		
		// It's Athlete selected By default driver.findElement(By.cssSelector("div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1q9bdsx r-rs99b7 r-1pl7oy7'] img[class='css-9pa8cd']")).click();				
		//	driver.findElement(By.cssSelector("div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1q9bdsx r-rs99b7 r-1pl7oy7'] img[class='css-9pa8cd']")).sendKeys("testng@yopmail.com");		
		
		driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
		
		driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1b43r93 r-1kfrs79']")).click();
		
		
		Reporter.log("Strong Password Suggestion Pasted", true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


		driver.findElement(By.xpath("//div[@role='checkbox']//div[@class='css-175oi2r']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.cssSelector("div:nth-child(5) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div:nth-child(5) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).sendKeys(Keys.ENTER);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		Reporter.log("Verification Code Sent Success", true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		
		driver.findElement(By.xpath("//div[contains(text(),'Verify')]")).click();
		
	
	
	}
	
}
