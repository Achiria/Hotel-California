import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anthony
 */
public class Manager extends User
{

    public Manager()
    {
        userid = "administrator";
    }

    public void load() throws FileNotFoundException, ParseException
    {
        Scanner in = new Scanner(new File("reservations.txt"));
        Pattern datePatt = Pattern.compile("[0-9]{2}?/[0-9]{2}?/[0-9]{4}?");
        
        int i = 0;
        while (in.hasNextLine())
        {
            //gets the first int in line
            int roomNumber = in.nextInt();
            //gets the first string (user name)
            String id = in.next();
            //creates a user based on the name it got
            Guest temp = new Guest(id);
            //adds the user to the list of users
            HotelCalifornia.addAccount(temp);
            //takes the next date
            String next = in.next(datePatt);
            Calendar start = stringToDate(next);
            next = in.next(datePatt);
            Calendar end = stringToDate(next);
            Event e = new Event(start, end, roomNumber, temp);
            temp.addEvent(e);
            
            System.out.println(i);
            i++;
        }
    }

    public void save() throws IOException, FileNotFoundException
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        PrintWriter out = new PrintWriter("reservations.txt");

        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < HotelCalifornia.rooms[i].events.size(); j++)
            {
                out.println(HotelCalifornia.rooms[i].events.get(j).toString());
            }

        }
        out.close();
    }
}
