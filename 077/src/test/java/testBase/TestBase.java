package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties Repository=new Properties();
	public File f;
	public FileInputStream fis;
	public WebDriver driver;
	
	public void init() {
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
		
	}
	
	public void loadPropertiesFile() {
		String filePath=System.getProperty("user.dir")+"/src/main/java/config/config.properties";
		
		f=new File(filePath);
		try {
			Repository.load(new FileInputStream(filePath));
			
			
		} catch (IOException e) {
		}
		String url="";
		String browser="";
		
		int i=0;
		for(String key: Repository.stringPropertyNames())
		{
			String val=Repository.getProperty(key);
			i++;
			
		}
	}
	
	public WebDriver selectBrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Selected firefox browser.... ");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Selected chrome browser... ");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\com\\compname\\BrowserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
			
			
		}
		return null; 
	}
	

}
