//Observer checks if it's payday (every 7th day), and pays the shopkeeper accordingly

package edu.curtin.oose2024s1.assignment2.Shop.ShopObservers;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PaydayObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public PaydayObserver(Shop inShop)
    {
        this.shop = inShop;
    }

    @Override
    public void observed() 
    {
        if (shop.getDay() % 7 == 0)
        {
            shop.addMoney(-1000);
            System.out.println("Shopkeeper paid $1000 weekly wage!");
        }
    }
    
    public void setup()
    {
        //Unused method from interface, payday observer should NOT be added to Shop's obs set
    }
}
