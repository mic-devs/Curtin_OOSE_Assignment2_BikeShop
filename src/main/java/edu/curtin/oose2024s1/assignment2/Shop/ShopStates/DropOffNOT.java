//State where shop cannot receive a bike for drop-off due to lack of space

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class DropOffNOT implements DropOffState
{
    @Override
    public String doDropOff(Shop shop, String owner, int date) 
    {
        return "FAILURE : Not enough space";
    }
}
