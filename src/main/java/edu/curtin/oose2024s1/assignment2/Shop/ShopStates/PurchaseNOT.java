package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PurchaseNOT implements PurchaseState
{
    @Override
    public String purchase(Shop shop) 
    {
        return "FAILURE : No bikes left";
    }
    
}