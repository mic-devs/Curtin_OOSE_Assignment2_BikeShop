package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PurchaseCAN implements PurchaseState
{
    @Override
    public String purchase(Shop shop) 
    {
        shop.getInventory().buyBikeInStore(); //decrements no. available bikes
        shop.addMoney(1000); //receive $1000 for bike

        return "ACCEPTED";
    }
}
