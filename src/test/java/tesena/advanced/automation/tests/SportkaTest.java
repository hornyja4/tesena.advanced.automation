package tesena.advanced.automation.tests;

import org.testng.annotations.Test;
import tesena.advanced.automation.Sazka;
import tesena.advanced.automation.objects.HomePage;

public class SportkaTest extends Sazka {

    @Test
    public void sportka() {
        HomePage homePage = new HomePage(driver);
        homePage.sportka()
                .bet()
                .fillNewBet()
                .selectNumbers()
                .selectSportkaFirstRowNumbers("2", "5", "8", "10", "12", "14")
                .done();
    }
}
