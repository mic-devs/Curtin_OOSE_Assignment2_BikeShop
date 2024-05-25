package edu.curtin.oose2024s1.assignment2.Shop;
import java.util.HashSet;
import java.util.Set;

import edu.curtin.oose2024s1.assignment2.Inventory.Inventory;

public class Shop 
{
    private int money;
    private int day;
    private Inventory inventory;
    private Set<ShopObserver> obs = new HashSet<>();

    public Shop() //Constructor
    {
        this.money = 15000; //Bike Shop starts with $15,000
        this.day = 1; //start at Day 1
        this.inventory = new Inventory(); //initilize an inventory with 50 bikes
    }

    public void addMoney(int amount)
    {
        money += amount; 
    }

    public int getDay()
    {
        return day;
    }

    public void addObserver(ShopObserver ob)
    {
        obs.add(ob);
    }

    public void stats()
    {
        System.out.println("\n***Shop Stats***");
        System.out.println("Day: " + day);
        System.out.println("Balance: $" + money);
        System.out.println("Bikes for sale: " + inventory.getAvailable());
        System.out.println("Bikes being serviced: " + inventory.getServicing());
        System.out.println("Bikes awaiting pick-up: " + inventory.getToPickUp());
        System.out.println("***Shop Stats***\n");
        day++; //elapse a day
    }

    public void notifyObservers()
    {
        for (ShopObserver ob : obs)
        {
            ob.observed();
        }
    }
}
