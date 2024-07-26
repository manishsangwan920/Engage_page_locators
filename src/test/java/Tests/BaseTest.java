package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.User360;
import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@Getter
public class BaseTest {
    private Page page;
    private Playwright playwright;
    private Browser browser;
    LoginPage loginPage;
    @BeforeSuite
    public void setPlaywright(){
        this.playwright =Playwright.create();
    }
    @BeforeMethod
    public void setBrowser(){
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        launchOptions.setChannel("chrome");
        this.browser =playwright.chromium().launch(launchOptions);
        BrowserContext context=browser.newContext();
       this.page=context.newPage();
        loginPage=new LoginPage(page);
    }
    @AfterMethod
    public void closeBrowser(){
        page.close();
        browser.close();
    }
    @AfterSuite
    public void closePlayWright(){
        playwright.close();
    }
}
