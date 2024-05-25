package edu.curtin.oose2024s1.assignment2.Message;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public abstract class Message 
{
    protected String type;
    protected Shop shop;

    public abstract String execute();

    public String getType()
    {
        return type;
    }

    public static Message createMessage(String msg, Shop inShop)
    {
        Message toReturn = null;

        if (msg.equals("DELIVERY"))
        {
            toReturn = new DeliveryMsg(inShop);
        }
        else if (msg.equals("PURCHASE-IN-STORE")) 
        {
            toReturn = new PurchaseInMsg(inShop);
        }
        else
        {
            toReturn = new EmptyMsg(inShop);
        }

        return toReturn;
    }

}
