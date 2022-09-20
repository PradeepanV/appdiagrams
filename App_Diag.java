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
		// finding decide later option
		WebElement decidelater = driver.findElement(By.xpath("//span[text()='Decide later']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// click on decide later option
		decidelater.click();
		// to draw circle,finding and click on circle
		driver.findElement(By.xpath("//a[@class='geItem'][7]")).click();
		// finding click here to save
		driver.findElement(By.xpath("//div[@class='geStatusAlertOrange']")).click();
		// giving filename using sendkeys
		driver.findElement(By.xpath("//input[@value='Untitled Diagram']")).sendKeys("circle");
		// locating to file format dropdown
		WebElement filetype = driver.findElement(By.xpath("//input[@value='Untitled Diagram']//following::select"));
		Select s = new Select(filetype);
		// selecting png as file format
		s.selectByVisibleText("Editable Bitmap Image (.png)");
		// click on onedrive to save diagram
		driver.findElement(By.xpath("//div[text()='OneDrive']")).click();
		// giving authorization to save diagram in onedrive
		driver.findElement(By.xpath("//button[@class='geBigButton']")).click();
		Thread.sleep(3000);
		// handling multiple windows using getwindowhandles
		Set<String> windows = driver.getWindowHandles();
		// using iterator traverse into forward direction
		Iterator<String> iterator = windows.iterator();
		// parent window - app.diagrams
		String parent = iterator.next();
		// child window - onedrive login page
		String child = iterator.next();
		// moving parent window to child window using switchto method
		driver.switchTo().window(child);
		// finding sign in
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		// entering email sign in using sendkeys
		email.sendKeys("vpradeepan03@gmail.com");
		// click on next button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		// locating and entering password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("One1drive23");
		// click on sign in button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		// click on dontshowagain checkbox
		driver.findElement(By.xpath("//input[@name='DontShowAgain']")).click();
		// click on submit button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		// switch back to parent window
		driver.switchTo().window(parent);
		// choosing root folder
		driver.findElement(By.xpath("//button[@class='geBtn gePrimaryBtn']")).click();
		// showing pop-up already exists, do you want to replace it, click on ok button
		driver.findElement(By.xpath("//button[@class='geBtn gePrimaryBtn']")).click();
		// locating to file
		WebElement file = driver.findElement(By.xpath("//a[text()='File']"));
		// click on file
		file.click();
		// to export diagram, finding export as
		WebElement export = driver.findElement(By.xpath("//td[text()='Export as']"));
		// using actions class to do mouse hover
		Actions ac = new Actions(driver);
		// by using movetoelement mouse hover to that particular element
		ac.moveToElement(export).build().perform();
		// locating and click on png
		driver.findElement(By.xpath("//td[text()='PNG...']")).click();
		// locating export button
		WebElement exportpng = driver.findElement(By.xpath("//button[text()='Export']"));
		// click on export button
		exportpng.click();
		// locating filename
		WebElement filename = driver.findElement(By.xpath("//h2[text()='Save as']//following::input"));
		filename.click();
		// click on onedrive to export image
		driver.findElement(By.xpath("//a[@class='geBaseButton'][2]")).click();
		// choosing folder to export image
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		// showing pop-up already exists, do you want to replace it, click on ok button
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

}
