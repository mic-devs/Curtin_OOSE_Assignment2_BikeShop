package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public interface DropOffState 
{
    public String doDropOff(Shop shop, String owner, int date);
}
