package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merge {

	public static void main(String[] args) {
			
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		Set <String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		
		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		driver.switchTo().window(lstwindows.get(0));
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		
		allwindowhandles = driver.getWindowHandles();
		lstwindows = new ArrayList<String>(allwindowhandles);
		driver.switchTo().window(lstwindows.get(1));
		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		driver.switchTo().window(lstwindows.get(0));
		
		driver.findElement(By.className("buttonDangerous")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
 
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		 
		driver.close();
		
	}
}
