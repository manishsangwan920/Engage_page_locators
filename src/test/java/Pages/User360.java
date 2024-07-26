package Pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.UUID;

public class User360 {

    Faker faker =new Faker();
    public String userID;
    private Page page;
    private Locator addUserButton;
    private Locator singleUserOption;
    private Locator adduserFirstname;
    private Locator addUserUserId;
    private Locator addUserGender;
    private Locator adduserLastname;
    private Locator addUserEmailOptInYes;
    private Locator addUserEmailOptInNo;
    private Locator addUserWhatsappOptInNo;
    private Locator addUserWhatsappOptInYes;
    private Locator addUsersmsOptInYes;
    private Locator addUsersmsOptInNO;
    private Locator addUserSearchProperty;
    private Locator addUserPhone;
    private Locator addUserLanguage;
    private Locator addUserDOB;
    private  Locator addUserEmail;
    private  Locator addUserCity;
    private  Locator addUserCountry;
    private  Locator addUserLastChannel;
    private  Locator addUserTimezone;
    private Locator addUserSaveButton;
    private Locator addUserCancelButton;
    private Locator getAddUserCloseButton;
    private Locator userPropertiesButton;
    private Locator addSegmentButton;
    private Locator userTableUserID;


    public User360(Page page) {
        this.page=page;
        addUserButton=page.locator("//button/span[text()='Add user']");
        singleUserOption=page.getByText("Single user");
        adduserFirstname= page.getByTestId("engage-user-property-firstName");
        adduserLastname = page.getByTestId("engage-user-property-lastName");
        addUserUserId=page.getByTestId("engage-user-property-userId");
        addUserGender=page.getByLabel("gender");
        addUserEmailOptInYes=page.locator("#emailOptIn").getByLabel("Yes");
        addUserEmailOptInNo=page.locator("#emailOptIn").getByLabel("No");
        addUserWhatsappOptInNo=page.locator("#whatsAppOptIn").getByLabel("No");
        addUserWhatsappOptInYes=page.locator("#whatsAppOptIn").getByLabel("Yes");
        addUsersmsOptInYes=page.locator("#smsOptIn").getByLabel("Yes");
        addUsersmsOptInNO=page.locator("#smsOptIn").getByLabel("No");
        addUserSearchProperty=page.getByTestId("engage-user-property-search");
        addUserPhone=page.getByPlaceholder("Enter phone number");
        addUserLanguage=page.getByLabel("language");
        addUserDOB=page.getByTestId("engage-user-property-dob");
        addUserEmail=page.getByTestId("engage-user-property-email");
        addUserCity=page.getByTestId("engage-user-property-city");
        addUserCountry=page.getByLabel("country");
        addUserLastChannel=page.getByTestId("engage-user-property-lastChannel");
        addUserTimezone=page.getByLabel("timezone");
        userPropertiesButton= page.locator("//span[text() ='User properties']");
        addSegmentButton=page.locator("//span[text() ='Add segment']");
        addUserSaveButton=page.locator(".engage-mfe--drawerLayout__footer--pnDpuNsr").getByText("Add user");
        userTableUserID=page.locator("//tr[@data-row-key='0']/td[2]/div/div[2]");



    }
    public Locator createNewSingleUser() throws InterruptedException {
        addUserButton.click();
        singleUserOption.click();
        userID=UUID.randomUUID().toString();
        addUserUserId.fill(userID);
        adduserFirstname.fill(faker.name().firstName());
        adduserLastname.fill(faker.name().lastName());
        addUserCity.fill("Jaipur");

        addUserGender.click();
        page.getByTitle("male", new Page.GetByTitleOptions().setExact(true)).locator("div").click();
        addUserEmailOptInNo.click();
        addUserWhatsappOptInYes.click();
        addUsersmsOptInNO.click();
        addUserCountry.click();

        page.getByTitle("India", new Page.GetByTitleOptions().setExact(true)).locator("div").click();

        addUserSaveButton.click();


        Thread.sleep(4000);
        page.reload();
        Thread.sleep(2000);
        return userTableUserID;
    }

}
