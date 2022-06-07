package Week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-noifications");
				
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Clicking from contact Widget
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();		
		Set<String> windoHandles = driver.getWindowHandles();		
		List<String> windows = new ArrayList<String>(windoHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(2000);		
		WebElement findFirstLnk = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		findFirstLnk.click();
		driver.switchTo().window(windows.get(0));
		
		
		
		//Clicking to contact Widget
				driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();		
				Set<String> windoHandles1 = driver.getWindowHandles();		
				List<String> windows1 = new ArrayList<String>(windoHandles1);
				driver.switchTo().window(windows1.get(1));
				Thread.sleep(2000);
				WebElement findFirstLnk2 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
				driver.switchTo().window(windows1.get(0));
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				String title = driver.getTitle();
				System.out.println(title);
				if(title.contains("Merge"))
					System.out.println("Merge Succesful");
				else
					System.out.println("Try again!!");		
	}
}
