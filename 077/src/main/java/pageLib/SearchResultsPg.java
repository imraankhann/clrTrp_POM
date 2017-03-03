package pageLib;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPg {
	
	WebDriver driver;
	
	static Logger log=Logger.getLogger(SearchResultsPg.class.getName());
	
	By resultsPgTxt=By.cssSelector(".searchSummary .truncate:first-child");
	
	By bookBtnInResultsPg=By.xpath(".//*[@id='flightForm']/section[2]/div[3]/div[3]/button");
	
	
	public SearchResultsPg(WebDriver driver){
		this.driver=driver;
	}
	
	public String getResultTextFromResultPg(){
		log.info("Getting results text from search results page.. ");
		return driver.findElement(resultsPgTxt).getText();
	}
	
	public void clickBookBtnInResultsPg(){
		log.info("Clicking book button in results page... ");
		driver.findElement(bookBtnInResultsPg).click();
	}
	
	

}
