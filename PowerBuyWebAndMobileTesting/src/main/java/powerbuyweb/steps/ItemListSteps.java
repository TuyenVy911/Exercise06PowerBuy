package powerbuyweb.steps;

import io.cucumber.java.en.And;
import powerbuyweb.models.Item;
import powerbuyweb.pages.ItemList;
import powerbuyweb.tests.TestNGRunner;

public class ItemListSteps extends TestNGRunner {
  public ItemListSteps(){
    objItemList = new ItemList(webUI);
  }


  @And("I filter all item to {int} to {int} inches")
  public void filterAllItemToToInches(int arg0, int arg1) {
    objItemList.clickToCheckBox45To55InchesAtLeftMenuScreenSize();
  }

  @And("I choose first item to add to cart")
  public void chooseFirstItemToAddToCart() {
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
    System.out.println(item1.getBranch() + " | " + item1.getName() + " | " + item1.getPrice());
    skuList.add(sku1);
    listitems.add(item1);
    objItemDetail.addItemToCart();
    webUI.delayInSecond(12);
    objItemList = objItemDetail.backToProductListPage();
  }

  @And("I change filter item to {int} to {int} inches")
  public void changeFilterItemToToInches(int arg0, int arg1) {
    objItemList.uncheckTheCheckBox45To55InchesAtLeftMenuScreenSize();
    objItemList.clickToCheckBox56To65InchesAtLeftMenuScreenSize();
  }

  @And("I choose second item to add to cart")
  public void chooseSecondItemToAddToCart() {
    objItemDetail = objItemList.chosingOneItem();
    boolean isVisible = objItemDetail.verifyAddToCartButtonVisible();
    while(!isVisible){
      objItemDetail.backToProductListPage();
      objItemDetail = objItemList.chosingOneItem();
      isVisible = objItemDetail.verifyAddToCartButtonVisible();
    }
    String sku2 = objItemDetail.getItemSKUByElementAttribute();
    Item item2 = new Item(objItemDetail.getItemBranch(), objItemDetail.getItemName(),
        objItemDetail.getItemPrice(), sku2);
    System.out.println(item2.getBranch() + " | " + item2.getName() + " | " + item2.getPrice());
    skuList.add(sku2);
    listitems.add(item2);
    objItemDetail.addItemToCart();
  }

  @And("I navigate to cart page")
  public void navigateToCartPage() {
    objCartPage = objItemDetail.navigateToCartPage();
  }

}
