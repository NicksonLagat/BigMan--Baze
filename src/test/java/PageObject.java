import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    //instance of the webdriver
    protected WebDriver driver;
    //constructor
    public PageObject(WebDriver driver){
        this.driver = driver;
        //initialize elements
        PageFactory.initElements(driver,this);
    }


}
