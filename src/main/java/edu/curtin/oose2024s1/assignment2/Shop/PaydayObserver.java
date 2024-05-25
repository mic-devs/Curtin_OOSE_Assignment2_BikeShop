package edu.curtin.oose2024s1.assignment2.Shop;

public class PaydayObserver implements ShopObserver
{
    private Shop shop; // Back reference to the subject

    public PaydayObserver(Shop inShop) // The observer sets itself up here
    {
        this.shop = inShop;
    }

    public void setup()
    {
        shop.addObserver(this);
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
    
}
