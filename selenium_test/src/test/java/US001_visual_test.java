import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
import us001_selenium_test.framework.FunctionalTest;

@Snap("JobRolePage.png")
public class US001_visual_test extends FunctionalTest {
    private final WebDriver driver;

    public US001_visual_test(WebDriver driver){
        this.driver = driver;
    }

    public OcularResult compare() {
        return Ocular.snapshot().from(this)
                .sample().using(driver)
                .compare();
    }
}
