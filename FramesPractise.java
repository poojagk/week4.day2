package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Sending value to topic checkbox

		driver.switchTo().frame("frame1");

		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frames Practise");

		// selecting the checkbox

		driver.switchTo().frame("frame3");

		driver.findElement(By.id("a")).click();

		// selecting a value from dropdown

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");

		WebElement findElement = driver.findElement(By.id("animals"));

		Select sel = new Select(findElement);

		sel.selectByValue("babycat");

		driver.close();

	}

}
