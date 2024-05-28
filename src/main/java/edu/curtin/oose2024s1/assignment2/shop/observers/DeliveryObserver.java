//Observer that updates the DeliveryState

package edu.curtin.oose2024s1.assignment2.shop.observers;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;
import edu.curtin.oose2024s1.assignment2.shop.states.DeliveryCAN;
import edu.curtin.oose2024s1.assignment2.shop.states.DeliveryNOT;

public class DeliveryObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public DeliveryObserver(Shop inShop) 
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
        if (shop.getInventory().getAllBikes() <= 90 && shop.getMoney() >= 10000)
        { //check if shop has enough money, and inventory has space
            shop.setDeliveryState(new DeliveryCAN());
            logger.log(Level.INFO, "DeliveryCAN");
        }
        else
        {
            shop.setDeliveryState(new DeliveryNOT());
            logger.log(Level.INFO, "DeliveryNOT");
        }
    }
    
}
