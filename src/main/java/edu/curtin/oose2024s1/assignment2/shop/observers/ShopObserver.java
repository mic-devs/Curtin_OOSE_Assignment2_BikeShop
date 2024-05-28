//Observer interface for Shop observers

package edu.curtin.oose2024s1.assignment2.shop.observers;
import java.util.logging.Logger;

import edu.curtin.oose2024s1.assignment2.App;

public interface ShopObserver 
{
    static final Logger logger = Logger.getLogger(App.class.getName());

    public void setup();
    public void observed();
}
