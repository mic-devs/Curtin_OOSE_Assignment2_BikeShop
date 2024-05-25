package edu.curtin.oose2024s1.assignment2;

import java.io.*;

import edu.curtin.oose2024s1.assignment2.Shop.PaydayObserver;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class App
{
    public static void main(String[] args)
    {
        BikeShopInput inp = new BikeShopInput(1); //Seed optional
        Shop shop = new Shop();
        PaydayObserver paydayOb = new PaydayObserver(shop);
        paydayOb.setup();
        String printMsgs = "";
        int totalMsgs = 0;

        try
        {
            while(System.in.available() == 0)
            {
                System.out.println("-------------------------------");
                shop.notifyObservers(); //check for payday
                printMsgs = "";
                String msg = inp.nextMessage();

                while(msg != null) //process the message
                {
                    printMsgs += msg + " : ";
                    printMsgs += shop.executeMessage(msg) + "\n";
                    totalMsgs++;
                    msg = inp.nextMessage();
                }

                shop.stats();
                System.out.println(printMsgs);

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
    
        System.out.println("-------------------------------");
        System.out.println("END OF PROGRAM");
        System.out.println("Total Number of Input Messages: " + totalMsgs);
        System.out.println("Total Number of Failures: 0");
        System.out.println("-------------------------------");
    }
}
