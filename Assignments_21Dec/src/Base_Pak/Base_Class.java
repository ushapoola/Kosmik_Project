package Base_Pak;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base_Class{
	public static WebDriver driver;
	public static  Actions a;
	public static  Alert alert1;
  @BeforeMethod
  public void Browser1() {
	  
	  System.setProperty("Webdriver.chrome.driver","C:\\\\Users\\\\admin\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
	  driver=new ChromeDriver();
		
	  driver.manage().window().maximize();
	  driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/index.php");
	  
  }
  @Test
  public void Login_valid() throws InterruptedException, IOException { 
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Kosmik123");
		  driver.findElement(By.xpath("//input[@name='username']//following::input[1]")).sendKeys("kosmik");
		  
		  driver.findElement(By.xpath("//input[@name='username']//following::input[2]")).click();
		  Thread.sleep(2000);
		  
			 alert1=driver.switchTo().alert();
			 alert1.getText();
			 alert1.accept();
			 Thread.sleep(2000);
			 
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kosmik");
		  driver.findElement(By.xpath("//input[@name='username']//following::input[1]")).sendKeys("kosmik");
		
		  driver.findElement(By.xpath("//input[@name='username']//following::input[2]")).click();
		  Thread.sleep(2000);
		  
		  Screens("After_Login_valid_Management_Page");
		
		  
		  Screens("After_Login_invalid_Management_Page");
	  String Title=driver.getTitle();
	  if(Title.equals("Master Page")) {
		  System.out.println("The Valid Title is: "+ Title);
	  }

	  else {
		  System.out.println("The Invalid Title:  "+Title);
		  
	  }
	  
  }
  @AfterMethod
  public void Registration() throws InterruptedException, AWTException, IOException {
	  
	  a= new Actions(driver);
	  a.moveToElement(driver.findElement(By.xpath("//a[text()='Registration']"))).click().perform();
  
     WebElement Categi=driver.findElement(By.xpath("//select[@name='PATIENT_CAT']"));
  // List<WebElement> dd=driver .findElements(By.tagName("option"));
   Select s=new Select(Categi);
   s.selectByIndex(2);
   
   WebElement Titl=driver.findElement(By.xpath("//select[@name='TITLE']"));
   Select s1=new Select(Titl);
   s1.selectByIndex(1);
   
   driver.findElement(By.xpath("//input[@name='PNT_NAME']")).sendKeys("Hanuman");
 driver.findElement(By.xpath("//input[@name='LAST_NAME']")).sendKeys("Poola");
 driver.findElement(By.xpath("//input[@name='DOB']")).sendKeys("12/13/2024");
 driver.findElement(By.xpath("//input[@name='AGE']")).sendKeys("21");
 
 WebElement Gender=driver.findElement(By.xpath("//select[@name='SEX']"));
 Select s3=new Select(Gender);
 s3.selectByIndex(2);
   
 WebElement Status=driver.findElement(By.xpath("//select[@name='MTRL_STATUS']"));
 Select s4=new Select(Status);
 s4.selectByIndex(2);

 driver.findElement(By.xpath("//input[@name='PAT_IDENTITY_PROOF']")).sendKeys("AX99883M");
 Base_Class b=new Base_Class();
 b.dd("NATIONALITY");
 b.dd("PAT_IDENTITY");
 b.dd("RELATION");
 b.dd("PLANGUAGE");
 b.dd("RELIGION");
 b.dd("IS_MLC");
 b.dd("EDUCATION");
 b.dd("OCCUPATION");
 b.dd("BLOOD_GRP_CODE");
 driver.findElement(By.xpath("//input[@name='EMAIL_ID']")).sendKeys("Hanuman@gmail.com");
 b.dd("CITIZENSHIP");
 b.dd("SC_PROOF");
 driver.findElement(By.xpath("//input[@name='ADDRESS1']")).sendKeys("Hydrebad");
 b.dd("COUNTRY_CODE");
 driver.findElement(By.xpath("//input[@name='MOBILE_NO']")).sendKeys("9100089278");
 driver.findElement(By.xpath("//input[@name='ZIP']")).sendKeys("500085");
 Thread.sleep(2000);
 a.moveToElement(driver.findElement(By.xpath("//input[@name='image']"))).click().perform();
 StringSelection ro=new StringSelection("C:\\Users\\admin\\Pictures\\Bajarangabali.jpeg");
 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ro, null);
 Thread.sleep(2000);
 Robot R=new Robot();

 R.keyPress(KeyEvent.VK_CONTROL);
 R.keyPress(KeyEvent.VK_V);
 
 R.keyRelease(KeyEvent.VK_CONTROL);
 R.keyRelease(KeyEvent.VK_V);
 
 R.keyPress(KeyEvent.VK_ENTER);
 R.keyRelease(KeyEvent.VK_ENTER);
 Thread.sleep(2000);
 Screens("AfterAddingOnePatient");
 
 driver.findElement(By.xpath("//input[@name='submit']")).click();
 Thread.sleep(2000);
 alert1.accept();
 
// Thread.sleep(2000);/html/body/div[2]/div/div[2]/table[2]/tbody/tr/td[10]/a[1]
// a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/div"))).click().perform();
 Thread.sleep(2000);
a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/ul/li[4]/a"))).click().perform();
System.out.println("hai");
a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/table[2]/tbody/tr/td[10]/a[1]"))).click().perform();
  Thread.sleep(2000);
  WebElement D1=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/table/tbody/tr[1]/td[2]/select"));
  Select D=new Select(D1);
  D.selectByIndex(2);
  Thread.sleep(2000);
  WebElement T=driver.findElement(By.xpath("//select[@name='TITLE']"));
  Select T1=new Select(T);
  T1.selectByIndex(1);
  
  
  WebElement G=driver.findElement(By.xpath("//select[@name='SEX']"));
  Select G1=new Select(G);
  G1.selectByIndex(2);
    
  WebElement Ss=driver.findElement(By.xpath("//select[@name='MTRL_STATUS']"));
  Select ss=new Select(Ss);
  ss.selectByIndex(2);
  
  b.dd("NATIONALITY");
  b.dd("PAT_IDENTITY");
  b.dd("RELATION");
  b.dd("PLANGUAGE");
  b.dd("RELIGION");
  b.dd("IS_MLC");
  b.dd("EDUCATION");
  b.dd("OCCUPATION");
  b.dd("BLOOD_GRP_CODE");
  b.dd("CITIZENSHIP");
  b.dd("SC_PROOF");
  
  b.dd("COUNTRY_CODE");
  
  driver.findElement(By.xpath("//input[@name='ADDRESS2']")).sendKeys("Hyderabad");
  Thread.sleep(2000);
  a.moveToElement(driver.findElement(By.xpath("//input[@name='file']"))).click().perform();
  StringSelection Rob=new StringSelection("‪C:\\Users\\admin\\Pictures\\Bajarangabali.jpeg");
  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ro, null);
  Thread.sleep(2000);
  Robot R1=new Robot();

  R1.keyPress(KeyEvent.VK_CONTROL);
  R1.keyPress(KeyEvent.VK_V);
  
  R1.keyRelease(KeyEvent.VK_CONTROL);
  R1.keyRelease(KeyEvent.VK_V);
  
  R1.keyPress(KeyEvent.VK_ENTER);
  R1.keyRelease(KeyEvent.VK_ENTER);
  Thread.sleep(2000);
  driver.findElement(By.xpath("//input[@name='submit']")).click();
  Thread.sleep(2000);
  alert1.accept();
  
  Thread.sleep(2000);
  a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/ul/li[4]/a"))).click().perform();
  System.out.println("hai");
//  a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/table[2]/tbody/tr/td[10]/a[1]"))).click().perform();
//    Thread.sleep(2000);
  a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/table[3]/tbody/tr/td[10]/a[2]"))).click().perform();
  Thread.sleep(2000);
  alert1.accept();
  }
  
  
//  public void Edit() throws InterruptedException {
//	  
//	 }
  void dd(String x) {
 WebElement VIP=driver.findElement(By.xpath("//select[@name='"+x+"']"));
 Select s10=new Select(VIP);
 s10.selectByIndex(1);
   }
 public  void Screens(String s) throws IOException {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File trg=new File("C:\\Users\\admin\\Desktop\\screenshot\\"+s+".jpg");
	  FileHandler.copy(src,trg);
	  }
 
 
 
 
}
