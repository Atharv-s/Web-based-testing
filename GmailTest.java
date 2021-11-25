package seleniumgmail;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailTest{
	static String driverPath = "C:\\Program Files\\eclipse\\chrome driver for selenium project\\";
	public static WebDriver driver;
	
	
	
	
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {												//close browser
			driver.close();
	}
	
	@Test
	public static void openwebsite() throws Exception {   				 
		
		driver.get("https://www.geeksforgeeks.org/");
		String expectedUrl = "https://www.geeksforgeeks.org/";
	    String originalUrl = driver.getCurrentUrl();						//website test
	    System.out.println(originalUrl);
	    Assert.assertEquals(originalUrl, expectedUrl);
	    String expectedTitle = "GeeksforGeeks | A computer science portal for geeks";
	    String originalTitle = driver.getTitle();
	    System.out.println(originalTitle);
	    Assert.assertEquals(originalTitle, expectedTitle);
	    
	}									
	
	 
	@Test
	public static void tests() throws Exception {
		
		driver.get("https://auth.geeksforgeeks.org/");						// LOGIN TEST
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.id("luser"));
		StringBuffer username = new StringBuffer().append("atharvsalunke01@gmail.com"); 
		email.sendKeys(username);
		
		Thread.sleep(2000);
		WebElement pass = driver.findElement(By.id("password"));
		StringBuffer password = new StringBuffer().append("geeksforgeeks"); 
		pass.sendKeys(password);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		Thread.sleep(2000);

		
	    WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		
		Thread.sleep(2000);
		
		//updated username comes here
		
		Thread.sleep(2000);
		
		driver.get("https://auth.geeksforgeeks.org/edit-profile.php");
		
		/*	Actions act = new Actions(driver);
		WebElement choosefile = driver.findElement(By.xpath("//button[contains(@class,'changeImgIcon mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab')]"));
		act.moveToElement(choosefile).perform();
		Thread.sleep(1000);
		choosefile.sendKeys("C:\\Users\\atharv salunke\\Desktop\\img.jpg");*/
		
		
		driver.findElement(By.xpath("//button[contains(@class,'changeImgIcon mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab')]")).sendKeys("img.jpg");
		driver.findElement(By.xpath("//button[contains(@class,'changeImgIcon mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab')]")).getAttribute("value");
		Thread.sleep(3000);
		
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("1234567890");
        Thread.sleep(2000);
		
		WebElement github= driver.findElement(By.xpath("//input[@id='social-profile']"));			//UPDATE PROFILE TEST
        github.sendKeys("http//www.github.com/atharvsalunke");
        
        driver.findElement(By.id("inputLang")).sendKeys("English");
        Select sel1 = new Select(driver.findElement(By.name("language")));
        sel1.selectByIndex(2);
       
        driver.findElement(By.id("user_coding_profile")).sendKeys("https://www.hackerrank.com/atharvsalunke01");
        Thread.sleep(2000);
        
        driver.findElement(By.id("inputSkill")).sendKeys("data structures, OOP, DBMS");
        Thread.sleep(2000);
        
        driver.findElement(By.id("otherSkillInput")).sendKeys("Communication");
        Thread.sleep(2000);
        
        Actions act = new Actions(driver);
		WebElement choosefile = driver.findElement(By.xpath("//button[contains(@style,'background-color: #0f9d58;')]"));
		act.moveToElement(choosefile).perform();
		Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[@id='resume']")).sendKeys("C:\\Users\\atharv salunke\\resume.pdf");
        driver.findElement(By.xpath("//input[@id='resume']")).getAttribute("value");
        Thread.sleep(3000);
        

         WebElement nextbnt=driver.findElement(By.xpath("//button[contains(@style,'background-color: #0f9d58;')]"));			//pressing next button and navigate to next page
         JavascriptExecutor executor = (JavascriptExecutor) driver;
         executor.executeScript("arguments[0].click();", nextbnt);
         
         Thread.sleep(2000);
        
         driver.findElement(By.id("institution")).clear();
         driver.findElement(By.id("institution")).sendKeys("Pimpri Chinchwad Education Trust PCET'S PCCOER");
         Select edu = new Select(driver.findElement(By.name("hq_details")));
         edu.selectByIndex(9);
         driver.findElement(By.xpath("//input[@id='percentage_cgpa']")).clear();
         driver.findElement(By.xpath("//input[@id='percentage_cgpa']")).sendKeys("9.23");				//adding CGPA to profile 
         Thread.sleep(1000);
         driver.findElement(By.xpath("//input[@id='cgpa_scale']")).clear();
         driver.findElement(By.xpath("//input[@id='cgpa_scale']")).sendKeys("10");
         Thread.sleep(1000);
         
         
         driver.findElement(By.id("nextBtn")).click();
         
         Thread.sleep(2000);
         
         driver.findElement(By.id("expected_salary")).clear();
         driver.findElement(By.id("designation")).clear();
         driver.findElement(By.id("company_name")).clear();
         driver.findElement(By.id("duration")).clear();
         
         
         driver.findElement(By.id("company_name")).sendKeys("XYZ");
         Thread.sleep(1000);
         driver.findElement(By.id("designation")).sendKeys("Developer");
         Thread.sleep(1000);
         driver.findElement(By.id("expected_salary")).sendKeys("50");
         Thread.sleep(1000);
         driver.findElement(By.id("duration")).sendKeys("5");
         WebElement radio =   driver.findElement(By.xpath("//span[@class='mdl-radio__outer-circle']"));
         radio.click();
         driver.findElement(By.id("nextBtn")).click();													//submit details
         Thread.sleep(3000);         
         
         																								
         driver.findElement(By.xpath("//img[@class='demo-avatar whiteBgColor']")).click();				//SIGN OUT OF ACCOUNT
         driver.findElement(By.xpath("//a[@href='https://auth.geeksforgeeks.org/logout.php/?to=https://auth.geeksforgeeks.org/user/atharvsalunke01pccoer']")).click();
         
         Thread.sleep(3000);
         
         
         
         
	}
	
	
		
		
	

	
	
	
}
	

/*public static void openwebsite() {   				 //starts here
	
	driver.get("https://www.geeksforgeeks.org/");
	String expectedUrl = "https://www.geeksforgeeks.org/";
    String originalUrl = driver.getCurrentUrl();
    System.out.println(originalUrl);
    Assert.assertEquals(originalUrl, expectedUrl);
    String expectedTitle = "GeeksforGeeks | A computer science portal for geeks";
    String originalTitle = driver.getTitle();
    System.out.println(originalTitle);
    Assert.assertEquals(originalTitle, expectedTitle);
    
	/*WebElement email = driver.findElement(By.id("email"));					//	starts here
	StringBuffer username = new StringBuffer().append("atharv@gmail.com"); 
	email.sendKeys(username);
	
	WebElement pass = driver.findElement(By.id("pass"));
	StringBuffer password = new StringBuffer().append("1234567890"); 
	pass.sendKeys(password);
	driver.findElement(By.linkText("Log In")).click();
	
	driver.findElement(By.linkText("Forgotten account?")).click();*/			//	ends here
    
//}													//	ends here


/*	driver.get("https://auth.geeksforgeeks.org/account-settings.php");							
driver.findElement(By.id("username")).sendKeys("pccoer");
driver.findElement(By.xpath("//button[contains(@class,'mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent')]")).click();*/



