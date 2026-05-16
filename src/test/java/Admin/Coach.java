package Admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import coachcloud.dev.setup;

public class Coach extends setup 
{

	public String email1 = testutils.generateEmail();

	@Test(description = "TC 008: Verify user listing displaying on coach module", priority = 12)

	public void coachpgsuccess() throws InterruptedException {
		
		
		  driver.get("https://staging.coachsuite.nl/dashboard");

		
		Thread.sleep(3000); 

		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1fuqb1j r-rs99b7 r-1b7e0jd r-1udh08x r-bnwqim r-13qz1uu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-1q9bdsx r-18u37iz r-9aw3ui r-11f147o r-3pj75a']")).click();

		WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(10));


		// 1. Use a more stable locator than the long CSS string
		WebElement adminText = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1ui5ee8 r-vw2c0b r-icto9i']"));

		// 2. Print the actual text (better for debugging than the object reference)
		System.out.println("Text Found: " + adminText.getText());

		// 3. Combined Assertion: Check visibility and content in one go
		Assert.assertTrue(adminText.getText().equals("Coaches"),"Coaches text was either not displayed or the text content did not match.");
		
		Reporter.log("Admin is on Coaches Module", true);

	}

	
	  
	  @Test(description="TC 009: Verify total coach count showing", priority=13)
	  
	  public void coachtotalcount() 
	  { 
	driver.findElement(By.xpath("(//div[@class='css-146c3p1 r-br8i5a r-n6v787'])[1]")).click();
	  
	  WebElement totalAthletes=driver.findElement(By.xpath("//*[contains(text(),'Total Coaches:')]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	  
	  System.out.println(totalAthletes.getText()); 
	  
	  }
	 
	  
	  
	  
	  
	  
	  @Test(description="TC 010: Verify search coach", priority=14)
	  
	  public void searchcoach() throws InterruptedException 
	  
	  {
	  
		  
	driver.findElement(By.cssSelector("input[placeholder='Search coaches...']")).click();
	  driver.findElement(By.cssSelector("input[placeholder='Search coaches...']")).sendKeys("Yash"); 
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  String athemail = "yashcoach@yopmail.com";
	  
	  try { WebElement user = driver.findElement( By.xpath("//*[contains(text(),'"+ athemail + "')]") );
	  
	  if(user.isDisplayed()) { System.out.println("User found: " + athemail); }
	  
	  } catch (Exception e) { System.out.println("User NOT found: " + athemail); }
	  Thread.sleep(2000); 
	  WebElement searchBox =driver.findElement(By.cssSelector("input[placeholder='Search coaches...']"));
	  
	  searchBox.clear(); 
	  driver.navigate().refresh();
	  Thread.sleep(4000);
	  
	  }
	  
	  
	  @Test(description="TC 011: Verify coach popup opens", priority=15) 
	  public void invpopupcchbyadmin() throws InterruptedException
	  
	  { 
		  // #Step 1: Invite popup open confirmation code 
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 
		  // 1.Use a more stable locator than the long CSS string 
		  WebElement popupText =driver.findElement(By. xpath("//div[normalize-space()='Invite a new coach to join the platform']"));
	  
	  // 2. Print the actual text (better for debugging than the object reference)
	  System.out.println("Text Found: " + popupText.getText());
	  
	  // 3. Combined Assertion: Check visibility and content in one go
	  Assert.assertTrue(popupText.getText().equals("Invite a new coach to join the platform"), "Popup doesn't open.");
	  
	  Reporter.log("Coach invite popup is opened", true); 
	  Thread.sleep(4000); 
	  
	  }
	  
	  
	  
	  
	  
	  @Test(description="TC 011: Verify admin cannot invite coach without mandatory information", priority=16) 
	  public void blankmandatefield() throws InterruptedException 
	  {
	  Thread.sleep(2000); 
	  // only email value
	  driver.findElement(By.cssSelector("input[placeholder='Add Coach...']")).click();
	  driver.findElement(By.cssSelector("input[placeholder='Add Coach...']")).sendKeys("yashcoach@yopmail.com"); 
	  // click invite button 
	  driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1b43r93 r-vw2c0b'][normalize-space()='Invite']")).click();
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed 
	  WebElement toast6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Missing Fields']")));
	  
	  
	  String actualMessageS = toast6.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessageS);
	  Reporter.log("\"Toast Message: \"" + actualMessageS, true);
	  
	  
	  Assert.assertEquals(actualMessageS, "Missing Fields","Toast message mismatch!"); 
	  Reporter.log("Admin is not able to invite coach without mandatory feilds Name OR Email", true); 
	  Thread.sleep(2000);
	  
	  
	  driver.navigate().refresh();
	  	  
	  
	  }
	  
	  
	  
	  
	  @Test(description="TC 012: Verify admin cannot invite an existing coach", priority=17) 
	  public void existchhinvbyadmin() throws InterruptedException 
	  {
		  
		  System.out.println(" existchhinvbyadmin() method executed");
		  
		  // click on add coach button 	
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 

		  // #Step 2: Fill All Info in popup 
		  WebElement emailcoach =driver.findElement(By.cssSelector("input[placeholder='Add Coach...']"));
		  emailcoach.clear();
		  emailcoach.sendKeys("yashcoach@yopmail.com"); 
	
		  //emailcoach.sendKeys(Keys.TAB);
		  //WebElement firstname= driver.switchTo().activeElement();
		  //firstname.sendKeys("Kirti");

		  driver.findElement(By.xpath("(//input[@type='text'])[1]" )).click();
		  driver.findElement(By.xpath("(//input[@type='text'])[1]" )).sendKeys("Kirti");
		  
		  //emailcoach.click();
		  //emailcoach.sendKeys(Keys.TAB);
		  Thread.sleep(1000);

		  //emailcoach.sendKeys(Keys.TAB);
		  
		  //firstname.sendKeys(Keys.TAB);
		  //Thread.sleep(1000);

		 driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//input[1]")).click(); 
		  driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Senon");
		  
		  //WebElement lastname= driver.switchTo().activeElement();
		  //driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/input[1]" )).sendKeys("Kirti");
		  //lastname.sendKeys("Senon");
		  Thread.sleep(1000);
		  
		  

	  // Keep this email existed user for next next test case
	  //WebElement emailcoach =driver.findElement(By.cssSelector("input[placeholder='Add Coach...']"));
	  //emailcoach.clear();
	  //emailcoach.sendKeys("kirtisenon@yopmail.com"); 
	  
	    

	  // click invite button 
	  driver.findElement(By.xpath("//div[@class='css-175oi2r r-1loqt21 r-1otgn73 r-1awozwy r-1xfd6ze r-rs99b7 r-1ugchlj r-1777fci r-cxgwc0']")).click(); 
	  // ITs not input box : driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Invite']")).sendKeys("Yash");
	  
	  Thread.sleep(2000);
	  
	  //System.out.println("Athlete User Invited: " + element.getText());
	  
	  
	  Reporter.log("All Coach Information Filled Success", true);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed WebElement toast5 = wait.until(
	  ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='toastText1']") ) ;
	  
	  WebElement toast5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Creation Fail']")));

	  
	String actualMessageSS = toast5.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessageSS);
	  Reporter.log("\"Toast Message: \"" + actualMessageSS, true);
	  
	  
	  Assert.assertEquals(actualMessageSS,"Already Invited");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  }
	  
	  
	  
	  
	  @Test(description="TC 011: Verify admin can fill coach information",priority=18) 
	  public void invpopupcchbyadminfillinfo() throws InterruptedException 
	  
	  { 
		  Thread.sleep(2000); 
		// click on add coach button 	
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 

		  // #Step 2: Fill All Info in popup 
		  WebElement emailcoach =driver.findElement(By.cssSelector("input[placeholder='Add Coach...']"));
		  emailcoach.clear();
		  emailcoach.sendKeys(email1); 
	
		  emailcoach.sendKeys(Keys.TAB);
		  WebElement firstname= driver.switchTo().activeElement();
		  //driver.findElement(By.xpath("//body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]" )).sendKeys("Kirti");
		  firstname.sendKeys("Kirti");
		  
		  Thread.sleep(1000);

			  //Thread.sleep(1000);

		 driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//input[1]")).click(); 
		  driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Senon");
		  
		   Thread.sleep(1000);    

	  // click invite button 
	  //driver.findElement(By.xpath("//div[@class='css-175oi2r r-1loqt21 r-1otgn73 r-1awozwy r-1xfd6ze r-rs99b7 r-1ugchlj r-1777fci r-cxgwc0']")).click(); 
	  
	
	  Thread.sleep(2000);
	  
	  
	  }
	  
		  
		  
		  @Test(description="TC 012: Verify admin can Successflly invited coach",priority=19) 
	 public void coachinvbyadmin() throws InterruptedException {
		  
		  //Already added email input in the recent method
		 // update non exist email before every run and also update at contains find element 
		  //driver.findElement(By.xpath("//input[@type='email']")).click();
		  //driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kirtisenon@yopmail.com");
		  
		  
		  // click invite button 
		  driver.findElement(By.xpath("//div[@class='css-175oi2r r-1loqt21 r-1otgn73 r-1awozwy r-1xfd6ze r-rs99b7 r-1ugchlj r-1777fci r-cxgwc0']")).click(); 
		 
	  Thread.sleep(4000);
	    
	  WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + email1 + "')]"));
	  
	  System.out.println("Coach User Invited: " + element.getText());
	  
	  	  Reporter.log("All Coach Information Filled Success", true);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed 
	  WebElement toast7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='toastText1']") )) ;
	 
	  //WebElement toast7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Missing Fields']")));
	  
	  String actualMessagee = toast7.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessagee);
	  Reporter.log("\"Toast Message: \"" + actualMessagee, true);
	  
	  
	  Assert.assertEquals(actualMessagee, "Invited Successfully","Toast message mismatch!");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  }
	  
	  
	  
	  
	  
	  @Test(description="TC 013: Verify admin cannot resent Connection request within 24 Hr", priority=20) 
	  public void resentwithin24hrs()
	  
	  {
	  driver.navigate().refresh();
	  driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[5]//div[1]//div[2]//div[1]")).click();
	  	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement toast8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-146c3p1 r-zl2h9q r-13qz1uu']") ) );
	  
	  
	  String actualMessagee = toast8.getText().trim();

		
		  System.out.println("Toast Message: " + actualMessagee); Reporter.log("\"Toast Message: \"" + actualMessagee, true);
		  
		  
		  Assert.assertEquals(actualMessagee, "Cooldown: You can only resend once every 24 hours.", "Toast message mismatched!");
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
		  
		  
		  
		 
	  
	  @Test(description="TC 015: Verify the status of new added coach",priority=21)
	  
	  public void newchhstatus() throws InterruptedException 
	  {
		  driver.navigate().refresh();
		  Thread.sleep(2000);

	  driver.findElement(By.xpath("//input[@placeholder='Search coaches...']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Search coaches...']")).sendKeys(email1);
	  
	  WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Thread.sleep(3000);

	  WebElement sentText = wait13.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]")) );
	  
	  System.out.println("Newly added coache Status found: " +sentText.getText());
	  Thread.sleep(3000);

	  //driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[5]//div[1]//div[2]//div[1]")).click(); }
	  
	 }
	
		  
		  
		  @Test(description="TC 014: Verify admin can delete coach", priority=22)
		  
		  public void deletecoach() { 
			  driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]")).click(); 
			  driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Delete']")).click(); 

		  
		  }
		  
		 
		
	@Test(description = "TC 014: Verify Pagination working on coach listing", priority = 10)

	public void coachpagination() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='css-175oi2r r-1mlwlqe r-1udh08x r-417010 r-z80fyv r-19wmn03']//img[@class='css-9pa8cd']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0 r-16pcm1t r-d23pfw']/div[@class='css-175oi2r r-n1h2e2 r-75jtiq r-1fuqb1j r-rs99b7 r-8egel2 r-6koalj r-13awgt0 r-eqz5dr r-1udh08x']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-1awozwy r-mcbqjf r-5kkj8d r-18u37iz r-1w6e6rj r-f4gmv6 r-1wtj0ep r-1l7z4oj r-cxgwc0 r-95jzfe']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-1w6e6rj r-f4gmv6 r-uejdgs']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-uaa2di r-uejdgs']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-bnwqim']/div[@class='css-175oi2r r-13qz1uu']/div[@class='css-175oi2r r-1xfd6ze r-rs99b7 r-1udh08x r-u8s1d r-13qz1uu']/div[@class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx']/div[@class='css-175oi2r']/div[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-tuq35u']//div[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0 r-16pcm1t r-d23pfw']/div[@class='css-175oi2r r-n1h2e2 r-75jtiq r-1fuqb1j r-rs99b7 r-8egel2 r-6koalj r-13awgt0 r-eqz5dr r-1udh08x']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-1awozwy r-mcbqjf r-5kkj8d r-18u37iz r-1w6e6rj r-f4gmv6 r-1wtj0ep r-1l7z4oj r-cxgwc0 r-95jzfe']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-1cmwbt1']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-9aw3ui']/div[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
		


	}
/*
	@Test(description = "TC 014: Verify that admin can see coach's full profile view page", priority = 10)

	public void coachprofileview() 
	{
		driver.findElement(By.xpath("//input[@placeholder='Search coaches...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search coaches...']")).sendKeys("yashbyadmin@yopmail.com");

		// driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[5]//div[1]//div[2]//div[1]")).click();
		driver.findElement(By.xpath("//div[@class='css-146c3p1']")).click();

		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		  WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='css-175oi2r r-1awozwy r-18u37iz r-1ssbvtb r-1peese0']//div[2]")));
		  
		  System.out.println("" + "Admin Navigated to coach profile view: " +userName.getText());
		 
	}
	
	*/
	
	
	
}
