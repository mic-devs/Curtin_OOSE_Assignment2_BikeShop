//Delivery message that calls the shop's delivery()

package edu.curtin.oose2024s1.assignment2.message;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class DeliveryMsg extends Message
{
    public DeliveryMsg (Shop inShop)
    {
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        logger.log(Level.INFO, "Delivery executed");
        return shop.delivery();
        
    }
}
