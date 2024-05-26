package edu.curtin.oose2024s1.assignment2;

import java.io.*;

import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class App
{
    public static void main(String[] args)
    {
        BikeShopInput inp = new BikeShopInput(9); //Seed optional
        
        String printMsgs = "";
        int totalMsgs = 0;
        int failureMsgs = 0;

        Shop shop = new Shop(); //Create shop
        shop.setupObservers(); //Setup shop's observers

        try
        {
            while(System.in.available() == 0)
            {
                System.out.println("-------------------------------");
                shop.payday(); //call payday observer ONCE per day ONLY!
                printMsgs = "";
                String msg = inp.nextMessage();

                while(msg != null) //process the message
                {
                    shop.notifyObservers(); //notify observers before executing message

                    printMsgs += msg + " : ";

                    String executedMsg = shop.executeMessage(msg) + "\n";;
                    printMsgs += executedMsg;
                    if (executedMsg.contains("FAILURE"))
                    {
                        failureMsgs++;
                    }

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
        System.out.println("Total Number of Failures: " + failureMsgs);
        System.out.println("-------------------------------");
    }
}
