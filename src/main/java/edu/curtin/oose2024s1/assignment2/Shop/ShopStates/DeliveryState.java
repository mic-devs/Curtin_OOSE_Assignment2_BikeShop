//A state interface to determine if Shop can or cannot receive a delivery

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public interface DeliveryState 
{
    public String doDelivery(Shop inShop);
}
