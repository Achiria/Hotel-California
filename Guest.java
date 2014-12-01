
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anthony
 */
public class Guest extends User
{
    public Guest(String id)
    {
        for (User userAccount : HotelCalifornia.userAccounts)
        {
            if (id.equals(userAccount))
            {
                System.out.println("That user name is already taken");
                return;
            }
        }
        userid = id;
    }

    public void addEvent(String start, String end, int roomNumber) throws ParseException
    {
        Calendar s = stringToDate(start);
        Calendar e = stringToDate(end);
        Event newEvent = new Event(s, e, roomNumber, HotelCalifornia.currentUser);

        events.add(newEvent);

        //the exceptions will be caught in the 
        HotelCalifornia.rooms[roomNumber].addEvent(newEvent);
    }
    
    public void addEvent(Event toAdd)
    {
        events.add(toAdd);
        HotelCalifornia.rooms[toAdd.getRoom()].addEvent(toAdd);
    }

    public void deleteEvent(String input) throws ParseException
    {
        while (true)
        {
            Event t = find(input);
            if (t == null)
            {
                break;
            }
            events.remove(t);
        }
    }

    public boolean checkOverstay(String start, String end) throws ParseException
    {
        int stay = 0;
        Calendar s = stringToDate(start);
        Calendar e = stringToDate(end);
        Calendar date = (Calendar) s.clone();
        while (date.before(e))
        {
            date.add(Calendar.DAY_OF_MONTH, 1);
            stay++;
        }

        return stay < 60;
    }

    public ArrayList getEvents()
    {
        return events;
    }
}
