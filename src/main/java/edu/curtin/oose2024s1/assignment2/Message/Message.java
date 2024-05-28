//Factory class for parsing messages and creating the respective message object 

package edu.curtin.oose2024s1.assignment2.message;
import java.util.logging.Logger;

import edu.curtin.oose2024s1.assignment2.App;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public abstract class Message 
{
    protected static final Logger logger = Logger.getLogger(App.class.getName());
    protected Shop shop;

    public abstract String execute();

    public static Message createMessage(String msg, Shop inShop) throws InvalidMessageException
    {
        String[] parts = msg.split(" ");
        Message toReturn;

        if (parts[0].equals("DELIVERY"))
        {
            toReturn = new DeliveryMsg(inShop);
            logger.info("DeliveryMsg created");
        }
        else if (parts[0].equals("PURCHASE-IN-STORE")) 
        {
            toReturn = new PurchaseInMsg(inShop);
            logger.info("PurchaseInMsg created");
        }
        else if (parts[0].equals("PURCHASE-ONLINE"))
        {
            toReturn = new PurchaseOnMsg(inShop, parts[1]);
            logger.info("DeliveryMsg created");
        }
        else if (parts[0].equals("DROP-OFF"))
        {
            toReturn = new DropOffMsg(inShop, parts[1]);
            logger.info("DropOffMsg created");
        }
        else if (parts[0].equals("PICK-UP"))
        {
            toReturn = new PickUpMsg(inShop, parts[1]);
            logger.info("PickUpMsg created");
        }
        else
        {
            logger.info("Threw an invalid message exception");
            throw new InvalidMessageException();
        }

        return toReturn;
    }
}
