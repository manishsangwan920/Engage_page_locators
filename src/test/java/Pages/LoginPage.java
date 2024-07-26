package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private Locator email;
    private Locator password;
    private Locator signInButton;

    public LoginPage(Page page) {
        this.page = page;
        email=page.getByPlaceholder("Email address");
        password= page.getByPlaceholder("Password");
        signInButton=page.locator("//button[@type='submit']");
    }
    public HomePage Login() {
        page.navigate("https://cloud.yellow.ai/auth/login");
        email.fill("manishsangwan920@gmail.com");
        password.fill("Yellow@219");
        signInButton.click();
        return new HomePage(page);
    }



}
