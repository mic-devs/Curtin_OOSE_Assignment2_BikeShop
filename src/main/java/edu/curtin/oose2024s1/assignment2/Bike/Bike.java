package edu.curtin.oose2024s1.assignment2.Bike;

public class Bike 
{
    private String owner;
    //private BikeState state;

    public Bike(String inOwner)
    {
        if (inOwner.equals(null)) //unowned bike
        {
            this.owner = null;
        }
        else
        {
            this.owner = inOwner;
        }
    }
}
