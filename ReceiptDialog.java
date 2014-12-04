
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ReceiptDialog extends JFrame 
{
   public ReceiptDialog(final String currentUser)
   {
      super("Receipt Options");
      
      setSize(380, 100);
      setResizable(false);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      JPanel panel = new JPanel();
//      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel.setLayout(new GridLayout());
      JButton b1 = new JButton("Simple Receipt");
      JButton b2 = new JButton("Comphrehensive Receipt");
      
      panel.add(b1);
      panel.add(b2);
      
      this.add(panel);
      
      b1.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            new SimpleReceipt(currentUser);
         }
      });
      
      b2.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            new ComprehensiveReceipt(currentUser);
         }
      });
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
