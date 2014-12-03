import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeReservation extends JFrame
{
   public static void main(String[] args)
   {
      new MakeReservation();
   }
   
   public MakeReservation()
   {
      super("Reservations");
      
      setSize(380, 100);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
//      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel.setLayout(new GridLayout());
      JButton b1 = new JButton("Make a Reservation");
      JButton b2 = new JButton("View/Cancel a Reservation");
      
      panel.add(b1);
      panel.add(b2);
      
      this.add(panel);
      
      b1.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            InfoForm form = new InfoForm();
            form.setVisible(true);
            dispose();
         }
      });
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
