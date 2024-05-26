package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class InvalidMsg extends Message
{
    public InvalidMsg(Shop inShop)
    {
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return "FAILURE : Invalid Message";
    }
}
