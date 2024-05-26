package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DeliveryMsg extends Message
{
    public DeliveryMsg (Shop inShop)
    {
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return shop.delivery();
    }
}
