/*  
 *  Provided App.java file that contains main.
 *  Receives messages from provided BikeShopInput.java, and executes them.
 *  Creates a shop object that acts as the bike shop, which messages act upon.
*/

package edu.curtin.oose2024s1.assignment2;
import java.io.*;
import edu.curtin.oose2024s1.assignment2.Shop.Shop;

public class App
{
    public static void main(String[] args)
    {
        File myObj = new File("sim_results.txt"); //Create the save file
        myObj.delete(); //Clear the save file in case it pre-exists

        BikeShopInput inp = new BikeShopInput(); //Seed optional
        
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
                String shopStats;

                shop.notifyObservers(); //notify observers even if no messages are executed
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

                    //append executed message to save file
                    appendStrToFile("sim_results.txt", msg + " " + executedMsg);

                    totalMsgs++;

                    msg = inp.nextMessage();
                }

                shopStats = shop.stats();
                //Apppend shop stats to save file
                appendStrToFile("sim_results.txt", shopStats);
                
                System.out.println(shopStats + printMsgs); //Print shop stats & messages

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
    
        printMsgs = "-------------------------------\n";
        printMsgs += "END OF PROGRAM\n";
        printMsgs += "Total Number of Input Messages: " + totalMsgs;
        printMsgs += "\nTotal Number of Failures: " + failureMsgs;
        printMsgs += "\n-------------------------------";

        System.out.println(printMsgs);
        appendStrToFile("sim_results.txt", printMsgs);
    }

    public static void appendStrToFile(String fileName, String str)
    { //For writing output to the save file
        try 
        {
            // Open given file in append mode by creating an object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
 
            out.write(str); //writing the message to the save file

            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Error when writing to output file: " + e);
        }
    }
}
