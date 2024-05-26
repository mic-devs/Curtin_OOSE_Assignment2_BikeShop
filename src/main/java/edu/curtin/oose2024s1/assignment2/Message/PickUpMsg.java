package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PickUpMsg extends Message
{
    public PickUpMsg(Shop inShop)
    {
        this.type = "PURCHASEON";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return "PICK-UP YET TO IMPLEMENT";
    }
}