//State interface to determine whether a bike can be purchased from the shop or not

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public interface PurchaseState 
{
    public String purchase(Shop shop);
}
