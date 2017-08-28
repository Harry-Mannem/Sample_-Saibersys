package Assignment;





	/*Go to http://softwaretesting-guru.blogspot.in/p/main-page.html
	select the "Selenium Practice page" window
	Give "name" as "Hari"
	Give "Comment" as "I am in India "
	From dropDown "countries" Select the name with "Afganistain"
	From "computerbrands" select the name with "Compaq"
	Give "Password" as "!@#"
	Radio buttons Bad
	Choose one image from local drive and attach it to the "Photo"
	Click the ALert Box and control it 
	Click the confirm  Box and handle it by clicking on "OK"
	click on  "New window" and again come back to "the same page"
	pick a date --// Have any issue// 
	 
	*/

	
		import java.awt.AWTException;
		import java.awt.Robot;
		import java.awt.Toolkit;
		import java.awt.datatransfer.StringSelection;
		import java.awt.event.KeyEvent;
		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.Alert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.Select;

		public class Sample {
			public static void main(String[] args) throws InterruptedException, AWTException {
				WebDriver driver=new ChromeDriver();
				System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				//driver.manage().window().maximize();
				driver.get("http://softwaretesting-guru.blogspot.in/p/main-page.html");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Selenium Practice page")).click();
				driver.findElement(By.name("Name")).sendKeys("hari");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/form/table/tbody/tr[2]/td/input")).click();
				driver.findElement(By.name("comments")).sendKeys("I am in India");
				
				
				Select oselect = new Select(driver.findElement(By.name("countries")));
				oselect.selectByVisibleText("Afganistain");
				
				Select iselect = new Select(driver.findElement(By.name("computerbrands")));
				iselect.deselectAll();
				iselect.selectByVisibleText("Compaq");
				driver.findElement(By.name("pwd")).sendKeys("!@#");
				
				
				driver.findElement(By.xpath("//input[@value='bad']")).click();
				//driver.findElement(By.name("Radio buttons")).click();	
				
				
				// Give any image path from our local drive to StringSelection then the below Action class  will work's...
				
				
				/*driver.findElement(By.name("photo")).click();
				StringSelection ss = new StringSelection("D:\\Wallpaper-19-1024x640");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				Robot obj2 = new Robot();
				System.out.println(obj2);
				obj2.keyPress(KeyEvent.VK_ENTER);
				obj2.keyRelease(KeyEvent.VK_ENTER);
				obj2.keyPress(KeyEvent.VK_CONTROL);
				obj2.keyPress(KeyEvent.VK_V);
				obj2.keyRelease(KeyEvent.VK_V);
				obj2.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(8000);
				obj2.keyPress(KeyEvent.VK_ENTER);
				obj2.keyPress(KeyEvent.VK_ENTER);*/
				
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/form/table/tbody/tr[9]/td/input")).click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				Alert alert = driver.switchTo().alert();
				System.out.println(alert);
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				alert.accept();
				
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/form/table/tbody/tr[10]/td/input")).click();
				Alert alert1 = driver.switchTo().alert();
				System.out.println(alert1);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				alert.accept();
				
				
				driver.findElement(By.linkText("Link in new page")).click();
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Home")).click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Selenium Practice page")).click();
				System.out.println(driver.getCurrentUrl());
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/form/table/tbody/tr[12]/td/a")).click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				String ParentWindow =driver.getWindowHandle();
				System.out.println("ParentWindow is= " + ParentWindow);
				for(String childwindow:driver.getWindowHandles())
				  {
				   System.out.println("childwindow:::" + childwindow);
				   driver.switchTo().window(childwindow);
				  }
				driver.findElement(By.className("home-link")).click();
				driver.switchTo().window(ParentWindow);
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/form/table/tbody/tr[13]/td/a/img")).click();

			driver.quit();

			
			}
		}


