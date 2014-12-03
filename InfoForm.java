import javax.swing.*;
import java.awt.*;

public class InfoForm extends JFrame
{
   public static void main(String[] args)
   {
      new InfoForm();
   }
   
   public InfoForm()
   {
      super("Information Form");
      
      setSize(300, 200);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
//      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
//      panel.setLayout(new GridLayout());
      panel.setLayout(null);
      
      JLabel l1 = new JLabel("Check-in:");
      JLabel l2 = new JLabel("Check-out:");
      JLabel l3 = new JLabel("Room type:");
      JTextField t1 = new JTextField();
      JTextField t2 = new JTextField();
      
      JButton b1 = new JButton("$200");
      JButton b2 = new JButton("$80");
      
      l1.setBounds(10, 10, 60, 20);
      panel.add(l1);
      l2.setBounds(170, 10, 65, 20);
      panel.add(l2);
      l3.setBounds(10, 100, 65, 20);
      panel.add(l3);
      t1.setBounds(10, 40, 100, 20);
      panel.add(t1);
      t2.setBounds(170, 40, 100, 20);
      panel.add(t2);
      b1.setBounds(80, 100, 90, 30);
      panel.add(b1);
      b2.setBounds(190, 100, 90, 30);
      panel.add(b2);
      
      this.add(panel);
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
