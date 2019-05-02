import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import context.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class FirstTest extends BaseTestCase {

    private MainPage mainPage;

    @Test
    @Video
    void firstTest() {
        String url = "https://soundcloud.com/";
        mainPage = new MainPage(driver);
        mainPage
            //step(1)
                .navigateToApplication(url)
            //step(2-3)
                .verifyAlbumTitlesAreSortedAlphabetically(false);
    }
}
