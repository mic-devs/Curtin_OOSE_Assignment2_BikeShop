//A state where shop cannot receive delivery, and will inform caller why so

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DeliveryNOT implements DeliveryState
{
    @Override
    public String doDelivery(Shop shop) 
    {
        String feedback; //Notify message that delivery failed and why

        if (shop.getMoney() < 10000 && shop.getInventory().getAllBikes() <= 90)
        {
            feedback = "FAILURE : Not enough cash";
        }
        else if (shop.getMoney() >= 10000 && shop.getInventory().getAllBikes() > 90)
        {
            feedback = "FAILURE : Not enough space";
        }
        else
        {
            feedback = "FAILURE : Not enough cash & space";
        }

        return feedback;
    }
    
}