package demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstRun {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );

        Page newPage = browser.newPage();

        newPage.navigate("https://playwright.dev/java/");

        String title = newPage.title();

        String url = newPage.url();

        System.out.println("title = " + title);
        System.out.println("url = " + url);

        newPage.waitForTimeout(3000);

        newPage.close();
        browser.close();
        playwright.close();


    }
}
