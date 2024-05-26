package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DropOffCAN implements DropOffState
{
    @Override
    public String doDropOff(Shop shop, String owner, int date) 
    {
        shop.getInventory().dropOff(owner, date);

        return "ACCEPTED";
    }
    
}
