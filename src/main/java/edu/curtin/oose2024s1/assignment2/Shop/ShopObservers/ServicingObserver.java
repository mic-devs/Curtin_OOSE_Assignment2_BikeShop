package edu.curtin.oose2024s1.assignment2.Shop.ShopObservers;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class ServicingObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public ServicingObserver(Shop inShop) 
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
        shop.getInventory().serviceBikes(shop.getDay());
    }
}


