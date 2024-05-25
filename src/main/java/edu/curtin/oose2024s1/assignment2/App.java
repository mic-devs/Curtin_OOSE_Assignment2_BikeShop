package edu.curtin.oose2024s1.assignment2;

import java.io.*;

import edu.curtin.oose2024s1.assignment2.Shop.PaydayObserver;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

/**
 * Use this code to get started on Assignment 2. You are free to modify or replace this file as
 * needed (to fulfil the assignment requirements, of course).
 */
public class App
{
    public static void main(String[] args)
    {
        BikeShopInput inp = new BikeShopInput(1); //Seed optional
        Shop shop = new Shop();
        PaydayObserver paydayOb = new PaydayObserver(shop);
        paydayOb.setup();

        try
        {
            while(System.in.available() == 0)
            {
                System.out.println("-------------------------------");
                shop.notifyObservers(); //check for payday
                shop.stats();
                String msg = inp.nextMessage();

                while(msg != null) //process the message
                {
                    System.out.println(msg);
                    msg = inp.nextMessage();
                }

                // Wait 1 second
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    throw new AssertionError(e);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error reading user input");
        }
    }
}
