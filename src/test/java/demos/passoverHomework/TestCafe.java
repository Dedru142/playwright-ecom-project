package demos.passoverHomework;

import com.microsoft.playwright.*;

public class TestCafe {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(100)
        );
        Page newPage = browser.newPage();

        newPage.navigate("https://devexpress.github.io/testcafe/example/");

        newPage.locator("[data-testid=\"name-input\"]").type("Dan");

        String[] checkboxes = {"remote-testing-checkbox", "reusing-js-code-checkbox", "parallel-testing-checkbox", "ci-checkbox", "analysis-checkbox", "tried-testcafe-checkbox"};
        for (String checkbox : checkboxes) {
            newPage.locator("[data-testid=\"" + checkbox + "\"]").click();
        }

        newPage.locator("[data-testid=\"comments-area\"]").type("something!");
        newPage.locator("[data-testid=\"submit-button\"]").click();

        System.out.println(newPage.locator("[data-testid=\"thank-you-header\"]").textContent());
        System.out.println("url = " + newPage.url());
        System.out.println("title = " + newPage.title());

        newPage.close();
        browser.close();
        playwright.close();
    }
}