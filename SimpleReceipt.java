import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class SimpleReceipt implements ReceiptStrategy
{
    @Override
    public String produce()
    {    
        String toReturn = "";
        toReturn = "User ID: " + HotelCalifornia.currentUser.userid + "\nUser name: " + HotelCalifornia.currentUser.userid + HotelCalifornia.currentUser.tempEvents.stream().map((event) -> "\nRoom: " + event.getRoom() + "\n    Date: " + event.getCheckin().toString() + " - " + event.getCheckout().toString()).reduce(toReturn, String::concat) + "\nCost: " + HotelCalifornia.currentUser.getCostTemp();     
        return toReturn;
    }
}
