import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class DemoPlaywright {

        @Test
        public void testSearchAndOpenProduct() {
            try (Playwright playwright = Playwright.create()) {

                Browser browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                );

                Page page = browser.newPage();

                page.navigate("https://demowebshop.tricentis.com/");

                page.fill("[name=q]", "computer");

                page.press("[name=q]", "Enter");

                page.click("[href='/build-your-cheap-own-computer']");

                String actual = page.title();
                String expected = "Demo Web Shop. Build your own cheap computer";

                assertEquals(expected, actual);


                browser.close();
            }
        }
    }

