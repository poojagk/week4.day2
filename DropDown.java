package week4.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Select training program using index

		WebElement findElement = driver.findElement(By.id("dropdown1"));

		Select sel = new Select(findElement);

		sel.selectByIndex(2);

		// select training program using text

		WebElement findElement1 = driver.findElement(By.name("dropdown2"));

		Select sel1 = new Select(findElement1);

		sel1.selectByVisibleText("Selenium");
		
		//select training program by value

		WebElement findElement2 = driver.findElement(By.name("dropdown3"));

		Select sel2 = new Select(findElement2);

		sel2.selectByValue("3");
		
		//get the number of dropdown options
		
		WebElement findElement3 = driver.findElement(By.className("dropdown"));
		
		Select sel3=new Select(findElement3);
		
		List<WebElement> options = sel3.getOptions();
		
		System.out.println("The total number of options are"+" "+options.size());
		
		//using sendkeys to select value
		
		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select")).sendKeys("Loadrunner");
		
		//selecting multiple options
		
		WebElement findElement4 = driver.findElement(By.xpath("//option[text()='Select your programs']/parent::select"));
		
		Select sel4=new Select(findElement4);
		
		List<WebElement> options2 = sel4.getOptions();
		
		options2.get(1).click();
		options2.get(2).click();
		
	
	}

}
