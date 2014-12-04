import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginRegistration extends JFrame
{
   static JPanel panel = new JPanel();
   
   public static void main(String[] args)
   {
      new LoginRegistration();
   }
   
   public LoginRegistration()
   {
      super("Login/Registration");
      
      setSize(390, 300);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
      
//      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel.setLayout(null);
      JLabel l1 = new JLabel("User ID:");
      final JTextField t1 = new JTextField(20);
      JButton b1 = new JButton("Login");
      
      l1.setBounds(10, 10, 50, 20);
      panel.add(l1);
      t1.setBounds(60, 10, 200, 20);
      panel.add(t1);
      b1.setBounds(270, 10, 80, 20);
      panel.add(b1);
      
 
      JLabel l2 = new JLabel("New User?");
//      panel.setLayout(new GridLayout(1, 0));
      JLabel l3 = new JLabel("Enter an ID:");
      final JTextField t2 = new JTextField(20);
      JButton b2 = new JButton("Register");
      
      l2.setBounds(10, 200, 70, 20);
      panel.add(l2);
      
      l3.setBounds(10, 230, 100, 20);
      panel.add(l3);
      t2.setBounds(80, 230, 200, 20);
      panel.add(t2);
      b2.setBounds(290, 230, 90, 20);
      panel.add(b2);
      
      this.add(panel);
      
      
      b1.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            ArrayList<String> ids = new ArrayList<String>();
            String loginID = t1.getText();
            try
            {
               Scanner s = new Scanner(new File("userIDs.txt"));
               
               while (s.hasNext())
               {
                   ids.add(s.next());
               }
               s.close();
            }
            catch (FileNotFoundException ex)
            {
//               JOptionPane.showMessageDialog(null, "Error.");
            }

            boolean b = false;
            for (String s : ids)
            {
               if (s.equals(loginID))
               {
                  b = true;
                  MakeReservation mR =new MakeReservation();
                  mR.setVisible(true);
                  dispose();
               }
            }  
            if (b == false)
            {
               JOptionPane.showMessageDialog(null, "Invalid ID.");
            }
         }
      });
      
      b2.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            String registrationID = t2.getText();
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("userIDs.txt", true)))) 
            {
               if (!registrationID.isEmpty())
               {
                  out.println(registrationID);
                  JOptionPane.showMessageDialog(null, "Registered.");
               }
            }
            catch (IOException ex) 
            {
    
            }
            dispose();
            new LoginRegistration();
         }
      });

      setLocationRelativeTo(null);
      setVisible(true);
   }
}
