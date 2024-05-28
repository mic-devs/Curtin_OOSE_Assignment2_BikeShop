//State where a bike cannot be purchased from Shop, as none are available

package edu.curtin.oose2024s1.assignment2.shop.states;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class PurchaseNOT implements PurchaseState
{
    @Override
    public String purchase(Shop shop) 
    {
        return "FAILURE : No bikes left";
    }
    
}
