package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.close;


public class Setup {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("BeforeClass");
        Configuration.browser = "chrome";
        //Configuration.startMaximized = true;
        Configuration.browserSize= "1920x30000";
        Configuration.headless = true;
        Configuration.timeout = 20000;

        System.setProperty("chromeoptions.args", "--disable-notifications,--no-sandbox,--enable-automation,--disable-infobars");


    }

    @BeforeEach
    public void beforeTest(TestInfo testInfo) {
        System.out.println("Test: '" + testInfo.getDisplayName() + "' was started.");

    }


    @AfterEach
    public void afterTest() {

        close();
    }

    @AfterAll
    public static void afterAllTests() {
        close();
    }

}
