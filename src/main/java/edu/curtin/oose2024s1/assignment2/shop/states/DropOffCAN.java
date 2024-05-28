//State where Shop can receive a bike for drop-off, and will add it to the inventory

package edu.curtin.oose2024s1.assignment2.shop.states;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class DropOffCAN implements DropOffState
{
    @Override
    public String doDropOff(Shop shop, String owner, int date) 
    {
        shop.getInventory().dropOff(owner, date);

        return "ACCEPTED";
    }
    
}
