//  State where Shop can accept the delivery, and will do so by deducting money,
//  and adding 10 new available bikes to the inventory

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DeliveryCAN implements DeliveryState
{

    @Override
    public String doDelivery(Shop shop) 
    {
        shop.addMoney(-5000); //deduct money
        shop.getInventory().addAvailable(10);; //receive 10 bikes

        return "ACCEPTED";
    }
    
}
