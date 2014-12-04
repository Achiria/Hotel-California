import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoForm extends JFrame
{
//   public static void main(String[] args)
//   {
//      new InfoForm();
//   }
   
   public InfoForm(final String currentUser)
   {
      super("Information Form");
      
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
      
      b1.addActionListener(new ActionListener() 
      {

         @Override
         public void actionPerformed(ActionEvent e) 
         {
            new LuxuriousRoomsFrame(currentUser);
            dispose();
         }
      });
      
      b2.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            new EconomicRoomsFrame(currentUser);
            dispose();
         }
      });
      
      this.add(panel);
      
      setLocationRelativeTo(null);
      setVisible(true);
   }
}
