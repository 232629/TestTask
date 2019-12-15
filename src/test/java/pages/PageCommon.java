package pages;

import infrastructure.IWbElement;
import infrastructure.MyWbElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class PageCommon extends PageBase {

    public IWbElement btnLive() {
        return new MyWbElement($(By.id("live_href")).shouldBe(exist));
    }


    public IWbElement btnMenuLiveFootball() {
        return new MyWbElement($(By.xpath("//a[@data-sporturl='Football']")).shouldBe(exist));
    }

    private IWbElement frmMenuLiveFootball() {
        return new MyWbElement($(By.xpath("//*[@id='allSport']//ul[@class='liga_menu']")).shouldBe(exist));
    }


}
