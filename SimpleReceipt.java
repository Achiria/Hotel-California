import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class SimpleReceipt extends JFrame implements ReceiptStrategy
{
    public SimpleReceipt()
    {
        super("Simple Receipt");

        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public String produce()
    {
        String toReturn = "";
        
        toReturn += "User ID: " + HotelCalifornia.currentUser.userid + "\n" + "User name: " + HotelCalifornia.currentUser.name
    }
}
