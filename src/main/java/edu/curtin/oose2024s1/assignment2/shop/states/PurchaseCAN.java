//  State where bike can be purchased from shop, and will do so by removing a bike
//  from the inventory, and receiving $1000

package edu.curtin.oose2024s1.assignment2.shop.states;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class PurchaseCAN implements PurchaseState
{
    @Override
    public String purchase(Shop shop) 
    {
        shop.getInventory().buyBike(); //decrements no. available bikes
        shop.addMoney(1000); //receive $1000 for bike

        return "ACCEPTED";
    }
}
