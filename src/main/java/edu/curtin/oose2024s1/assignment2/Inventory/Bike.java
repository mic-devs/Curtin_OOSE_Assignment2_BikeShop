package edu.curtin.oose2024s1.assignment2.Inventory;

public class Bike 
{
    private String owner;
    private int serviceDate; //contains drop-off date for servicing, or 0 if online purchase 

    public Bike(String owner, int serviceDate)
    {
        this.owner = owner;
        this.serviceDate = serviceDate;
    }

    public String getOwner()
    {
        return owner;
    }

    public int getServiceDate()
    {
        return serviceDate;
    }
}
