package powerbuyweb.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import powerbuyweb.pages.Home;
import powerbuyweb.tests.TestNGRunner;

public class HomeSteps extends TestNGRunner {
  public HomeSteps(){
    objHome = new Home(webUI);
  }

  @Given("I on the power buy home page")
  public void isOnThePowerBuyHomePage() {
    objHome.objAdvertisementPopup.closePopup();
  }

  @And("I change language of the page to English")
  public void changeLanguageOfThePageToEnglish() {
    objHome.objNavigationBar.changeLanguageToEnglish();
    objHome.objAdvertisementPopup.closePopup();
    objHome.objAdvertisementPopup.closePopup();
    webUI.delayInSecond(5);
  }

  //^[a-zA-Z].*
  @When("I enter <inputValue> into search textbox")
  public void inputValueIntoSearchTextbox(DataTable dataTable) { //searchProductCategory
    List<Map<String, String>> data = dataTable.asMaps();
    String inputValue = data.get(0).get("inputValue");
    objItemList = objHome.objNavigationBar.inputTVToSearchTextbox(inputValue);
  }
}
