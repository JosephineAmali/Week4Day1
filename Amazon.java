package Week4;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--default-notifitions");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click(); 
		String pdtPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();		
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot.png");
		FileUtils.copyFile(source, destination);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		//driver.findElement(By.id("add-to-cart-button")).click();
		
		String subTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
			
//		int i=Integer.parseInt(subTotal.substring(1)); 
//		int j = Integer.parseInt(pdtPrice);
//		System.out.println(i);
		//String subTotal1 = subTotal.substring(1);
		System.out.println(pdtPrice);
		if (subTotal.substring(1).contains(pdtPrice))
			
				System.out.println("Subtotal Verified");
		else
			System.out.println("Try again!!");
		driver.close();		
		driver.switchTo().window(windows.get(0));
		driver.close();
		
	}

}
