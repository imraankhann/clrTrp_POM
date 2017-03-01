package utill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static WebDriver driver=null;
	
	public static WebDriver browser(String browser){
		try {
			if(browser.equalsIgnoreCase("firefox")){
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				driver=new ChromeDriver();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		return driver;
	}
	

}
