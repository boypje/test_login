package test_login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class login_automation {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		String csvFile = "D:/Data Dummy/data_absen.csv";
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		while((line = br.readLine()) != null) {
			String[] data = line.split(",");
			String username = data[0];
			String password = data[1];
			
			// membuka halaman login
			driver.get("https://nendi.cods3.com/login");
			
			// menemukan field username dan password
			
			WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			
			//klik button login
			
			WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div[2]/div/div[2]/form/div[4]/button/span"));
			loginButton.click();
			Thread.sleep(800);
			
			try {
				WebElement element;
				element = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/img"));
				element.click();
				Thread.sleep(500);
				WebElement logout = driver.findElement(By.xpath("/html/body/nav/ul/div/div/a[3]"));
				logout.click();
				System.out.println(username + " Berhasil Login ");
				
			} catch (NoSuchElementException e) {
				
				Thread.sleep(500);
				driver.manage().deleteAllCookies();
				driver.navigate().refresh();
				System.out.println(username + " Gagal Login");
				Thread.sleep(500);
				
			}
			
			
		}
		driver.quit();

	}

}
