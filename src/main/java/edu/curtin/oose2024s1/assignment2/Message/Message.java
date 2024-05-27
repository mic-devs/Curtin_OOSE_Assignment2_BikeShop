//Factory class for parsing messages and creating the respective message object 

package edu.curtin.oose2024s1.assignment2.Message;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public abstract class Message 
{
    protected Shop shop;

    public abstract String execute();

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
            toReturn = new PurchaseOnMsg(inShop, parts[1]);
        }
        else if (parts[0].equals("DROP-OFF"))
        {
            toReturn = new DropOffMsg(inShop, parts[1]);
        }
        else if (parts[0].equals("PICK-UP"))
        {
            toReturn = new PickUpMsg(inShop, parts[1]);
        }
        else
        {
            toReturn = new InvalidMsg(inShop);
        }

        return toReturn;
    }

}
