import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event
{

    private Calendar checkin;
    private Calendar checkout;
    private int room;

    public Event(Calendar in, Calendar out, int newRoom)
    {
        checkin = in;
        checkout = out;
        room = newRoom;
    }
        
    public Calendar getCheckin()
    {
        return checkin;
    }

    public Calendar getCeckout()
    {
        return checkout;
    }

    public Calendar getDate()
    {
        return null;
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        String output = new String();
        output = room + " " + sdf.format(checkin.getTime()) + "-" + sdf.format(checkout.getTime());
        
        return output;
    }
}
