package powerbuyweb.object_repo;

public class ItemDetailRepo {
  public static final String BTN_ADD_TO_CART = "//button[contains(@id,'btn-addCart')]";
  public static final String TXT_PRODUCT_BRANCH_NAME = "//div[starts-with(@class,'MultipleLineClamp')]//span";
  public static final String TXT_PRODUCT_NAME = "//div[starts-with(@class,'MultipleLineClamp')]//span[starts-with(@id,'lbl-productName')]";
  public static final String TXT_PRODUCT_PRICE = "//div[starts-with(@data-testid,'product-summary-component')]//span[starts-with(@data-testid,'txt-price')]";
  public static final String TXT_PRODUCT_ATTRIBUTE = "//div[starts-with(@class,'hide')]/div[starts-with(@class,'Padding-sc-')]/div[starts-with(@class,'Row__Wrapper')]/div[starts-with(@class,'Col__Column-sc')][1]/div[1]";
  public static final String LBL_ADD_TO_CART_SUCCESS_ALERT = "//div[starts-with(@type,'success') and starts-with(@class,'Alert')]";
}