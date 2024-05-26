package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PurchaseInMsg extends Message
{
    public PurchaseInMsg(Shop inShop)
    {
        this.type = "PURCHASEIN";
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        return shop.purchase();
    }
}
