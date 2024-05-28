//Drop-Off message that calls the shop's dropOff() 

package edu.curtin.oose2024s1.assignment2.message;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class DropOffMsg extends Message
{
    private String owner;

    public DropOffMsg(Shop shop, String owner)
    {
        this.shop = shop;
        this.owner = owner;
    }

    @Override
    public String execute()
    {
        logger.log(Level.INFO, "Drop-Off executed");
        return shop.dropOff(owner);
    }
}