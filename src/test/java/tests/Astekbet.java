package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.springframework.util.Assert;
import pages.PageLive;

import static com.codeborne.selenide.Selenide.*;

public class Astekbet extends Setup {

    @Test
    public void testLive() {
        PageLive pageLive = new PageLive();
        open("https://astekbet55.com/en/live/");

        ElementsCollection fff = $$(By.xpath("//div[@class=\"c-events__icons\"]/div[contains(@class, 'c-events__ico_video')]"));
        ElementsCollection de = $$(By.xpath("//div[contains(@class, 'c-events__ico_video')]/ancestor::div[@class=\"c-events-scoreboard\"]//span[@class=\"c-events__teams\"]"));
        System.out.println("Size =" + de.size());

        ElementsCollection f = $$(By.xpath("//div[@data-name='dashboard-champ-content']"));
        int ii =1;
        for (SelenideElement i:f) {
            System.out.println("Championship: " + i.$(By.xpath(".//a[@class='c-events__liga']")).text());
            ElementsCollection ff = i.$$(By.xpath(".//div[contains(@class, 'c-events__ico_video')]/ancestor::div[@class='c-events-scoreboard']//span[@class='c-events__teams']"));
            if (ff.isEmpty())
                System.out.println("There are not Live events.");
            for (SelenideElement j:ff) {
                System.out.println("Event: "+j.getAttribute("title"));
            }
        }
    }


    @Test()
    public void testLiveFootball() throws InterruptedException {
        open("https://astekbet55.com/en/live/Football/");

        boolean flag = false;

        SelenideElement ligs = $(By.xpath("//*[@id='allSport']//ul[@class='liga_menu']"));
        ElementsCollection l = ligs.$$(By.xpath("./li"));
        System.out.println(l.size());

        for (SelenideElement i : l) {

            i.$(By.xpath("./a")).click();
            i.waitUntil(Condition.attribute("class","open"), 10000);

            ElementsCollection es = i.$$(By.xpath(".//ul[@class='event_menu']/li"));

            System.out.println(es.size());

            for (SelenideElement j : es) {

                System.out.println(j.$(By.xpath(".//div[contains(@class, 'ls-game__action_video')]")).exists());
                if(j.$(By.xpath(".//div[contains(@class, 'ls-game__action_video')]")).exists()) {
                    j.click();
                    $(By.xpath("//a[@title='Broadcast']")).shouldBe(Condition.visible);
                    System.out.println($(By.xpath("//div[contains(@class, 'c-tablo__main-info')]")).text());
                    flag = true;
                }
            }

            //close
            i.$(By.xpath("./a")).click();
            i.waitUntil(Condition.attribute("class",""), 10000);
        }
        Assert.isTrue(flag, "There are not Live games");
    }

}
