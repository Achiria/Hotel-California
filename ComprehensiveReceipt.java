
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class ComprehensiveReceipt implements ReceiptStrategy
{
    @Override
    public String produce()
    {
        return "User ID: " + HotelCalifornia.currentUser.userid + "\nUser name: " + "HotelCalifornia.currentUser.name" + "\nCost: " + HotelCalifornia.currentUser.getCostTotal();
    }
}
