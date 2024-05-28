//  Purchase-Online message calls shop's purchase(),
//  and inventory's onlineBike() to put the bike for pick-up

package edu.curtin.oose2024s1.assignment2.message;

import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

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
        logger.log(Level.INFO, "Purchase executed, bike added to pick-up");
        shop.getInventory().onlineBike(owner);
        return shop.purchase();
    }
}