
import java.util.ArrayList;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anthony
 */
public class Room {

    int PRICE, roomNumber;
    private ArrayList<Event> events = new ArrayList<>();

    public int getPrice() {
        return PRICE;
    }

    public int getRoomNUmber() {
        return roomNumber;
    }
    

    public void addEvent(Event e) {
        events.add(e);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void clearEvents() {
        events.clear();
    }
}
