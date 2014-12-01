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
        
        while (in.hasNext(datePatt))
        {
            int roomNumber = in.nextInt();
            String next = in.next(datePatt);
            Calendar start = stringToDate(next);
            Calendar end = stringToDate(next);
            Event e = new Event(start, end, roomNumber);
        }
    }

    public void save() throws IOException, FileNotFoundException
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        PrintWriter out = new PrintWriter("reservations.txt");

        for (int i = 0; i < 20; i++)
        {
            int j = 0; 
            out.println(HotelCalifornia.rooms[i].events.toString());
        }

        out.close();
    }
}
