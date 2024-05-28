//  Custom exception class that handles invalid messages from parsing

package edu.curtin.oose2024s1.assignment2.message;

public class InvalidMessageException extends Exception  
{  
    @Override
    public String getMessage()
    {
        return "FAILURE : Invalid Message";
    }
}  