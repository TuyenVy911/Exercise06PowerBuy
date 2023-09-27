package powerbuyweb.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import powerbuyweb.models.Item;
import powerbuyweb.object_repo.CartPageRepo;
import powerbuyweb.utils.keywords.WebUI;

public class CartPage extends BasePage{

  public CartPage(WebUI webUI) {
    super(webUI);
  }
  public boolean shouldBeShowCorrectSKUID(String sku1, String sku2) {
    List<WebElement> listSKU = webUI.findElements(CartPageRepo.LBL_SKU_NUMBER);
    int count = 0;
    for(int i = 0; i < listSKU.size(); i++){
      String text = (String) webUI.executeJavascript("return arguments[0].innerText;",listSKU.get(i));
      while(text.isBlank()){
        text = webUI.getElementText(listSKU.get(i));
      }
      if(text.equals(sku1)){
        count++;
      }
      if(text.equals(sku2)){
        count++;
      }
    }
    if(count == listSKU.size()){
      return true;
    }
    return false;
  }

  public boolean shouldBeShowCorrectItemBranch(Item item1, Item item2) {
    List<WebElement> listBranchName = webUI.findElements(CartPageRepo.LBL_PRODUCT_BRANCH_NAME);
    int count = 0;
    for(int i = 0; i < listBranchName.size(); i++){
      String text = (String) webUI.executeJavascript("return arguments[0].innerText;",listBranchName.get(i));
      while(text.isBlank()){
        text = webUI.getElementText(listBranchName.get(i));
      }
      if(text.equals(item1.getBranch())){
        count++;
      }
      if(text.equals(item2.getBranch())){
        count++;
      }
    }
    if(count == listBranchName.size()){
      return true;
    }
    return false;
  }

  public boolean shouldBeShowCorrectItemBranchAndName(Item item1, Item item2) {
    List<WebElement> listItemName = webUI.findElements(CartPageRepo.LBL_PRODUCT_NAME);
    int count = 0;
    for(int i = 0; i < listItemName.size(); i++){
      String text = (String) webUI.executeJavascript("return arguments[0].innerText;",listItemName.get(i));
//      String text = webUI.getElementTextByMethodGetText(listItemName.get(i));
      System.out.println("item name: " + text);
      while(text.isBlank()){
        text = webUI.getElementText(listItemName.get(i));
      }
      if(text.equals(item1.getBranch() + item1.getName())){
        count++;
      }
      if(text.equals(item2.getBranch() + item2.getName())){
        count++;
      }
    }
    if(count == listItemName.size()){
      return true;
    }
    return false;
  }

  public boolean shouldBeShowCorrectItemPrice(Item item1, Item item2) {
    List<WebElement> listItemPrice = webUI.findElements(CartPageRepo.LBL_PRODUCT_PRICE);
    int count = 0;
    for(int i = 0; i < listItemPrice.size(); i++){
      String text = (String) webUI.executeJavascript("return arguments[0].innerText;",listItemPrice.get(i));
      System.out.println("item price: " + text);
      int tmp = text.length();
      String price = text.substring(1, tmp);
      System.out.println("price: " + price);
      while(text.isBlank()){
        text = webUI.getElementText(listItemPrice.get(i));
      }
      if(price.equals(item1.getPrice())){
        count++;
      }
      if(price.equals(item2.getPrice())){
        count++;
      }
    }
    if(count == listItemPrice.size()){
      return true;
    }
    return false;
  }
  public boolean shouldBeShowCorrectItem(Item item1, Item item2) {
    List<WebElement> lstItems = webUI.findElements(CartPageRepo.LBL_PRODUCT_CONTAINER);
    int count = 0;
    for(int i = 0; i < lstItems.size(); i++){
      WebElement lblName = webUI.findElementWithParam(CartPageRepo.LBL_PRODUCT_NAME2,
          String.valueOf(i+1), 10);
      WebElement lblPrice = webUI.findElementWithParam(CartPageRepo.LBL_PRODUCT_PRICE2,
          String.valueOf(i+1), 10);
      System.out.println("Name: " + webUI.getElementText(lblName));
      System.out.println("Price: " + webUI.getElementText(lblPrice));
      String iname = webUI.getElementText(lblName);
      String tmpPrice = webUI.getElementText(lblPrice);
      int priceLength = tmpPrice.length();
      String iprice = tmpPrice.substring(1, priceLength);
      if(iname.equals(item1.getBranch() + item1.getName()) && iprice.equals(item1.getPrice())){
        count++;
      }
      if(iname.equals(item2.getBranch() + item2.getName()) && iprice.equals(item2.getPrice())){
        count++;
      }
    }
    if(count == lstItems.size()){
      return true;
    }
    return false;
  }

}
