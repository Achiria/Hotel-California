
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anthony
 */
public class HotelCalifornia {

    static ArrayList<User> userAccounts = new ArrayList<>();
    
//    public static ArrayList<Integer> luxuriousRooms = new ArrayList<>();
//    public static ArrayList<Reservation> reservations = new ArrayList<>();
    
    static Room[] rooms = new Room[20];
    static User currentUser;
    static Manager manager;
    static ArrayList<Integer> tempRooms = new ArrayList<>();
    
    public static void main(String[] args) throws ParseException, IOException {
//        for (int i = 11; i < 21; i++)
//      {
//         luxuriousRooms.add(i);
//      }
     manager = new Manager();
//     manager.load();
        populateRooms();
//        Guest one = new Guest("Anthony");
//        Guest two = new Guest("Stephen");
//        Guest three = new Guest("Johan");
//        addAccount(one);
//        addAccount(two);
//        addAccount(three);
//        login(one);
//        one.addEvent("12/01/2014", "12/02/2014", 2);
//        login(two);
//        two.addEvent("12/01/2014", "12/05/2014", 7);
//        login(three);
//        three.addEvent("12/05/2014", "12/08/2014", 3);
//        three.addEvent("01/03/2014", "01/05/2014", 4);      
//        manager = new Manager();
        try
        {
        manager.load();
        }
        catch(FileNotFoundException ex)
        {
            
        }
        new LoginRegistration();
    }
    
    public static void addAccount(User newUser) {
        userAccounts.add(newUser);
    }

    private static void populateRooms() {
        for (int i = 0; i < 10; i++) {
            rooms[i] = new Economic(i);
        }
        for (int i = 10; i < 20; i++) {
            rooms[i] = new Luxurious(i);
        }
    }

    public static void clearEvents() {
        for (Room room : rooms) {
            room.clearEvents();
        }
    }

    public static void clearUsers() {
        userAccounts.clear();
    }

    public static void login(String id) {
        for (User userAccount : userAccounts) {
            if (userAccount.userid.equals(id)) {
                currentUser = userAccount;
                return;
            }
        }
        System.err.println("That user does not exist. Capitalizaton matters.");
    }

    public static void login(User user) {
        for (User userAccount : userAccounts) {
            if (userAccount.equals(user)) {
                currentUser = userAccount;
                return;
            }
        }
        System.err.println("That user does not exist. Capitalizaton matters.");
    }


}
