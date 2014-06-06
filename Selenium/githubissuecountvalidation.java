import java.util.*;
import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class githubissuecountvalidation{ 
    public static void main(String[] args) {
        // Create a new Firefox popup using Driver
    	WebDriver driver=new FirefoxDriver();     
    	//Open www.google.com
    	driver.get("http://www.google.com");
    	//Search html5rocks
    	WebElement searchquery = driver.findElement(By.name("q"));
    	searchquery.sendKeys("html5rocks");
    	//searchquery.submit();
    	driver.findElement(By.name("btnG")).click();
    	//Wait till search results are returned
    	driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
    	driver.findElement(By.linkText("HTML5Rocks · GitHub")).click();
    	//Wait till the GitHub link of HTML5 Rocks is opened 
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.linkText("www.html5rocks.com")).click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	//Click on issues field 
    	driver.findElement(By.xpath("//li[2]/a/span[2]")).click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	//Scrape open and close issue counts
    	String open_issues=driver.findElement(By.cssSelector("a[href*='open']")).getText();
    	String closed_issues=driver.findElement(By.cssSelector("a[href*='closed']")).getText();
    	String [] arr=open_issues.split(" ");
    	int open=Integer.parseInt(arr[0].split("\n")[0]);
    	int closed=Integer.parseInt(closed_issues.split(" ")[0]);
    	System.out.println("Open Issues:"+open);
    	System.out.println("Closed Issues:"+closed);
		// Validate open issue count with 200 
    	try{
    		org.testng.Assert.assertTrue(open <= 200);
    	    System.out.println("Test Passed: Number of open issues are less than 200");
    	}
    	catch(Throwable t){
            System.out.println("Test Failed: Number of open issues are greater than 200");
        }
    	
    }
}