import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkartautomation {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Flipkart_Automation\\Chromedriver\\chromedriver.exe");
        WebDriver Admin = new ChromeDriver();
        Admin.manage().window().maximize();
        Admin.get("https://www.flipkart.com/");
        Thread.sleep(2000); 

        
        try {
            WebElement closePopup = Admin.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("No login popup, continuing...");
        }

        
        Admin.findElement(By.name("q")).sendKeys("iPhone 16 Pro");
        Admin.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000); 

        
        Admin.findElement(By.xpath("(//div [@class=\"KzDlHZ\"])[1]")).click();
        Thread.sleep(2000);

        
        ArrayList<String> tabs = new ArrayList<>(Admin.getWindowHandles());
        Admin.switchTo().window(tabs.get(1)); 

        
        JavascriptExecutor jss = (JavascriptExecutor) Admin;
        jss.executeScript("window.scrollBy(0,850)");

        
        File d = ((TakesScreenshot) Admin).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(d, new File("C:\\Users\\User\\Downloads\\Sele_photo\\productdetail.png"));
        
        Admin.findElement(By.xpath("//button [@class=\"QqFHMw vslbG+ _3Yl67G _7Pd1Fp\"]")).click();
        Thread.sleep(2000);
        
        File P = ((TakesScreenshot) Admin).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(P, new File("C:\\Users\\User\\Downloads\\loginss\\loginss.png"));
		

	}

}

