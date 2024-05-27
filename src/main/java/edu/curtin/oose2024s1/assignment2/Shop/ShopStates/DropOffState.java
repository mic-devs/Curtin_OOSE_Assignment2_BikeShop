//State interface to determine if Shop can or cannot receive a bike for Drop-Off (servicing)

package edu.curtin.oose2024s1.assignment2.Shop.ShopStates;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public interface DropOffState 
{
    public String doDropOff(Shop shop, String owner, int date);
}
