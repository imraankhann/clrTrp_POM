package utill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtill {
	
	public static boolean implicitWait(long time){
		try {
			Driver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			System.out.println("waited for "+time+" seconds implicityly... ");
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	public static boolean lanuchBrowser(String url){
		try{
			Driver.driver.get(url);
			Driver.driver.manage().window().maximize();
			
		}catch(Exception e){
			return false;
			
		}
		return true;
		
		
	}
	
	public void selectByNameMethod(WebElement ele) throws InterruptedException {
		Select s=new Select(ele);
		Thread.sleep(2000);

	}

}
