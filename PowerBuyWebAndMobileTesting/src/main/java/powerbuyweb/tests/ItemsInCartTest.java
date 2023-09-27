package powerbuyweb.tests;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Description;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import powerbuyweb.models.Item;
import powerbuyweb.object_repo.ItemDetailRepo;
import powerbuyweb.pages.CartPage;
import powerbuyweb.pages.ItemDetail;

public class ItemsInCartTest extends BaseTest{
  private ItemDetail objItemDetail;
  private CartPage objCartPage;


  public ItemsInCartTest() {
    super();
  }

  @Test(description = "TC001: Items in cart's name match the picked items")
  @Description("Items in cart's name match the picked items")
  public void TC001_Items_in_cart_is_name_match_the_picked_items(Method method){
    logger.info("Test case: " + method.getName());
    objItemDetail = objItemList.chosingOneItem();

    boolean isVisible = objItemDetail.verifyAddToCartButtonVisible();
    while(!isVisible){
      objItemDetail.backToProductListPage();
      objItemDetail = objItemList.chosingOneItem();
      isVisible = objItemDetail.verifyAddToCartButtonVisible();
    }
    String sku1 = objItemDetail.getItemSKUByElementAttribute();
    Item item1 = new Item(objItemDetail.getItemBranch(), objItemDetail.getItemName(),
        objItemDetail.getItemPrice(), sku1);
    listitems.add(item1);
    System.out.println(item1.getBranch() + " | " + item1.getName() + " | " + item1.getPrice());

    objItemDetail.addItemToCart();
    if(webUI.verifyElementPresent(ItemDetailRepo.LBL_ADD_TO_CART_SUCCESS_ALERT)) {
      objItemList = objItemDetail.backToProductListPage();
    }

    objItemList.uncheckTheCheckBox45To55InchesAtLeftMenuScreenSize();
    objItemList.clickToCheckBox56To65InchesAtLeftMenuScreenSize();

    objItemDetail = objItemList.chosingOneItem();
    isVisible = objItemDetail.verifyAddToCartButtonVisible();
    while(!isVisible){
      objItemDetail.backToProductListPage();
      objItemDetail = objItemList.chosingOneItem();
      isVisible = objItemDetail.verifyAddToCartButtonVisible();
    }

    String sku2 = objItemDetail.getItemSKUByElementAttribute();
    Item item2 = new Item(objItemDetail.getItemBranch(), objItemDetail.getItemName(),
        objItemDetail.getItemPrice(), sku2);
    listitems.add(item2);
    System.out.println(item2.getBranch() + " | " + item2.getName() + " | " + item2.getPrice());

    objItemDetail.addItemToCart();
    if(webUI.verifyElementPresent(ItemDetailRepo.LBL_ADD_TO_CART_SUCCESS_ALERT)) {
      objCartPage = objItemDetail.navigateToCartPage();
    }
    assertTrue(objCartPage.shouldBeShowCorrectItem(item1, item2),"Name Correctly!!!");
  }

//  @Test(description = "TC002: Items in cart's price match the picked items")
//  @Description("Items in cart's price match the picked items")
//  public void TC002_Items_in_cart_is_price_match_the_picked_items(Method method) {
//    logger.info("Test case: " + method.getName());
//    Item i1 = listitems.get(0);
//    Item i2 = listitems.get(1);
//    System.out.println("i1: " + i1.getPrice());
//    System.out.println("i2: " + i2.getPrice());
//    assertTrue(objCartPage.shouldBeShowCorrectItemPrice(i1, i2),"Price Correctly!!!");
//  }

}
