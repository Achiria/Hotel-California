import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class AdminCalendarFrame extends JFrame
{
//   public static void main(String[] args)
//   {
//      new AdminCalendarFrame();
//   }
   
   public AdminCalendarFrame()
   {
      super("Admin");
      
      setSize(500, 500);
      setResizable(false);
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      WindowListener exitListener = new WindowAdapter() 
      {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                new LoginRegistration();
                dispose();
            }
        };
      addWindowListener(exitListener);
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
