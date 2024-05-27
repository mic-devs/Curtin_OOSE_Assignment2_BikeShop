/*
 * Acts as the bike shop.
 * Consists of an Inventory.java object which stores all the bikes.
 * Uses states to determine whether it can accept deliveries, drop-offs, or purchases.
 * Uses a set of observers to update those state patterns, and check bikes in service.
 * Individual observer to check for weekly payday.
 * Accepts messages from App.java, parses them using Message.java
 */

package edu.curtin.oose2024s1.assignment2.Shop;
import java.util.*;
import edu.curtin.oose2024s1.assignment2.Inventory.Inventory;
import edu.curtin.oose2024s1.assignment2.Message.Message;
import edu.curtin.oose2024s1.assignment2.Shop.ShopObservers.*;
import edu.curtin.oose2024s1.assignment2.Shop.ShopStates.*;

public class Shop 
{
    private int money;
    private int day;
    private Inventory inventory;
    private Set<ShopObserver> obs = new HashSet<>();
    private PaydayObserver paydayOb;
    private DeliveryState deliveryState = new DeliveryCAN(); 
    private PurchaseState purchaseState = new PurchaseCAN();
    private DropOffState dropOffState = new DropOffCAN();

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

    public void addObserver(ShopObserver ob)
    {
        obs.add(ob);
    }

    public int getDay()
    {
        return day;
    }

    public int getMoney()
    {
        return money;
    }

    public void payday() //calls the payday observer
    {
        paydayOb.observed();
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public String stats() //toString(s) shop stats and elapses a day
    {
        String toPrint;
        toPrint = "\n***Shop Stats***";
        toPrint += "\nDay: " + day;
        toPrint += "\nBalance: $" + money;
        toPrint += "\nBikes for sale: " + inventory.getAvailable();
        toPrint += "\nBikes being serviced: " + inventory.getServicing().size();
        toPrint += "\nBikes awaiting pick-up: " + inventory.getToPickUp().size();
        toPrint += "\n***Shop Stats***\n\n";
        day++; //elapse a day
        return toPrint;
    }

    public void setupObservers()
    {
        paydayOb = new PaydayObserver(this);
        DeliveryObserver deliverOb = new DeliveryObserver(this);
        deliverOb.setup();
        PurchaseObserver purchaseOb = new PurchaseObserver(this);
        purchaseOb.setup();
        DropOffObserver dropOffOb = new DropOffObserver(this);
        dropOffOb.setup();
        ServicingObserver servicingOb = new ServicingObserver(this);
        servicingOb.setup();
    }

    public void notifyObservers()
    {
        for (ShopObserver ob : obs)
        {
            ob.observed();
        }
    }

    public void setDeliveryState(DeliveryState newState)
    {
        deliveryState = newState;
    }

    public String delivery() 
    {
        return deliveryState.doDelivery(this);
    }

    public void setPurchaseState(PurchaseState newState)
    {
        purchaseState = newState;
    }

    public String purchase()
    {
        return purchaseState.purchase(this);
    }

    public void setDropOffState(DropOffState newState)
    {
        dropOffState = newState;
    }

    public String dropOff(String owner)
    {
        return dropOffState.doDropOff(this, owner, day);
    }

    public String executeMessage(String msg)
    {
        String feedback;

        Message toExec = Message.createMessage(msg, this);
        feedback = toExec.execute();

        return feedback;
    }
}
