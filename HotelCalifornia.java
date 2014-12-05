
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
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
    
    public static ArrayList<Integer> luxuriousRooms = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();
    
    static Room[] rooms = new Room[20];
    static User currentUser;
    static Manager manager;
    
    public static void main(String[] args) throws ParseException, IOException {
        for (int i = 11; i < 21; i++)
      {
         luxuriousRooms.add(i);
      }
         
        manager = new Manager();
        
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
