//A state interface to determine if Shop can or cannot receive a delivery

package edu.curtin.oose2024s1.assignment2.shop.states;

import edu.curtin.oose2024s1.assignment2.shop.Shop;

public interface DeliveryState 
{
    public String doDelivery(Shop inShop);
}
