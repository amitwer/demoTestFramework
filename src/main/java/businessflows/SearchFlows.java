package businessflows;

import org.openqa.selenium.WebDriver;
import selenium.PageObjects.ResultsPage;
import selenium.PageObjects.SearchPage;

public class SearchFlows {
    public static int search(WebDriver driver) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        searchPage.search("How to use selenium?");
        ResultsPage resultsPage = new ResultsPage(driver);
        return resultsPage.getNumOfResults();
    }
}
