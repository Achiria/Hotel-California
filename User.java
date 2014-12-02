import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anthony
 */
public class User
{
    String userid = new String();
    final ArrayList<Event> events = new ArrayList<>();
    
     public Calendar stringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = sdf.parse(date);
        Calendar g = Calendar.getInstance();
        g.setTime(dt);
        return g;
    }
    
     /*
    given a date in the form "MM/DD/YYYY" returns the event at that date
    */
    public Event find(String date) throws ParseException {
        Calendar d = stringToDate(date);
        for (Event event : events)
        {
            if (event.getDate().get(Calendar.DATE) == d.get(Calendar.DATE) && event.getDate().get(Calendar.MONTH) == d.get(Calendar.MONTH) && event.getDate().get(Calendar.YEAR) == d.get(Calendar.YEAR))
            {
                return event;
            }
        }
        return null;
    }

    public ArrayList getEvents()
    {
        return events;
    }
    
}