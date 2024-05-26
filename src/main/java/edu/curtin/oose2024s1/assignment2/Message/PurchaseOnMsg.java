package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PurchaseOnMsg extends Message
{
    public PurchaseOnMsg(Shop inShop)
    {
        this.type = "PURCHASEON";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return "PURCHASE-ONLINE YET TO IMPLEMENT";
    }
}