//State interface to determine if Shop can or cannot receive a bike for Drop-Off (servicing)

package edu.curtin.oose2024s1.assignment2.shop.states;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public interface DropOffState 
{
    public String doDropOff(Shop shop, String owner, int date);
}
