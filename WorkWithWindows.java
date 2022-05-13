package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click button to open home page in New Window

		driver.findElement(By.xpath("//button[@id='home']")).click();

		String parent = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		Thread.sleep(2000);

		driver.close();

		driver.switchTo().window(parent);

		// Find the number of opened windows

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();

		Set<String> windowHandles2 = driver.getWindowHandles();

		List<String> windows2 = new ArrayList<String>(windowHandles2);

		for (int i = 0; i < windows2.size(); i++) {
			driver.switchTo().window(windows2.get(i));

		}
		System.out.println("The number of open windows are" + " " + windows2.size());

		// Close all except this window

		driver.switchTo().window(windows2.get(1));
		driver.close();
		driver.switchTo().window(windows2.get(2));
		driver.close();

		driver.switchTo().window(parent);

		// Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();

		Thread.sleep(5000);

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windows3 = new ArrayList<String>(windowHandles3);
		for (int i = 0; i < windows3.size(); i++) {
			driver.switchTo().window(windows3.get(i));
		}

		driver.quit();

	}

}
