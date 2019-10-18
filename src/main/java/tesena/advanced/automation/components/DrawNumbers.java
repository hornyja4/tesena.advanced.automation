package tesena.advanced.automation.components;

import org.openqa.selenium.By;
import tesena.advanced.automation.driver.Driver;

public class DrawNumbers extends Component {

    public DrawNumbers(Driver driver) {
        super(driver);
    }

    public void selectFirstColumnNumbers(String... numbers) {
        for (String number : numbers) {
            findElement(By.xpath(".//*[@text='" + number + "']")).click();
        }
    }
}
