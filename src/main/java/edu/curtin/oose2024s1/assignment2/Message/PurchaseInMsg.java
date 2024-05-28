//Purchase-In-Store message calls shop's purchase()

package edu.curtin.oose2024s1.assignment2.message;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class PurchaseInMsg extends Message
{
    public PurchaseInMsg(Shop inShop)
    {
        this.shop = inShop;
    }

    @Override
    public String execute()
    {
        logger.log(Level.INFO, "Purchase executed");
        return shop.purchase();
    }
}
