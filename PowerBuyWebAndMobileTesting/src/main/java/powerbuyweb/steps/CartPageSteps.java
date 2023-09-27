package powerbuyweb.steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import powerbuyweb.models.Item;
import powerbuyweb.pages.CartPage;
import powerbuyweb.tests.TestNGRunner;

public class CartPageSteps extends TestNGRunner {
  public CartPageSteps(){
    objCartPage = new CartPage(webUI);
  }

  @Then("I should be to show list of item contain two items were just picked up")
  public void shouldBeToShowListOfItemContainTwoItemsWereJustPickedUp() {
//    String s1 = skuList.get(0);
//    String s2 = skuList.get(1);
    Item i1 = listitems.get(0);
    Item i2 = listitems.get(1);
    assertTrue(objCartPage.shouldBeShowCorrectItemBranchAndName(i1, i2),"Correctly!!!");
  }
}
