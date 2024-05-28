//  Observer that checks on bikes in service, and moves them to pick-up
//  if it's been two days since drop-off.

package edu.curtin.oose2024s1.assignment2.shop.observers;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

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
        logger.log(Level.INFO, "Executed inventory's serviceBikes()");
    }
}


