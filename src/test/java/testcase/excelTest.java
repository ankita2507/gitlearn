package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excelutility.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class excelTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
		
		ExcelReader excel=new ExcelReader("C:\\Users\\Abhishek Kumar\\eclipse-workspace\\selenium.com\\src\\test\\java\\excelsheet\\excelSelenium.xlsx");
		
		int row=excel.getRowCount("signup");
		
		for(int i=2;i<=row;i++) {
			
			String firstName=excel.getCellData("signup","firstname", i);
			String lastName=excel.getCellData("signup","lastname",i);
			String userName=excel.getCellData("signup","username",i);
			String passWord=excel.getCellData("signup","password",i);
			
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
			driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
			driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys(passWord);
			
	
			
			
			
		}
		
		
		
		
		
		

	}

}
