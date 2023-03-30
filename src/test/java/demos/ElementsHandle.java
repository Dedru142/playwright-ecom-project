package demos;

import com.microsoft.playwright.*;

public class ElementsHandle {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(100)
        );

        Page newPage = browser.newPage();

        newPage.navigate("https://www.saucedemo.com/");

        String title = newPage.title();

        String url = newPage.url();

        System.out.println("title = " + title);
        System.out.println("url = " + url);

        Locator usernameInput = newPage.locator("#user-name");
        usernameInput.type("dan");
        newPage.waitForTimeout(2000);
        usernameInput.clear();
        newPage.waitForTimeout(2000);
        usernameInput.type("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        newPage.waitForTimeout(2000);
        usernameInput.fill("bbbbbbbbbbbbbbbbbbbbbbbbbbb");
        newPage.locator("[data-test='password']").fill("ad73");

        newPage.locator(".btn_action").click();

        String errorMessage = newPage.locator("[data-test=\"error\"]").textContent();
        System.out.println(errorMessage);

        newPage.waitForTimeout(3000);

        newPage.close();
        browser.close();
        playwright.close();
    }
}
