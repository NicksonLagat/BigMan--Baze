import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends PageObject {

    private final String USERNAME = "";
    private final String PASSWORD = "admin123";
    private final String EXPECTED_MESSAGE = "Username cannot be empty";

    @FindBy(id= "txtUsername")
    private WebElement txtUsername;

    @FindBy(id= "txtPassword")
    private WebElement txtPassword;

    @FindBy(name = "Submit")
    private WebElement Submit;

    @FindBy(xpath = "//*[@id=\"forgotPasswordLink\"]/a")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    private WebElement spanMessage;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(){
        this.txtUsername.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.txtPassword.sendKeys(PASSWORD);
    }

    public void clickSubmit(){
        this.Submit.click();
    }

    public void errorMessage() {


        String ACTUAL_MESSAGE = this.spanMessage.getText();
        Assert.assertEquals(ACTUAL_MESSAGE, EXPECTED_MESSAGE);
        System.out.println(ACTUAL_MESSAGE);

        if(spanMessage.isDisplayed()){

            this.forgotPasswordLink.click();

            System.out.println("Message Displayed");
        }
        else{

            System.out.println("Login was Successful");

        }


    }


    }





