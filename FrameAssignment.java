package Week4;

import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//Handle notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//Opening Home Page
		driver.findElement(By.xpath("//button[@id= 'home']")).click();		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println("I am in Home Page now!!");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(windows.get(0));
		System.out.println("I am back to Parent Window");
		
		
		
		//Opening Multiple Windows
		driver.findElement(By.xpath("//button[text()= 'Open Multiple Windows']")).click();		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		System.out.println("The no of windows opened is "+ windows1.size());
		for(int i = 1; i< windows1.size();i++)
		{
				driver.switchTo().window(windows1.get(i));
				driver.close();
		}
		 
		//Opening  and not closing child windows
		driver.switchTo().window(windows1.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();	
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles1);
		System.out.println(windows2.size());
//		driver.switchTo().window(windows1.get(0));
//		driver.close();
		System.out.println("Child windows not closed !!");
		
		
		driver.switchTo().window(windows1.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();	
		Set<String> windowHandles3  = driver.getWindowHandles();
		List<String> windows3 = new ArrayList(windowHandles3);
		
		
		
		System.out.println("Opened 2 windows after 5 seconds");
				

		
		
				
	}

}
