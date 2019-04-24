package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	public static void scrollTillEnd(WebDriver driver) {
		int currentCount = 1;
		int prevCount = 0;
		while ((currentCount - prevCount) != 0) {
			prevCount = driver.findElements(By.cssSelector("div.fli-list.splitVw-listing")).size();
			for (int i = 1; i <= 8; i++) {
				new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			currentCount = driver.findElements(By.cssSelector("div.fli-list.splitVw-listing")).size();
			System.out.println(prevCount + "  " + currentCount);
		}

	}
}