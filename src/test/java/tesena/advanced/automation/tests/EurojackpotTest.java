package tesena.advanced.automation.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import tesena.advanced.automation.Sazka;
import tesena.advanced.automation.objects.HomePage;

public class EurojackpotTest extends Sazka {

    @Test
    public void eurojackpot() {
        HomePage homePage = new HomePage(driver);
        homePage.eurojacpot()
                .bet()
                .fillNewBet()
                .selectNumbers()
                .selectEuroFirstRowNumbers("1", "2", "3", "4", "5")
                .selectSecondRowNumbers("1", "2")
                .done();
    }
}
