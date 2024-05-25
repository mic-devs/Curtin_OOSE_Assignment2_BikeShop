package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DeliveryMsg extends Message
{
    public DeliveryMsg (Shop inShop)
    {
        this.type = "DELIVERY";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        shop.getInventory().delivery();
        shop.addMoney(-5000);

        return "Did Delivery";
    }
}
