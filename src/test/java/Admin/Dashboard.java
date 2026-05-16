package Admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import coachcloud.dev.setup;

public class Dashboard extends setup {
	
	@Test(description="TC 007: Verify Admin user logged in")
	public void adminuserconfirm()
	{
		Reporter.log("Admin is on Dashboard", true);

		
		/*WebElement adminText = driver.findElement( By.xpath("//div[@class='css-146c3p1 r-10x49cs r-vw2c0b r-ud0q2t r-tsynxw']"));
		System.out.println("Title Found: "+ adminText);
		Assert.assertTrue(adminText.isDisplayed(),"ADMIN text is not displayed on Dashboard");
		
		*/

		// 1. Use a more stable locator than the long CSS string
		WebElement adminText = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-10x49cs r-vw2c0b r-ud0q2t r-tsynxw']"));

		// 2. Print the actual text (better for debugging than the object reference)
		System.out.println("User Role Text Found: " + adminText.getText());

		// 3. Combined Assertion: Check visibility and content in one go
		Assert.assertTrue(adminText.getText().equals("ADMIN"),  "ADMIN text was either not displayed or the text content did not match.");
		
	
}

	@Test(description="TC 008: Verify Notification module accessible")
	public void notificationclick()
	{
		driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r r-1awozwy r-18u37iz r-10eez6h']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]")).click();
		driver.findElement(By.xpath("//div[@class='css-175oi2r r-1loqt21 r-1otgn73 r-kdyh1x r-vuvdlw r-3o4zer']//div[1]")).click();
		
		WebElement NotificationText = driver.findElement(By.cssSelector(".css-175oi2r.r-3lgkqa.r-5kkj8d.r-1l7z4oj.r-3pj75a"));

		// 2. Print the actual text (better for debugging than the object reference)
		System.out.println("Notifications Header Found: " + NotificationText.getText());

		// 3. Combined Assertion: Check visibility and content in one go
		Assert.assertTrue(NotificationText.getText().equals("Notifications"),  "Notifications text was either not displayed or the text content did not match.");
		
	}
	
	
	
	
	
}
