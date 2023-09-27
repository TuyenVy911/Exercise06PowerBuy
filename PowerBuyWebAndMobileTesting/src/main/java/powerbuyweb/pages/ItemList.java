package powerbuyweb.pages;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import powerbuyweb.object_repo.FilterItemRepo;
import powerbuyweb.object_repo.HeaderRepo;
import powerbuyweb.object_repo.ItemListRepo;
import powerbuyweb.utils.keywords.WebUI;

public class ItemList extends BasePage{
  public ItemList(WebUI webUI) {
    super(webUI);
  }

  @Step("Click to checkbox 45 to 55 inches at left menu screen size")
  public ItemList clickToCheckBox45To55InchesAtLeftMenuScreenSize(){
    webUI.scrollToElementCenter(FilterItemRepo.TXT_SCREEN_SIZE);
    webUI.clickJS(FilterItemRepo.BTN_44TO55_INCHES);
    webUI.delayInSecond(5);
    return new ItemList(webUI);
  }
  @Step("Unpick the checkbox 45 to 55 inches at left menu screen size")
  public ItemList uncheckTheCheckBox45To55InchesAtLeftMenuScreenSize(){
    webUI.scrollToElementCenter(FilterItemRepo.TXT_SCREEN_SIZE);
    webUI.clickJS(FilterItemRepo.BTN_44TO55_INCHES);
    webUI.delayInSecond(10);
    return new ItemList(webUI);
  }


  @Step("Click to checkbox 56 to 65 inches at left menu screen size")
  public ItemList clickToCheckBox56To65InchesAtLeftMenuScreenSize(){
    webUI.scrollToElementCenter(FilterItemRepo.TXT_SCREEN_SIZE);
    webUI.clickJS(FilterItemRepo.BTN_56TO65_INCHES);
    webUI.delayInSecond(5);
    return new ItemList(webUI);
  }

  @Step("Unpick the checkbox 56 to 65 inches at left menu screen size")
  public ItemList uncheckTheCheckBox56To65InchesAtLeftMenuScreenSize(){
    webUI.scrollToElementCenter(FilterItemRepo.TXT_SCREEN_SIZE);
    webUI.clickJS(FilterItemRepo.BTN_44TO55_INCHES);
    webUI.delayInSecond(5);
    return new ItemList(webUI);
  }



  @Step("Click item LG Nanocell 55 inches")
  public ItemDetail clickItemLGNanocell55Inches(){
    webUI.scrollToElementCenter(HeaderRepo.LNK_ITEM_LG_NANOCELL_55_INCHES);
    webUI.clickJS(HeaderRepo.LNK_ITEM_LG_NANOCELL_55_INCHES);
    webUI.delayInSecond(5);
    return new ItemDetail(webUI);
  }

  @Step("Click item LG Nanocell 65 inches")
  public ItemDetail clickItemLGNanocell65Inches(){
    webUI.scrollToElementCenter(HeaderRepo.LNK_ITEM_LG_NANOCELL_65_INCHES);
    webUI.clickJS(HeaderRepo.LNK_ITEM_LG_NANOCELL_65_INCHES);
    webUI.delayInSecond(5);
    return new ItemDetail(webUI);
  }

  @Step("Uncheck the checkbox 45 to 55 inches screen size")
  public ItemList uncheck45To55InchesScreenSize(){
    webUI.clickElement(FilterItemRepo.BTN_44TO55_INCHES);
    webUI.delayInSecond(5);
    return new ItemList(webUI);
  }

  public ItemDetail chosingOneItem() {
    List<WebElement> listItems = webUI.findElements(ItemListRepo.LNK_ITEMS);
//    int random_index = (int)Math.floor(Math.random() * listItems.size());
    int random_index = (int)Math.floor(Math.random() * 7);
    //int random_index = 9;
    System.out.println("Random index: " + random_index);
    webUI.scrollToElementCenter(listItems.get(random_index));
    webUI.takeScreenShotAndHighLightElement(listItems.get(random_index));
    webUI.clickUsingActions(listItems.get(random_index));
//    boolean isVisible = webUI.waitForElementPresent(listItems.get(random_index));
//    while (!isVisible) {
//      webUI.clickUsingActions(listItems.get(random_index));
//      isVisible = webUI.waitForElementPresent(listItems.get(random_index));
//    }
    webUI.delayInSecond(5);
    return new ItemDetail(webUI);
  }

//  public ItemDetail chosingOneItemHasScreenSize56To65(int index) {
//    List<WebElement> listItems2 = webUI.findElements(HomePageRepo.LNK_ITEMS);
//    webUI.delayInSecond(4);
//    webUI.scrollToElementCenter(listItems2.get(index));
//    webUI.takeScreenShotAndHighLightElement(listItems2.get(index));
//    webUI.clickUsingActions(listItems2.get(index));
//    webUI.delayInSecond(5);
//    return new ItemDetail(webUI);
//  }
}
