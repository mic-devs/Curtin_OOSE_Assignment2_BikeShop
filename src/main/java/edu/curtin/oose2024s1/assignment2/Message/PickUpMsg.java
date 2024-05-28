//  Pick-Up message to search Inventory for a given bike,
//  and notifies the caller if bike cannot be retrieved and why.

package edu.curtin.oose2024s1.assignment2.message;

import java.util.ArrayList;
import java.util.logging.Level;

import edu.curtin.oose2024s1.assignment2.inventory.Bike;
import edu.curtin.oose2024s1.assignment2.shop.Shop;

public class PickUpMsg extends Message
{
    private String owner;

    public PickUpMsg(Shop shop, String owner)
    {
        this.shop = shop;
        this.owner = owner;
    }

    @SuppressWarnings("PMD.LooseCoupling") //ArrayList is needed for use-case
    @Override
    public String execute()
    {
        String feedback = "";
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
            logger.log(Level.INFO, "Pick Up executed");
        }
        else //Bike not found in pickups
        {
            ArrayList<Bike> servicing = shop.getInventory().getServicing();
            for (Bike i : servicing) //Search for bike in servicing
            {
                if(i.getOwner().equals(owner)) //Found bike, still in service
                {
                    feedback = "FAILURE : Bike not ready";
                    logger.log(Level.INFO, "Drop-Off Failed, Bike unready");
                }
            }

            if(!feedback.equals("FAILURE : Bike not ready")) //No bike at all in shop
            {
                feedback = "FAILURE : No bike matching customer email";
                logger.log(Level.INFO, "Drop-Off Failed, Bike non-existent");
            }
        }

        return feedback;
    }
}