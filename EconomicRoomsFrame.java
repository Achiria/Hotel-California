import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class EconomicRoomsFrame extends JFrame
{
//   public static void main(String[] args)
//   {
//      new EconomicRoomsFrame("test");
//   }
   
   public EconomicRoomsFrame(final String currentUser)
   {
      super("Available Economic Rooms");
      
      setSize(400, 400);
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
      
      JPanel panel = new JPanel();
      panel.setLayout(null);
      
      JTextArea ta = new JTextArea("Available Rooms");
      JScrollPane scrollPane = new JScrollPane(ta);
      scrollPane.setBounds(10, 10, 150, 350);
      
      JButton b1 = new JButton("Confirm");
      JButton b2 = new JButton("Transaction Done");
      
      b1.setBounds(165, 315, 80, 40);
      b2.setBounds(250, 315, 135, 40);
      
      panel.add(b1);
      panel.add(b2);
      panel.add(scrollPane);
      
      this.add(panel);
      
      b2.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            new ReceiptDialog(currentUser);
         }
      });
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
