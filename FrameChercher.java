package Week4;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameChercher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--sisable-notfications");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		//Displaying the Topic in  the input box
		
		String topic = driver.findElement(By.xpath("//label[text()='Topic : ']/span")).getText();
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys(topic);
		
		//Accesing the checkbox
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frameElement1);		
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		
		
		//selecting the option in the dropdown		
		WebElement frameElement2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frameElement2);		
		WebElement ddEle = driver.findElement(By.xpath("//b[text()='Animals :']/following-sibling::select"));
		
		Select ddSelect = new Select(ddEle);
		ddSelect.selectByIndex(2);
		
		
		
		
		
		
		

	}

}
