import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestCase {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\tools\\chromedriver.exe");
        try {
            Properties prop = new Properties();
            InputStream stream = this.getClass().getResourceAsStream("/video.properties");
            prop.load(stream);
            for (String name : prop.stringPropertyNames()) {
                String value = prop.getProperty(name);
                System.setProperty(name, value);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }




}
