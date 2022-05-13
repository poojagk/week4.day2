package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);

		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

		String price1 = price.replaceAll(",", "");

		int price2 = Integer.parseInt(price1);

		System.out.println("The price is" + " " + price2);

		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();

		System.out.println("the rating is" + rating);

		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		File source = driver.getScreenshotAs(OutputType.FILE);

		File destination = new File("./images/img1.jpg");

		FileUtils.copyFile(source, destination);

		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();

		Thread.sleep(3000);

		String subtotal = driver.findElement(By.xpath("//span[contains(@id,'cart-total')]/following::span[contains(@id,'cart-subtotal')]")).getText();
		
		if(price1.contains(subtotal))
			System.out.println("The price matches");
		else
			System.out.println("No match");
		
		driver.quit();

	}

}
