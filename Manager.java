import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        while (in.hasNext())
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
            next = in.next();
            next = in.next(datePatt);
            Calendar end = stringToDate(next);
            Event e = new Event(start, end, roomNumber, temp);
            temp.addEvent(e);
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

    public String displayEventsOnDay(String date) throws ParseException
    {
        Calendar d = stringToDate(date);
        String answer = "";

        for (int i = 0; i < HotelCalifornia.userAccounts.size(); i++)
        {
            ArrayList<Event> toGet = HotelCalifornia.userAccounts.get(i).getEvents();
            for (int j = 0; j < toGet.size(); j++)
            {

                Calendar start = toGet.get(j).getCheckin();
                Calendar end = toGet.get(j).getCheckout();
                if (isBetween(start, end, d))
                {
                    answer += toGet.get(j).toString() + "\n";

                }
            }
        }
        return answer;
    }

    public boolean isBetween(Calendar start, Calendar end, Calendar date)
    {
        return date.after(start) && date.before(end);
    }
}
