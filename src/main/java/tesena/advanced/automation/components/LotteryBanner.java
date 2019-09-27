package tesena.advanced.automation.components;

import tesena.advanced.automation.annotations.AndroidXpath;
import tesena.advanced.automation.driver.Driver;

public class LotteryBanner extends Component {

    @AndroidXpath(xpath = "")
    private Button component;

    public LotteryBanner(Driver driver) {
        super(driver);
    }
}
