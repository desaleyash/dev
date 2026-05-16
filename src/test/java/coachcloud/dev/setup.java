package coachcloud.dev;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class setup {
	public static WebDriver driver;

	@BeforeSuite
	public void openlogin() {

		System.out.println("Setup method Success");
		driver = new ChromeDriver();

		driver.get("https://staging.coachsuite.nl/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(9000);// wait for 5 secs before
		driver.close();
		driver.quit();
	}

}
