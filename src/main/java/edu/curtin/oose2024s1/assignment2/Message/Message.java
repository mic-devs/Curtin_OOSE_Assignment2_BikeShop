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
        String[] parts = msg.split(" ");
        Message toReturn;

        if (parts[0].equals("DELIVERY"))
        {
            toReturn = new DeliveryMsg(inShop);
        }
        else if (parts[0].equals("PURCHASE-IN-STORE")) 
        {
            toReturn = new PurchaseInMsg(inShop);
        }
        else if (parts[0].equals("PURCHASE-ONLINE"))
        {
            toReturn = new PurchaseOnMsg(inShop);
        }
        else if (parts[0].equals("DROP-OFF"))
        {
            toReturn = new DropOffMsg(inShop);
        }
        else if (parts[0].equals("PICK-UP"))
        {
            toReturn = new DropOffMsg(inShop);
        }
        else
        {
            toReturn = new InvalidMsg(inShop);
        }

        return toReturn;
    }

}
