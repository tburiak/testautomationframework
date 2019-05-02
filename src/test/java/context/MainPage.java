package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'descriptionContainer')]//a")
    private List<WebElement> linksOfAlbum;

    private ArrayList<String> getListOfAlbumsTitle(){
        ArrayList<String> albumsTitles= new ArrayList<String>();
        for(WebElement linkOfAlbum : linksOfAlbum){
            String albumTitle = linkOfAlbum.getText();
            albumsTitles.add(albumTitle);
        }
        System.out.println("Actual list of Titles: " + albumsTitles);
        return albumsTitles;
    }

    public MainPage navigateToApplication(String url){
        driver.get(url);
        return this;
    }

    public MainPage verifyAlbumTitlesAreSortedAlphabetically(boolean expected) {
        ArrayList<String> actualList = getListOfAlbumsTitle();
        ArrayList<String> expectedList = new ArrayList<String>(actualList);
        Collections.sort(expectedList);
        Assert.assertEquals(actualList.equals(expectedList), expected, "Verify album titles are sorted alphabetically: ");
        return this;
    }


}
