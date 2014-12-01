import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anthony
 */
public class HotelCalifornia
{
    static ArrayList<User> userAccounts = new ArrayList<>();
    static Room[] rooms = new Room[20];
    static User currentUser;
       
    public static void addAccount(User newUser)
    {
        userAccounts.add(newUser);
    }
    
    private static void populateRooms()
    {
        for (int i = 0; i < 10; i++)
        {
            rooms[i] = new Economic(i);
        }
        
        for (int i = 10; i < 20; i++)
        {
            rooms[i] = new Luxurious(i);
        }
    }
//    public User getUser(String id)
//    {
//        boolean found = false;
//        
//        int i = 0;
//        if (userAccounts.get(i).userid.equals(id))
//        {
//            return userAccounts.get(i);
//        }
//        
//        else 
//        {
//            i++;
//        }
//        
//        System.out.println("Could not find users in load file.");
//        return null;
//    }
    
    public static void main(String[] args) throws ParseException, IOException
    {
        Manager manager = new Manager();
        populateRooms();
        gui.main(args);
        
        Guest one = new Guest("Anthony");
        Guest two = new Guest("Stephen");
        Guest three = new Guest("Johan");
        
        addAccount(one);
        addAccount(two);
        addAccount(three);
        
        currentUser = one;
        one.addEvent("01/01/2011", "01/02/2011", 2); 
        
        currentUser = two;
        two.addEvent("01/03/2011", "01/05/2011", 2);
        
        currentUser = three;
        three.addEvent("02/05/2011", "02/08/2011", 3);
        three.addEvent("01/03/2011", "01/05/2013", 4);
        
        manager.save();
        
        manager.load();
  
        //for testing save and load functions
        for (int i = 0; i < 20; i++)
        {
            System.out.println(HotelCalifornia.rooms[i].events.toString());
        }
    }
}
