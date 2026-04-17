package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public Logger logger;  //Log4j
public static WebDriver driver;
public Properties pr;	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		//Loading config.properties file
		FileReader fl=new FileReader("./src//test//resources//config.properties");
		pr=new Properties();
		pr.load(fl);
		
		logger=LogManager.getLogger(this.getClass()); //log4j2 code
		
		if(pr.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			case "firefox": cap.setBrowserName("firefox");break;
			default: System.out.println("No matching browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		
		if(pr.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("Invalid browser name..."); return;
			}
		}
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pr.getProperty("appurl2")); //Reading url from properties file
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String tgFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_"+ timeStamp + ".png";
		File tg=new File(tgFilePath);
		src.renameTo(tg);
		return tgFilePath;
	}

}
