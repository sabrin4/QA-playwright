import PlaywrightFactory.PlaywrightUtils;
import Qase.QaseReporter;
import org.junit.jupiter.api.Test;

public class ValidDataAuthWithPhoneTest {
    @Test
    void validDataAuthTest() {
        PlaywrightUtils.openBaseUrl();
        PlaywrightUtils.pressLoginMenuButton();
        PlaywrightUtils.fillLoginForm();
        PlaywrightUtils.pressLoginConfirmButton();
        PlaywrightUtils.pressUserProfileButton();
        PlaywrightUtils.tearDown();
        QaseReporter.addTestRunResult(System.getenv("SP"), 10);
    }
}