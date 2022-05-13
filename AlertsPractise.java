package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();

		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click();

		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		driver.switchTo().window(windowHandle);

		driver.findElement(By.xpath("(//input[@id='partyIdTo']/following::img)[1]")).click();

		Set<String> windowhandles = driver.getWindowHandles();

		List<String> windowslist = new ArrayList<String>(windowhandles);

		driver.switchTo().window(windowslist.get(1));

		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		driver.switchTo().window(windowHandle);

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();

		String title = driver.getTitle();

		if (title.equals("View Contact | opentaps CRM")) {
			System.out.println("Title matches");
		} else
			System.out.println("Title not matches");

	}

}
