package tesena.advanced.automation.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import tesena.advanced.automation.driver.Driver;

public class EurojackpotBanner extends Component {

    @AndroidFindBy(xpath = "//*[@resource-id='bannerButton']")
    private Button bannerButton;

    public EurojackpotBanner(Driver driver) {
        super(driver);
    }
}
