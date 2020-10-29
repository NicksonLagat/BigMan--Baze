import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[]args){

        System.setProperty("webdriver.chrome.driver","Utilis.CHROME_DRIVER_LOCATION");


    }

    @Test(testName = "Login Functionality")
    public static void login() {
        driver.manage().window().maximize();
        driver.get(Utilis.BASE_URL);
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MICROSECONDS);
        lp.enterPassword();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MICROSECONDS);
        lp.clickSubmit();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MICROSECONDS);
        lp.errorMessage();
    }

    @AfterSuite
        public static void tearDown(){

            Date d = new Date();
            System.out.println(d.toString());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("D:\\Screenshots\\"+sdf.format(d)+".png"));
            } catch (IOException e) {

                e.printStackTrace();

            }

            driver.manage().deleteAllCookies();
            driver.close();

        }
    }
