package com.browserlanuch;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class App_Diag {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.diagrams.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement decidelater = driver.findElement(By.xpath("//span[text()='Decide later']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		decidelater.click();
		driver.findElement(By.xpath("//a[@class='geItem'][7]")).click();
		driver.findElement(By.xpath("//div[@class='geStatusAlertOrange']")).click();
		driver.findElement(By.xpath("//input[@value='Untitled Diagram']")).sendKeys("circle");
		WebElement filetype = driver.findElement(By.xpath("//input[@value='Untitled Diagram']//following::select"));
		Select s = new Select(filetype);
		s.selectByVisibleText("Editable Bitmap Image (.png)");
		driver.findElement(By.xpath("//div[text()='OneDrive']")).click();
		driver.findElement(By.xpath("//button[@class='geBigButton']")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();
		driver.switchTo().window(child);
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("vpradeepan03@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("One1drive23");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='DontShowAgain']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//button[@class='geBtn gePrimaryBtn']")).click();
		driver.findElement(By.xpath("//button[@class='geBtn gePrimaryBtn']")).click();
		WebElement file = driver.findElement(By.xpath("//a[text()='File']"));
		file.click();
		WebElement export = driver.findElement(By.xpath("//td[text()='Export as']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(export).build().perform();
		driver.findElement(By.xpath("//td[text()='PNG...']")).click();
		WebElement exportpng = driver.findElement(By.xpath("//button[text()='Export']"));
		exportpng.click();
		Thread.sleep(3000);
		WebElement filename = driver.findElement(By.xpath("//input[@value='circle.drawio.png']"));
		Thread.sleep(3000);
		filename.click();
		driver.findElement(By.xpath("//a[@class='geBaseButton'][2]")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

}
