//Observer that updates the DropOffState

package edu.curtin.oose2024s1.assignment2.shop.observers;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;
import edu.curtin.oose2024s1.assignment2.shop.states.DropOffCAN;
import edu.curtin.oose2024s1.assignment2.shop.states.DropOffNOT;

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
            logger.log(Level.INFO, "DropOffCAN");
        }
        else
        {
            shop.setDropOffState(new DropOffNOT());
            logger.log(Level.INFO, "DropOffNOT");
        }
    }
}
