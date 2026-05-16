package coachcloud.dev;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class loginpage extends setup {
	
	
	@Test(description="TC 001: Verify user cannot request reset password mail on unregistered email id")
	public void forgetpasswrongemail()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Forgot password?')]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Email'])[2]")).sendKeys("yashdesale567@gmail.com3");
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-f4gmv6 r-13qz1uu'] div[class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7']")).click();
		Reporter.log("Forget password email sent success", true);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until toast appears
        WebElement toast1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='toastText1']")
            )
        );

        
        String actualMessage = toast1.getText().trim();

        System.out.println("Toast Message: " + actualMessage);
		Reporter.log("\"Toast Message: \"" + actualMessage, true);


        Assert.assertEquals(actualMessage, "Password reset failed",
                "Toast message mismatch!");
        
        
        
        driver.findElement(By.cssSelector("a[role='link'] div[class='css-146c3p1 r-1m72y5m r-135wba7']")).click();
    }
    

/*
	
	@Test(description="TC 002: Verify user can attempt forget password flow")
	public void forgetpasscorrectemail()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Forgot password?')]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Email'])[2]")).sendKeys("yashdesale567@gmail.com");
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-f4gmv6 r-13qz1uu'] div[class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7']")).click();
		Reporter.log("Forget password email sent success", true);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until toast appears
        WebElement toast2 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='toastText1']")
            )
        );

        
        WebElement toast = ";
		String actualMessage = toast.getText().trim();

        System.out.println("Toast Message: " + actualMessage);
		Reporter.log("Toast Message: " + actualMessage, true);


        Assert.assertEquals(actualMessage, "Password sent success",
                "Toast message mismatch!");
    }
	
	
	*/
	
	@Test(description="TC 003: Verify user cannot login with wrong / invalid credential")
	public void logininvalidcred()
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		Reporter.log("Invalid credential case method success", true);

		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).click();
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).sendKeys("yashdesale567@gmail.com1");
		driver.findElement(By.cssSelector("input[placeholder='********']")).click();
		driver.findElement(By.cssSelector("input[placeholder='********']")).sendKeys("yashdesale567@gmail.com1");
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-13qz1uu'] div[class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast3 = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("[data-testid='toastText1']")
	            )
	        );

	        
	        String actualMessage = toast3.getText().trim();

	        System.out.println("Toast Message: " + actualMessage);
			Reporter.log("\"Toast Message: \"" + actualMessage, true);


	        Assert.assertEquals(actualMessage, "Failed to login",
	                "Toast message mismatch!");
	        
	        
	
    }
	
	
	
	
	
	@Test(description="TC 004: Verify user can login with correct / valid credential")
	public void loginvalidcred()
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		Reporter.log("Valid credential case method success", true);

		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).click();
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).sendKeys("ymak98765@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='********']")).click();
		driver.findElement(By.cssSelector("input[placeholder='********']")).sendKeys("Asdfg@123");
		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-13qz1uu'] div[class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast4 = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("[data-testid='toastText1']")
	            )
	        );

	        
	        String actualMessage = toast4.getText().trim();

	        System.out.println("Toast Message: " + actualMessage);
			Reporter.log("\"Toast Message: \"" + actualMessage, true);


	        Assert.assertEquals(actualMessage, "Welcome back!", "Toast message mismatch!");
	        
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

	
    }
	
	
	
	
	
	
	
	
}


