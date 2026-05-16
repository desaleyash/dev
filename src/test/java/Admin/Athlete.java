package Admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import coachcloud.dev.setup;

public class Athlete extends setup {

	public String email = testutils.generateEmail();

	@Test(description = "TC 008: Verify user listing displaying on athlete module", priority = 0)

	public void athletepgsuccess() {

		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1fuqb1j r-rs99b7 r-1b7e0jd r-1udh08x r-nsbfu8 r-bnwqim r-13qz1uu'] div[class='css-146c3p1 r-3d0o80 r-10x49cs r-vw2c0b r-ud0q2t r-tsynxw']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Reporter.log("Admin is on Athletes Module", true);

		// 1. Use a more stable locator than the long CSS string
		WebElement adminText = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1ui5ee8 r-vw2c0b r-icto9i']"));

		// 2. Print the actual text (better for debugging than the object reference)
		System.out.println("Text Found: " + adminText.getText());

		// 3. Combined Assertion: Check visibility and content in one go
		Assert.assertTrue(adminText.getText().equals("Athletes"),"Athlete text was either not displayed or the text content did not match.");

	}

	
	  
	  @Test(description="TC 009: Verify total user count showing", priority=1)
	  
	  public void totalcount() 
	  { 
	driver.findElement(By.xpath("//div[@class='css-146c3p1 r-br8i5a r-1b43r93 r-1kfrs79']")).click();
	  
	  WebElement totalAthletes=driver.findElement(By.xpath("//*[contains(text(),'Total Athletes:')]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	  
	  System.out.println(totalAthletes.getText()); 
	  
	  }
	 
	  
	  
	  
	  
	  
	  @Test(description="TC 010: Verify search athlete", priority=2)
	  
	  public void searchath() throws InterruptedException 
	  
	  {
	  
		  
	driver.findElement(By.cssSelector("input[placeholder='Search athletes...']")).click();
	  driver.findElement(By.cssSelector("input[placeholder='Search athletes...']")).sendKeys("Yash"); 
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  String athemail = "yashathlete@yopmail.com";
	  
	  try { WebElement user = driver.findElement( By.xpath("//*[contains(text(),'"+ athemail + "')]") );
	  
	  if(user.isDisplayed()) { System.out.println("User found: " + athemail); }
	  
	  } catch (Exception e) { System.out.println("User NOT found: " + athemail); }
	  Thread.sleep(2000); 
	  WebElement searchBox =driver.findElement(By.cssSelector("input[placeholder='Search athletes...']"));
	  
	  searchBox.clear(); 
	  Thread.sleep(4000);
	  
	  }
	  
	  
	  
	  
	  
	  @Test(description="TC 011: Verify athlete popup opens", priority=3) 
	  public void invpopupathbyadmin() throws InterruptedException
	  
	  { 
		  // #Step 1: Invite popup open confirmation code 
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 
		  // 1.Use a more stable locator than the long CSS string 
		  WebElement popupText =driver.findElement(By. xpath("//div[normalize-space()='Send an invitation to a new athlete']"));
	  
	  // 2. Print the actual text (better for debugging than the object reference)
	  System.out.println("Text Found: " + popupText.getText());
	  
	  // 3. Combined Assertion: Check visibility and content in one go
	  Assert.assertTrue(popupText.getText().equals("Send an invitation to a new athlete"), "Popup doesn't open.");
	  
	  Reporter.log("Athlete invite popup is opened", true); 
	  Thread.sleep(3000); 
	  
	  }
	  
	  
	  
	  
	  
	  @Test(description="TC 011: Verify admin cannot invite athlete without mandatory information", priority=4) 
	  public void blankmandatefield() throws InterruptedException 
	  {
	  // only transponder value
	  driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).sendKeys("123456"); 
	  // click invite button 
	  driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Invite']")).click();
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed 
	  WebElement toast6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Missing Fields']")));
	  
	  
	  String actualMessageS = toast6.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessageS);
	  Reporter.log("\"Toast Message: \"" + actualMessageS, true);
	  
	  
	  Assert.assertEquals(actualMessageS, "Missing Fields","Toast message mismatch!"); 
	  Reporter.log("Admin is not able to invite athlete without mandatory feilds Name, Email", true); 
	  Thread.sleep(2000);
	  
	  
	  
	  }
	  
	  
	  
	  
	  @Test(description="TC 012: Verify admin cannot invite an existing athlete", priority=5) 
	  public void existathinvbyadmin() throws InterruptedException 
	  {
	  
		  System.out.println("existathinvbyadmin() method entered");
		  driver.navigate().refresh();
		  //click add athlete button
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 
		  
		  // #Step 2: Fill All Info in popup 
	driver.findElement(By.xpath("//body//div//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[1]//div[1]//div[2]//input[1]")).click(); 
	driver.findElement(By.xpath("//body//div//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[1]//div[1]//div[2]//input[1]" )).sendKeys("Yash");
	  
	  Thread.sleep(1000);

	  driver.findElement(By.xpath("//div[@class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx r-hnu01a r-ku1wi2 r-bnwqim r-gbqte3 r-2eszeu']//div[2]//div[1]//div[1]//div[2]//input[1]")).click(); 
	  driver.findElement(By.xpath("//div[@class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx r-hnu01a r-ku1wi2 r-bnwqim r-gbqte3 r-2eszeu']//div[2]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Athlete");
	  Thread.sleep(1000);

	  // Keep this email existed user for next next test case
	  driver.findElement(By.xpath("//input[@type='email']")).click();
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys( "yashathlete@yopmail.com"); 
	  
	  
	  
	  //Thread.sleep(1000);

	  // click invite button 
	  driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1)")).click(); 
	  // ITs not input box : driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Invite']")).sendKeys("Yash");
	  
	  Thread.sleep(3000);
	  
	  //System.out.println("Athlete User Invited: " + element.getText());
	  
	  
	  Reporter.log("All Athlete Information Filled Success to check existathinvbyadmin", true);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed WebElement toast5 = wait.until(
	  ExpectedConditions.visibilityOfElementLocated(
	  By.cssSelector("[data-testid='toastText2']") ) ;
	  
	  WebElement toast5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='A user with this email already exists and cannot be invited.']")));

	  
	String actualMessageSS = toast5.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessageSS);
	  Reporter.log("\"Toast Message: \"" + actualMessageSS, true);
	  
	  
	  Assert.assertEquals(actualMessageSS,"A user with this email already exists and cannot be invited.","Toast message mismatch!");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  }
	  
	  
	  
	  
	  @Test(description="TC 011: Verify admin can fill athlete information",priority=6) 
	  public void invpopupathbyadminfillinfo() throws InterruptedException 
	  
	  { 
		  System.out.println("invpopupathbyadminfillinfo() method entered");

		  driver.navigate().refresh();

		  Thread.sleep(3000); 
		  //Invite athlete button
		  driver.findElement(By.cssSelector("div[class='css-146c3p1 r-1b43r93 r-vw2c0b']")).click(); 
	  // #Step 2: Fill All Info in popup 
	  driver.findElement(By.xpath("//body//div//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[1]//div[1]//div[2]//input[1]")).click(); 
	  driver.findElement(By.xpath("//body//div//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[1]//div[1]//div[2]//input[1]")).sendKeys("Yash");
	  
	  
	  driver.findElement(By.xpath("//div[@class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx r-hnu01a r-ku1wi2 r-bnwqim r-gbqte3 r-2eszeu']//div[2]//div[1]//div[1]//div[2]//input[1]")).click(); 
	  driver.findElement(By.xpath("//div[@class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx r-hnu01a r-ku1wi2 r-bnwqim r-gbqte3 r-2eszeu']//div[2]//div[1]//div[1]//div[2]//input[1]")).sendKeys("AutoTest");
	  
	  // Keep this email existed user for next next test case
	  driver.findElement(By.xpath("//input[@type='email']")).click();
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	  
	  driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Sensor ID 1']")).sendKeys(
	  "123456"); Thread.sleep(2000);
	  
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
		
		  
		  
		  @Test(description="TC 012: Verify admin can Successflly invited athlete",priority=7) 
	 public void athinvbyadmin() throws InterruptedException 
		  {
			  System.out.println("athinvbyadmin() method entered");

		  // update non exist email before every run and also update at contains find element 
		  //driver.findElement(By.xpath("//input[@type='email']")).click();
		  //driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kirtisenon@yopmail.com");
		  
		  
		  // click invite button 
		  driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Invite']")).click(); 
		  //It seems un necesseory code written : driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Invite']")).sendKeys("Yash");
		 
	  Thread.sleep(3000);
	  
	  
	  WebElement element = driver.findElement(By.xpath(("//*[contains(text(),'" + email + "')]")));
	  
	  System.out.println("Athlete User Invited: " + element.getText());
	  
	  
	  Reporter.log("All Athlete Information Filled Success", true);
	  
	  WebDriverWait wait002 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  
	  // Verify SuccessToast displayed 
	  WebElement toast7 = wait002.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='toastText1']") )) ;
	 
	  //WebElement toast7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Missing Fields']")));
	  
	  String actualMessagee = toast7.getText().trim();
	  
	  System.out.println("Toast Message: " + actualMessagee);
	  Reporter.log("\"Toast Message: \"" + actualMessagee, true);
	  
	  
	  Assert.assertEquals(actualMessagee, "Invitation sent to athlete.","Toast message mismatch!");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  }
	  
	  	  
	  
	  @Test(description="TC 013: Verify admin cannot resent Connection request within 24 Hr", priority=8) 
	  public void resentwithin24h() throws InterruptedException
	  
	  {
	  driver.navigate().refresh();
	  
	  Thread.sleep(4000);

	  driver.findElement(By.cssSelector("div[class='css-175oi2r r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-agouwx r-2eszeu'] div[class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73'] div:nth-child(1)")).click();
	  	  
	  WebDriverWait wait003 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement toast8 = wait003.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-146c3p1 r-zl2h9q r-13qz1uu']") ) );
	  
	  
	  String actualMessagee = toast8.getText().trim();

		
		  System.out.println("Toast Message: " + actualMessagee); Reporter.log("\"Toast Message: \"" + actualMessagee, true);
		  
		  
		  Assert.assertEquals(actualMessagee, "Cooldown: You can only resend once every 24 hours.", "Toast message mismatch!");
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	 }
		  
		  
		  
		 
	  
	  @Test(description="TC 015: Verify the status of new added athlete",priority=9)
	  
	  public void newathstatus() throws InterruptedException 
	  {
		  driver.navigate().refresh();
		  Thread.sleep(2000);

	  driver.findElement(By.xpath("//input[@placeholder='Search athletes...']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Search athletes...']")).sendKeys(email);
	  
	  WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Thread.sleep(2000);

	  WebElement sentText = wait12.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]")) );
	  
	  System.out.println("Newly added athletes Status found: " +sentText.getText());
	  Thread.sleep(3000);

	  //driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[5]//div[1]//div[2]//div[1]")).click(); }
	  
	 }
	
		  
		  
		  @Test(description="TC 014: Verify admin can delete athlete", priority=9)
		  
		  public void deleteath() { 
			  driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]")).click(); 
			  driver.findElement(By.xpath("//div[@class='css-146c3p1 r-1m72y5m r-ubezar r-1kfrs79 r-135wba7'][normalize-space()='Delete']")).click(); 

		  
		  }
		  
		 
		
	@Test(description = "TC 014: Verify Pagination working on athlete listing", priority = 10)

	public void athpagination() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("div[class='css-175oi2r r-1mlwlqe r-1udh08x r-417010 r-z80fyv r-19wmn03'] img[class='css-9pa8cd']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(text(),'25')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0 r-1p0dtai r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0 r-16pcm1t r-d23pfw']/div[@class='css-175oi2r r-n1h2e2 r-75jtiq r-1fuqb1j r-rs99b7 r-8egel2 r-6koalj r-13awgt0 r-eqz5dr r-1udh08x']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-1awozwy r-mcbqjf r-5kkj8d r-18u37iz r-1w6e6rj r-f4gmv6 r-1wtj0ep r-1l7z4oj r-cxgwc0 r-95jzfe']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-1cmwbt1']/div[@class='css-175oi2r r-1awozwy r-18u37iz r-9aw3ui']/div[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-tuq35u']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();

	}

	@Test(description = "TC 014: Verify that admin can see athletes full profile view page", priority = 11)

	public void athprofileview() {
		driver.findElement(By.xpath("//input[@placeholder='Search athletes...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search athletes...']")).sendKeys("yashathlete@yopmail.com");

		// driver.findElement(By.xpath("//body//div[@id='root']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[@class='css-175oi2r']//div[1]//div[5]//div[1]//div[2]//div[1]")).click();
		driver.findElement(By.xpath("//div[@class='css-146c3p1']")).click();

		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		  WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='css-175oi2r r-1awozwy r-18u37iz r-1ssbvtb r-1peese0']//div[2]")));
		  
		  System.out.println("" + "Admin Navigated to athletes profile view: " +userName.getText());
		  
		  
	}

}
