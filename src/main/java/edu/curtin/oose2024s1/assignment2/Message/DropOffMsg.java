//Drop-Off message that calls the shop's dropOff() 

package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

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
        return shop.dropOff(owner);
    }
}