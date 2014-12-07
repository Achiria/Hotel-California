import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EconomicRoomsFrame extends JFrame
{
//   public static void main(String[] args)
//   {
//      new LuxuriousRoomsFrame("test");
//   }
   
   public EconomicRoomsFrame(final String currentUser, final String checkIn, final String checkOut) throws ParseException
   {
      super("Available Economic Rooms");
      
      setSize(400, 280);
      setResizable(false);
      
//      setDefaultCloseOperation(EXIT_ON_CLOSE);
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
      
//      Integer luxuriousRooms[] = new Integer[10];
//      for (int i = 0; i < luxuriousRooms.length; i++)
//      {
//         luxuriousRooms[i] = i + 11;
//      }
      
      
//      String luxuriousRooms[] = new String[10];
//      for (int i = 0; i < luxuriousRooms.length; i++)
//      {
//          luxuriousRooms[i] = Integer.toString(i + 11);
//      }
      
      
      Integer economicArray[] = new Integer[10];
//      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//      Date start = df.parse(checkIn);
//      Date end = df.parse(checkOut);
      Calendar start = HotelCalifornia.manager.stringToDate(checkIn);
      Calendar end = HotelCalifornia.manager.stringToDate(checkOut);
      
//      for (int i = 0; i < luxuriousArray.length; i++)
//      {
//          Manager  = new Manager();
      for (int i = 0; i < 10; i++)
      {
          
          if (!HotelCalifornia.manager.isBooked(HotelCalifornia.rooms[i], start, end))
          {
              economicArray[i] = i;
          }
      }
//          for (Room r : HotelCalifornia.rooms)
//          {
//              System.out.println(r.roomNumber);
////              if (!HotelCalifornia.manager.isBooked(r, start, end))
////              {
////                  luxuriousArray[i] = i+11;
////              }
//          }
          
//          for (int i = 10; i < 20; i++)
//          {
//              for (Room r : HotelCalifornia.rooms)
//                {
//                    System.out.println(r.roomNumber);
//                }
//          }
//      }
//      Integer luxuriousArray[] = new Integer[HotelCalifornia.luxuriousRooms.size
//      Integer luxuriousArray[] = HotelCalifornia
//      for (int i = 0; i < luxuriousArray.length; i++)
//      {
//         luxuriousArray[i] = HotelCalifornia.luxuriousRooms.get(i);
//      }
      
      final JList<Integer> jlist = new JList<>(economicArray);
//      final JList<Integer> jlist = new JList<>(luxuriousRooms);
      jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      JScrollPane scrollPane = new JScrollPane(ta);
//      scrollPane.setBounds(10, 10, 150, 350);
      jlist.setBounds(10, 60, 150, 190);
      
//      for (int i : luxuriousRooms)
//          System.out.println(i);
//      JComboBox<Integer> jcb = new JComboBox<>(luxuriousRooms);
      
      JButton b1 = new JButton("Confirm");
      JButton b2 = new JButton("Transaction Done");
      
      JLabel l1 = new JLabel("Available Economic Rooms");
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
                JOptionPane.showMessageDialog(null, "Confirmed for " + currentUser + " " + checkIn + " " + checkOut + " room#: " + (jlist.getSelectedIndex()));
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
                else
                {
//                   HotelCalifornia.reservations.add(new Reservation(currentUser, "12/5/2014", "12/6/2014", jlist.getSelectedIndex() + 11));
                   Guest g = new Guest(currentUser);
                   HotelCalifornia.tempRooms.add(jlist.getSelectedIndex());
                   HotelCalifornia.userAccounts.add(g);
                     try {
                         g.addEvent(checkIn, checkOut, jlist.getSelectedIndex());
                     } catch (ParseException ex) {
//                         Logger.getLogger(LuxuriousRoomsFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                   
//                    HotelCalifornia.luxuriousRooms.remove(jlist.getSelectedIndex());
                   
                   // write to file:
//                   String reservationInfo = currentUser + " " + checkIn + " " + checkOut + " " + (jlist.getSelectedIndex() + 11);
//                   
//                   try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reservations.txt", true)))) 
//                     {
//                        
//                        if (!reservationInfo.isEmpty())
//                        {
//                           out.println(reservationInfo);
//                        }
//                     }
//                     catch (IOException ex) 
//                     {
//
//                     }
                     Manager m = new Manager();
                     try {
                         m.save();
                     } catch (IOException ex) {
//                         Logger.getLogger(LuxuriousRoomsFrame.class.getName()).log(Level.SEVERE, null, ex);
                     } 
                     
                     
                     
                     try {
                         new EconomicRoomsFrame(currentUser, checkIn, checkOut);
                     } catch (ParseException ex) {
//                         Logger.getLogger(LuxuriousRoomsFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                   dispose();
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
