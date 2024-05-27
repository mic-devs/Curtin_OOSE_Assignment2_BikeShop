package edu.curtin.oose2024s1.assignment2.Inventory;
import java.util.ArrayList;

public class Inventory 
{
    private int available; //no. of bikes available to purchase
    private ArrayList<Bike> servicing; //stores bikes being serviced
    private ArrayList<Bike> toPickUp; //stores bikes awaiting pick-up

    public Inventory()
    {
        this.available = 50; //inventory always starts with 50 bikes available
        this.servicing = new ArrayList<Bike>();
        this.toPickUp = new ArrayList<Bike>();
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

    public void addAvailable(int add)
    {
        available += add;
    }

    public ArrayList<Bike> getServicing()
    {
        return servicing;
    }

    public ArrayList<Bike> getToPickUp()
    {
        return toPickUp;
    }

    public void buyBike() //Regardless of online or offline, will decrement available bikes
    {
        available--;
    }

    public void onlineBike(String owner) //add online bought bike to pick-up
    {
        //0 for service-date meaning bike was purchased online, not drop-off
        Bike newBike = new Bike(owner, 0);
        toPickUp.add(newBike); 
    }

    public void serviceBikes(int date) //add serviced bike to pick-up
    {
        ArrayList<Bike> toRemove = new ArrayList<Bike>();

        for (Bike i : servicing) //check every bike
        {
            if ((date - i.getServiceDate()) == 2)
            {
                toPickUp.add(i); //add the serviced bike to pick-up
                toRemove.add(i);
            }
        }

        for (Bike i : toRemove)
        {
            servicing.remove(i); //remove the serviced bikes from servicing
        }
    }

    public void dropOff(String owner, int date)
    {
        Bike newBike = new Bike(owner, date);
        servicing.add(newBike);
    }
}
