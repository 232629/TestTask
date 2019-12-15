package pages;

import infrastructure.IWbElement;
import infrastructure.MyWbElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class PageLiveFootball extends PageCommon{

    public String title() {
        return "Live betting on Football – place a bet, high odds  | Astekbet – Betting Company";
    }

    public IWbElement btnBroadcast() {
        return new MyWbElement($(By.xpath("//a[@title='Broadcast']")));
    }


}
