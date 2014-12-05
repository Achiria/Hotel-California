
import java.text.ParseException;
import java.util.*;
import java.lang.IllegalArgumentException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anthony
 */
public class Guest extends User {

    public Guest(String id) {
//        for (int i = 0; i < HotelCalifornia.userAccounts.size(); i++) {
//            try {
//                if (id.equals(HotelCalifornia.userAccounts.get(i).userid)) {
//                    throw new IllegalArgumentException();
//                }
//            } catch (IllegalArgumentException e) {
//                System.err.println("That name is already taken.");
//            }
//        }
        userid = id;
    }

    public Guest(String id, String load) {
        for (int i = 0; i < HotelCalifornia.userAccounts.size(); i++) {
            try {
                if (id.equals(HotelCalifornia.userAccounts.get(i).userid)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
            }
        }
        userid = id;
    }

    public void addEvent(String start, String end, int roomNumber) throws ParseException {
        Calendar s = stringToDate(start);
        Calendar e = stringToDate(end);
        Event newEvent = new Event(s, e, roomNumber, HotelCalifornia.currentUser);
        events.add(newEvent);
        HotelCalifornia.rooms[roomNumber].addEvent(newEvent);
    }

    public void addEvent(Event toAdd) {
        events.add(toAdd);
        HotelCalifornia.rooms[toAdd.getRoom()].addEvent(toAdd);
    }

    public void deleteEvent(Event e) throws ParseException {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).equals(e)) {
                events.remove(events.get(i));
            }
        }
    }

    public boolean checkOverstay(String start, String end) throws ParseException {
        int stay = 0;
        Calendar s = stringToDate(start);
        Calendar e = stringToDate(end);
        Calendar date = (Calendar) s.clone();
        while (date.before(e)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            stay++;
        }
        return stay < 60;
    }

    public ArrayList getEvents() {
        return events;
    }
}
