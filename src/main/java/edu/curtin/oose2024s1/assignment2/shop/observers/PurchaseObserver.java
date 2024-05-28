//Observer that updates the PurchaseState

package edu.curtin.oose2024s1.assignment2.shop.observers;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;
import edu.curtin.oose2024s1.assignment2.shop.states.PurchaseCAN;
import edu.curtin.oose2024s1.assignment2.shop.states.PurchaseNOT;

public class PurchaseObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public PurchaseObserver(Shop shop)
    {
        this.shop = shop;
    }

    @Override
    public void setup() // The observer sets itself up here
    {
        shop.addObserver(this);
    }

    @Override
    public void observed() 
    {
        if (shop.getInventory().getAvailable() > 0)
        {
            shop.setPurchaseState(new PurchaseCAN());
            logger.log(Level.INFO, "PurchaseCAN");
        }
        else
        {
            shop.setPurchaseState(new PurchaseNOT());
            logger.log(Level.INFO, "PurchaseNOT");
        }
    }
    
}
