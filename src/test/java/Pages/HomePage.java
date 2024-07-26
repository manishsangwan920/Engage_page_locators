package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private Locator sidebarExpand;
    private Locator engageMenu;
    private Locator user360Button;
    public HomePage(Page page) {
        this.page=page;
        sidebarExpand=page.getByTestId("global-sidebar-collapse-toggle");
        engageMenu=page.getByTestId("globalsidebar-submenu-Engage");
        user360Button=page.getByTestId("globalsidebar-menu-item-User 360");
    }
    public User360 navigateToUse360Page()  {
        sidebarExpand.click();
        engageMenu.click();
        user360Button.click();

        return new User360(page);
    }


}
