package edu.curtin.oose2024s1.assignment2.Shop.ShopObservers;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;
import edu.curtin.oose2024s1.assignment2.Shop.ShopStates.DropOffCAN;
import edu.curtin.oose2024s1.assignment2.Shop.ShopStates.DropOffNOT;

public class DropOffObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public DropOffObserver(Shop inShop) 
    {
        this.shop = inShop;
    }

    @Override
    public void setup() // The observer sets itself up here
    {
        shop.addObserver(this);
    }

    @Override
    public void observed() 
    {
        if (shop.getInventory().getAllBikes() < 100)
        {
            shop.setDropOffState(new DropOffCAN());
        }
        else
        {
            shop.setDropOffState(new DropOffNOT());
        }
    }
}
