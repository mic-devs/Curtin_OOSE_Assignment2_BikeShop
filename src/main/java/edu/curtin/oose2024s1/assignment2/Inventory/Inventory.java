package edu.curtin.oose2024s1.assignment2.Inventory;
import java.util.HashMap;

import edu.curtin.oose2024s1.assignment2.Bike.Bike;

public class Inventory 
{
    private int available; //no. of bikes available to purchase
    private HashMap<String, Bike> servicing; //stores bikes being serviced
    private HashMap<String, Bike> toPickUp; //stores bikes awaiting pick-up

    public Inventory()
    {
        this.available = 50; //inventory always starts with 50 bikes available
        this.servicing = new HashMap<>();
        this.toPickUp = new HashMap<>();
    }

    public int getAllBikes()
    {
        int allBikes = available + servicing.size() + toPickUp.size();
        return allBikes;
    }

    public int getAvailable()
    {
        return available;
    }

    public int getServicing()
    {
        return servicing.size();
    }

    public int getToPickUp()
    {
        return toPickUp.size();
    }

    public void delivery()
    {
        available += 10;
    }

    public void buyBikeInStore()
    {
        available--;
    }

    public void buyBikeOnline(String owner)
    {
        available--;
        Bike newBike = new Bike(owner);
        toPickUp.put(owner, newBike);
    }
}
