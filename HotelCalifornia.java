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
    public static void main(String[] args) throws ParseException, IOException
    {
        User currentUser = new User();
        Manager manager = new Manager();
        populateRooms();
        gui.main(args);
        
        Guest me = new Guest("Anthony");
        addAccount(me);
        me.addEvent("01/01/2011", "01/02/2011", 2);
        manager.load();
        
        for (int i = 0; i < 20; i++)
        {
            System.out.println(HotelCalifornia.rooms[i].events.toString());
        }
    }
}
