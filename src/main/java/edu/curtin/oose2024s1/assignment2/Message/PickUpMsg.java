package edu.curtin.oose2024s1.assignment2.Message;

import java.util.ArrayList;

import edu.curtin.oose2024s1.assignment2.Inventory.Bike;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class PickUpMsg extends Message
{
    private String owner;

    public PickUpMsg(Shop shop, String owner)
    {
        this.shop = shop;
        this.owner = owner;
    }

    @Override
    public String execute()
    {
        String feedback = "PICK-UP yet to be implemented";
        Bike found = null;

        ArrayList<Bike> pickups = shop.getInventory().getToPickUp();

        for (Bike i : pickups)
        {
            if(i.getOwner().equals(owner))
            {
                found = i; //Found owner's bike for pickup
                feedback = "ACCEPTED";
            }
        }

        if (found != null) //Bike was found
        {
            pickups.remove(found); //Remove bike from pickups

            if (found.getServiceDate() != 0) //check if bike was a drop-off
            {
                shop.addMoney(100); //get $100 for servicing the bike
            }
        }
        else //Bike not found in pickups
        {
            ArrayList<Bike> servicing = shop.getInventory().getServicing();
            for (Bike i : servicing) //Search for bike in servicing
            {
                if(i.getOwner().equals(owner)) //Found bike, still in service
                {
                    feedback = "FAILURE : Bike not ready";
                }
            }

            if(!feedback.equals("FAILURE : Bike not ready")) //No bike at all in shop
            {
                feedback = "FAILURE : No bike matching customer email";
            }
        }

        return feedback;
    }
}