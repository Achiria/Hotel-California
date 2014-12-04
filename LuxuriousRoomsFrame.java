import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LuxuriousRoomsFrame extends JFrame
{
   public static void main(String[] args)
   {
      new LuxuriousRoomsFrame("test");
   }
   
   public LuxuriousRoomsFrame(final String currentUser)
   {
      super("Available Luxurious Rooms");
      
      setSize(400, 280);
      setResizable(false);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
//      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//      WindowListener exitListener = new WindowAdapter() 
//      {
//         @Override
//         public void windowClosing(WindowEvent e) 
//         {
//            new ReservationsFrame(currentUser);
//            dispose();
//         }
//      };
//      addWindowListener(exitListener);
      
      JPanel panel = new JPanel();
      panel.setLayout(null);
      
//      Integer luxuriousRooms[] = new Integer[10];
//      for (int i = 0; i < luxuriousRooms.length; i++)
//      {
//         luxuriousRooms[i] = i + 11;
//      }
      int initialSize = 10;
      
//      final ArrayList<Integer> luxuriousRoomsList = new ArrayList<>();
//      for (int i = 0; i < initialSize; i++)
//      {
//         luxuriousRoomsList.add(i + 11);
//      }
//      Integer luxuriousRooms[] = new Integer[10];
//      for (int i = 0; i < luxuriousRooms.length; i++)
//      {
//         luxuriousRooms[i] = luxuriousRoomsList.get(i);
//      }
      
      Integer luxuriousRooms[] = new Integer[10];
      for (int i = 0; i < luxuriousRooms.length; i++)
      {
         luxuriousRooms[i] = i + 11;
      }
//      String luxuriousRooms[] = new String[10];
//      for (int i = 0; i < luxuriousRooms.length; i++)
//      {
//          luxuriousRooms[i] = Integer.toString(i + 11);
//      }
      final JList<Integer> jlist = new JList<>(luxuriousRooms);
      jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      JScrollPane scrollPane = new JScrollPane(ta);
//      scrollPane.setBounds(10, 10, 150, 350);
      jlist.setBounds(10, 60, 150, 180);
      
//      for (int i : luxuriousRooms)
//          System.out.println(i);
//      JComboBox<Integer> jcb = new JComboBox<>(luxuriousRooms);
      
      JButton b1 = new JButton("Confirm");
      JButton b2 = new JButton("Transaction Done");
      
      JLabel l1 = new JLabel("Available Luxurious Rooms");
      JLabel l2 = new JLabel("Select a room number:");
      
      b1.setBounds(165, 200, 80, 40);
      b2.setBounds(250, 200, 135, 40);
      
//      jcb.setBounds(10, 10, 140, 40);
      
      l1.setBounds(10, 10, 170, 20);
      l2.setBounds(10, 40, 170, 20);
      
      panel.add(l1);
      panel.add(l2);
      panel.add(b1);
      panel.add(b2);
//      panel.add(jcb);
//      panel.add(scrollPane);
      panel.add(jlist);
      
      this.add(panel);
      
      b1.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
             if(jlist.getSelectedIndex()>=0)
             {
                 // update the list
                JOptionPane.showMessageDialog(null, "Confirmed.");
                Object[] options = {"Yes", "No"};
                int choice = JOptionPane.showOptionDialog(null, "Would you like to make additional reservations?", 
                        "Message", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                
                if (choice == 0)
                {
                     try {
                         new InfoForm(currentUser);
                         dispose();
                     } catch (ParseException ex) {
//                         Logger.getLogger(LuxuriousRoomsFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
//            luxuriousRoomsList.remove(luxuriousRoomsList.get(1));
            
//            new LuxuriousRoomsFrame(currentUser);
//            jlist.remove(jlist.getSelectedIndex());
             }
         }
      });
      
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
