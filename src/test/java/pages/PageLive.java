package pages;

import infrastructure.IWbElement;
import infrastructure.MyWbElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageLive extends PageCommon{

    public String title() {
        return "Live betting on sports – place a bet, high odds  | Astekbet – Betting Company";
    }

    public IWbElement btnLive() {
        return new MyWbElement($(By.id("live_href")).shouldBe(exist));
    }








}
