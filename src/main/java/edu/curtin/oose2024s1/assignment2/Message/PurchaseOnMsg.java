package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PurchaseOnMsg extends Message
{
    private String owner;

    public PurchaseOnMsg(Shop inShop, String owner)
    {
        this.shop = inShop;
        this.owner = owner;
    }

    @Override
    public String execute()
    {
        shop.getInventory().onlineBike(owner);
        return shop.purchase();
    }
}