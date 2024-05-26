package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DropOffMsg extends Message
{
    public DropOffMsg(Shop inShop)
    {
        this.type = "PURCHASEON";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return "DROP-OFF YET TO IMPLEMENT";
    }
}