package Tests;

import Pages.HomePage;
import Pages.User360;
import Tests.BaseTest;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class User360Test extends BaseTest {
    @Test
    public void Test_Create_User() throws InterruptedException {
        HomePage hp=loginPage.Login();
        User360 us=hp.navigateToUse360Page();
        Locator userIdloc=us.createNewSingleUser();
        assertThat(userIdloc).hasText(us.userID);
        System.out.println(us.userID);

    }
}
