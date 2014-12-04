import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class ViewCancelFrame extends JFrame
{
//   public static void main(String[] args)
//   {
//      new ViewCancelFrame();
//   }
   
   public ViewCancelFrame(final String currentUser)
   {
      super("View/Cancel Reservations");
      
      setSize(300, 200);
      setResizable(false);
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      WindowListener exitListener = new WindowAdapter() 
      {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                new ReservationsFrame(currentUser);
                dispose();
            }
        };
      addWindowListener(exitListener);
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
