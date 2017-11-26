package com.demoaut.newtours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class KeywordLibrary {

	static WebDriver driver;
	static Properties objectRepo;
	static String result;

	public static void callMethod(String param1, String param2, String param3, String param4) 
	{
		try
		{
			Class<?> c = Class.forName("com.demoaut.newtours.KeywordLibrary");
			Method m = c.getMethod(param1, String.class, String.class, String.class);
			m.invoke(null, param2, param3, param4);

		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static void loadProperties() throws IOException
	{
		File file = new File("ObjectRepo.properties");
		FileInputStream fis = new FileInputStream(file);
		objectRepo = new Properties();
		objectRepo.load(fis);
		fis.close();
	}

	public static void openBrowser() throws IOException
	{
		try 
		{
			File file = new File("Config.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties config = new Properties();
			config.load(fis);
			fis.close();
			if(config.getProperty("browser").equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/home/ashokkhape/Downloads/chromedriver");
				driver = new ChromeDriver();
				driver.get(config.getProperty("url"));
			}
			driver.manage().window().maximize();
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}

	}

	public static void enterText(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "name":
				driver.findElement(By.name(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "id":
				driver.findElement(By.id(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "css":
				driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "xpath":
				driver.findElement(By.xpath(objectRepo.getProperty(param2))).sendKeys(param3);;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}
	}

	public static void clickButton(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "name":
				driver.findElement(By.name(objectRepo.getProperty(param2))).click();
				break;
			case "id":
				driver.findElement(By.id(objectRepo.getProperty(param2))).click();
				break;
			case "css":
				driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(objectRepo.getProperty(param2))).click();;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}
	}

	public static void clickLink(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "linkText":
				driver.findElement(By.linkText(objectRepo.getProperty(param2))).click();
				break;		
			case "partialLinkText":
				driver.findElement(By.partialLinkText(objectRepo.getProperty(param2))).click();
				break;
			case "css":
				driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(objectRepo.getProperty(param2))).click();;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}
	}

	public static void selectDropDown(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "name":
				Select select_name = new Select(driver.findElement(By.name(objectRepo.getProperty(param2))));
				select_name.selectByVisibleText(param3);
				break;
			case "id":
				Select select_id = new Select(driver.findElement(By.id(objectRepo.getProperty(param2))));
				select_id.selectByVisibleText(param3);
				break;
			case "css":
				Select select_css = new Select(driver.findElement(By.cssSelector(objectRepo.getProperty(param2))));
				select_css.selectByVisibleText(param3);
				break;
			case "xpath":
				Select select_xpath = new Select(driver.findElement(By.xpath(objectRepo.getProperty(param2))));
				select_xpath.selectByVisibleText(param3);
				break;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}

	}
	
	public static void selectMultiList(String param1, String param2, String param3)
	{
		Actions action = new Actions(driver);
		try 
		{			
			action.keyDown(Keys.CONTROL);
			switch (param1)
			{
			case "name":
				Select select_name = new Select(driver.findElement(By.name(objectRepo.getProperty(param2))));
				select_name.selectByVisibleText(param3);
				break;
			case "id":
				Select select_id = new Select(driver.findElement(By.id(objectRepo.getProperty(param2))));
				select_id.selectByVisibleText(param3);
				break;
			case "css":
				Select select_css = new Select(driver.findElement(By.cssSelector(objectRepo.getProperty(param2))));
				select_css.selectByVisibleText(param3);
				break;
			case "xpath":
				Select select_xpath = new Select(driver.findElement(By.xpath(objectRepo.getProperty(param2))));
				select_xpath.selectByVisibleText(param3);
				break;
			}
			action.keyUp(Keys.CONTROL);
			result = "Passed";
		} catch(Exception e) {
			action.keyUp(Keys.CONTROL);
			result = "Failed";
		}

	}

	public static void verifyText(String param1, String param2, String param3)
	{
		boolean flag = false;
		try 
		{
			switch (param1)
			{
			case "name":
				flag = driver.findElement(By.name(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "id":
				flag = driver.findElement(By.id(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "css":
				flag = driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "xpath":
				flag = driver.findElement(By.xpath(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			}
			
			if(flag)
				result = "Passed";
			else 
				result = "Failed";
		} catch(Exception e) {
			result = "Failed";
		}
	}
	
	public static void verifyBuffer(String param1, String param2, String param3)
	{
		boolean flag = false;
		try 
		{
			switch (param1)
			{
			case "name":
				flag = driver.findElement(By.name(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "id":
				flag = driver.findElement(By.id(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "css":
				flag = driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			case "xpath":
				flag = driver.findElement(By.xpath(objectRepo.getProperty(param2))).getText().equals(param3);
				break;
			}
			
			if(flag)
				result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}
	}

	public static void clickCheckBox(String param1, String param2, String param3)
	{
		try 
		{
			if(param3.equals("null"))
			{
				switch (param1)
				{
				case "name":
					driver.findElement(By.name(objectRepo.getProperty(param2))).click();
					break;
				case "id":
					driver.findElement(By.id(objectRepo.getProperty(param2))).click();
					break;
				case "css":
					driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).click();
					break;
				case "xpath":
					driver.findElement(By.xpath(objectRepo.getProperty(param2))).click();
					break;
				}
			}
			else
			{
				//for selecting by value (in case value is provided ) 
				List<WebElement> elements = new ArrayList<WebElement>();
			switch (param1)
			{
			case "name":
				elements = driver.findElements(By.name(objectRepo.getProperty(param2)));
				break;
			case "id":
				elements = driver.findElements(By.id(objectRepo.getProperty(param2)));
				break;
			case "css":
				elements = driver.findElements(By.cssSelector(objectRepo.getProperty(param2)));
				break;
			case "xpath":
				elements = driver.findElements(By.xpath(objectRepo.getProperty(param2)));
				break;
			}
			for(WebElement element : elements)
			{
				System.out.println(element.getText());
				if(element.getAttribute("value").equals(param3))
				{
					element.click();
				}
			}
			}
			
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}

	}

	public static void clickRadioButton(String param1, String param2, String param3)
	{
		try 
		{
			if(param3.equals("null"))
			{
				switch (param1)
				{
				case "name":
					driver.findElement(By.name(objectRepo.getProperty(param2))).click();
					break;
				case "id":
					driver.findElement(By.id(objectRepo.getProperty(param2))).click();
					break;
				case "css":
					driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).click();
					break;
				case "xpath":
					driver.findElement(By.xpath(objectRepo.getProperty(param2))).click();
					System.out.println("found it");
					break;
				}
			}
			else
			{
				List<WebElement> elements = new ArrayList<WebElement>();
			switch (param1)
			{
			case "name":
				elements = driver.findElements(By.name(objectRepo.getProperty(param2)));
				break;
			case "id":
				elements = driver.findElements(By.id(objectRepo.getProperty(param2)));
				break;
			case "css":
				elements = driver.findElements(By.cssSelector(objectRepo.getProperty(param2)));
				break;
			case "xpath":
				elements = driver.findElements(By.xpath(objectRepo.getProperty(param2)));				
				break;
			}
			for(WebElement element : elements)
			{
				if(element.getAttribute("value").equals(param3))
				{
					element.click();
				}
			}
			}
			
			result = "Passed";
		} catch(Exception e) {
			e.printStackTrace();
			result = "Failed";
		}
	}
	

	public static void switchFrame(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "index":
				driver.switchTo().frame(param3);
				break;
			case "framename":
				driver.switchTo().frame(param3);
				break;
			case "frameid":
				driver.switchTo().frame(param3);
				break;
			case "name":
				driver.switchTo().frame(driver.findElement(By.name(objectRepo.getProperty(param2))));
				break;
			case "id":
				driver.switchTo().frame(driver.findElement(By.id(objectRepo.getProperty(param2))));
				break;
			case "css":
				driver.switchTo().frame(driver.findElement(By.cssSelector(objectRepo.getProperty(param2))));
				break;
			case "xpath":
				driver.switchTo().frame(driver.findElement(By.xpath(objectRepo.getProperty(param2))));
				break;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}

	}
	
	public static String bufferText(String param1, String param2, String param3)
	{
		String text = null;
		try 
		{
			switch (param1)
			{
			case "name":
				text = driver.findElement(By.name(objectRepo.getProperty(param2))).getText();
				break;
			case "id":
				text = driver.findElement(By.id(objectRepo.getProperty(param2))).getText();
				break;
			case "css":
				text = driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).getText();
				break;
			case "xpath":
				text = driver.findElement(By.xpath(objectRepo.getProperty(param2))).getText();
			}
			result = "Passed";
			return text;
		} catch(Exception e) {
			result = "Failed";
			return text;
		}

	}
	
	public static void takeSnapShot(String param1, String param2, String param3)
	{
		try 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(param3);
			org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
			
		} catch(Exception e) {
			result = "Failed";
		}

	}
	
	public static void uploadFile(String param1, String param2, String param3)
	{
		try 
		{
			switch (param1)
			{
			case "name":
				driver.findElement(By.name(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "id":
				driver.findElement(By.id(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "css":
				driver.findElement(By.cssSelector(objectRepo.getProperty(param2))).sendKeys(param3);
				break;
			case "xpath":
				driver.findElement(By.xpath(objectRepo.getProperty(param2))).sendKeys(param3);;
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}

	}
	
	public static void acceptPopup(String param1, String param2, String param3)
	{
		try
		{
			driver.switchTo().alert().accept();
			result = "Passed";
		}catch (Exception e) {
			result = "Failed";
		}
	}
	
	public static void dismissPopup(String param1, String param2, String param3)
	{
		try
		{
			driver.switchTo().alert().dismiss();
			result = "Passed";
		}catch (Exception e) {
			result = "Failed";
		}
	}
	
	public static void writetPopup(String param1, String param2, String param3)
	{
		try
		{
			driver.switchTo().alert().sendKeys(param3);;
			result = "Passed";
		}catch (Exception e) {
			result = "Failed";
		}
	}
	
	public static String readPopup(String param1, String param2, String param3)
	{
		String text = "";
		try
		{
			text = driver.switchTo().alert().getText();
			result = "Passed";
			return text;
		}catch (Exception e) {
			result = "Failed";
			return text;
		}
	}
	
	public static void verifyPopup(String param1, String param2, String param3)
	{
		try
		{ 
			if(driver.switchTo().alert().equals(param3))
				result = "Passed";
			else
				result = "Failed";
		}catch (Exception e) {
			result = "Failed";
		}
	}
	
	public static void switchWindow(String param1, String param2, String param3)
	{
		try
		{
			if(param3.equals("null"))
			{
				for(String win : driver.getWindowHandles())
				{
					driver.switchTo().window(win);
				}
			}
			else
			{
				for(String win : driver.getWindowHandles())
				{
					if(win.equals(param3))
					{
						driver.switchTo().window(win);
					}
				}
			}
			result = "Passed";
		} catch(Exception e) {
			result = "Failed";
		}
	}

	
}
