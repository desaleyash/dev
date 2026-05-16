package Coach;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Admin.testutils;
import coachcloud.dev.setup;

public class dashboard extends setup 
{
	
	public String athemail = testutils.generateEmail();

	
	
	
	
	private static final String Threads = null;
	@Test(description = "TC 014: Verify coach is able to login with credentials", priority = 11)
	public void coachlogin() throws InterruptedException
	{
		//public void logoutadmin()
		//{
			driver.findElement(By.xpath("//body/div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-17gur6a r-13l2t4g r-1p0dtai r-1pi2tsx r-1d2f490 r-1udh08x r-1l7z4oj r-95jzfe r-1xcajam r-ipm5af r-sfbmgh']/div[@class='css-175oi2r r-5kkj8d r-95jzfe']/div[2]/div[1]")).click();
		//}
			
			Thread.sleep(2000);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

			Reporter.log("Valid credential case method success", true);

			driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).click();
			driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-18u37iz r-1udh08x r-n1edft r-1wioyrx r-1q9bdsx r-rs99b7 r-19yznuf'] input[placeholder='Email']")).sendKeys("yashcoach@yopmail.com");
			driver.findElement(By.cssSelector("input[placeholder='********']")).click();
			driver.findElement(By.cssSelector("input[placeholder='********']")).sendKeys("Insta@123");
			driver.findElement(By.cssSelector("div[class='css-175oi2r r-1awozwy r-13qz1uu'] div[class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement toast4 = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                By.cssSelector("[data-testid='toastText1']")) );

		        
		        String actualMessage = toast4.getText().trim();

		        System.out.println("Toast Message: " + actualMessage);
				Reporter.log("\"Toast Message: \"" + actualMessage, true);


		        Assert.assertEquals(actualMessage, "Welcome back!", "Toast message mismatch!");
		        
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		
	    }
		
		
	
	@Test(description="TC 007: Confirm that Coach logged in Successfully", priority = 12)

	public void dashboardvalid()
	{
			Reporter.log("Coach is on Dashboard", true);

			
			/*WebElement adminText = driver.findElement( By.xpath("//div[@class='css-146c3p1 r-10x49cs r-vw2c0b r-ud0q2t r-tsynxw']"));
			System.out.println("Title Found: "+ adminText);
			Assert.assertTrue(adminText.isDisplayed(),"ADMIN text is not displayed on Dashboard");
			
			*/

			// 1. Use a more stable locator than the long CSS string
			WebElement coachText = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-10x49cs r-vw2c0b r-ud0q2t r-tsynxw']"));

			// 2. Print the actual text (better for debugging than the object reference)
			System.out.println("User Role Text Found: " + coachText.getText());

			// 3. Combined Assertion: Check visibility and content in one go
			Assert.assertTrue(coachText.getText().equals("COACH"),  "Coach text was either not displayed or the text content did not match.");
			
		
	}
	@Test(description="TC 007: Verify Sections present in the dashboard", priority = 13)
	public void dashboardcontentverify() throws InterruptedException

	{
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * // SESSION LOGS WebElement sessionLogs = wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//*[text()='SESSION LOGS']") ) );
		 * 
		 * // ROSTER OVERVIEW WebElement rosterOverview = wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//*[text()='ROSTER OVERVIEW']") ) );
		 * 
		 * // GROUP MANAGEMENT WebElement groupManagement = wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//*[text()='GROUP MANAGEMENT']") ) );
		 * 
		 * System.out.println(sessionLogs + " " + rosterOverview + " " +
		 * "groupManagement "+ "All texts found successfully");
		 */
		
		Thread.sleep(3000);

		String[] headers = {
			    "STAFF MANAGEMENT",
			    "SESSION LOGS",
			    "ROSTER OVERVIEW",
			    "GROUP MANAGEMENT"};

		for (String header : headers) {

		    boolean isPresent = driver.getPageSource().contains(header);

		    System.out.println("Checking: " + header + " → " + isPresent);

		    if (isPresent) {
		        //System.out.println(header + " section is present on the page");
		        Reporter.log(header + " section is present on the page", true);
		    }}
		
	}
	
	
	
	@Test(description="TC 007: Check coach's plan detail", priority = 14)
	public void coachplandetail() throws InterruptedException

	{
	Thread.sleep(2000);
				// 1. Use a more stable locator than the long CSS string
				WebElement coachPlan = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1gkfh8e r-vw2c0b r-ud0q2t r-tsynxw']"));

				// 2. Print the actual text (better for debugging than the object reference)
				System.out.println("User Plan Found: " + coachPlan.getText());

				// 3. Combined Assertion: Check visibility and content in one go
				Assert.assertTrue(coachPlan.getText().equals("FREE PLAN"),  "Coach text was either not displayed or the text content did not match.");
	
	}
	
	
	
	

	
	
	@Test(description = "TC 014: Verify coach is able to fill all information at athlete invite popup", priority = 15)

	public void athinvitepopupfillinfo()
	{
		driver.findElement(By.xpath("//div[normalize-space()='ADD NEW ATHLETE']")).click();
		
		driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Yash");
		
		driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Autotest");
		
		
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(athemail);
		
		driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).sendKeys("HA007");
		
		Reporter.log("All information filled successfully",true);
		
		
	}
	
	
	@Test(description = "TC 014: Verify coach is not able to invite user if reach their limit", priority = 16)

	public void invitreachlimitdath()
	{
		driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1b43r93 r-vw2c0b'][normalize-space()='Invite']")).click();
		
		WebDriverWait wait004 = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement toast9 = wait004.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-146c3p1 r-13qz1uu']") ) );
		  
		  
		  String actualMessagee = toast9.getText().trim();

			
			  System.out.println("Toast Message: " + actualMessagee); Reporter.log("\"Toast Message: \"" + actualMessagee, true);
			  
			  Assert.assertEquals(actualMessagee, "You have reached the maximum number of athletes allowed by your license.", "Toast message mismatch!");
			  
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  
			  
	}
	
	public void inviteathletefromdashboard()
	{
		  
	}
	

}
