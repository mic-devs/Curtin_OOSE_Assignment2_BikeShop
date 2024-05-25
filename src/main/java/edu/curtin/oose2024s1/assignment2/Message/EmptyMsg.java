package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class EmptyMsg extends Message
{
    public EmptyMsg(Shop inShop)
    {
        this.type = "EMPTY";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return "Empty Execution";
    }
}
