
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ManagerCalendar {

    GregorianCalendar today = new GregorianCalendar();
    int tDay = today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    Manager m;
    public static String sDisplayDate = "00/00/0000";
    int k = 1;

    JTextArea area = new JTextArea(25, 35);

    public ManagerCalendar(Manager m) throws ParseException {
        this.m = m;
        JPanel cal = mCalendar();
        JScrollPane eventDisplay = eventDisplay();
        final JFrame frame = new JFrame();
        eventDisplay = eventDisplay();
        frame.add(calendarShift(), BorderLayout.NORTH);
        frame.add(cal, BorderLayout.WEST);
        frame.add(eventDisplay, BorderLayout.EAST);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() 
        {
              @Override
              public void windowClosing(WindowEvent e) 
              {
                  new LoginRegistration();
                  frame.dispose();
              }
          };
        frame.addWindowListener(exitListener);
        
        frame.pack();
        frame.setVisible(true);
    }

    public JScrollPane eventDisplay() throws ParseException {
        area.setText("Select date to display available rooms");
        JScrollPane textArea = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return textArea;
    }

    public void setDisplayDate(String d) throws ParseException {
        sDisplayDate = d;
        area.setText("Available Rooms:" + "\n" + m.displayRoomsOnDay(sDisplayDate));
    }
    
    public JPanel calendarShift()
    {
        JPanel cshift = new JPanel();
        String[] mList = new String[] {"January", "February", "March", "April", "May", "June","July","August","September","October","November", "December"};
        JComboBox<String> monthList = new JComboBox<>(mList);
        cshift.add(monthList);
        return cshift;
    }

    public JPanel mCalendar() {

        JPanel panel = new JPanel();
        JButton[][] b = new JButton[6][7];
        panel.setLayout(new GridLayout(6, 7));

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                b[row][col] = new JButton();
                panel.add(b[row][col]);
            }
        }

        String[] wDay = new String[]{"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        for (int col = 0; col < 7; col++) {
            b[0][col].setText(wDay[col]);
        }
        int space = 0;

        for (int i = 0; i < tDay; i++) {
            space++;
        }

        for (int c1 = space; c1 < 7 - space + 1; c1++) {
            b[1][c1].setText(String.valueOf(k));
            b[1][c1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ManagerCalendar.sDisplayDate = ((JButton) e.getSource()).getText();
                    String month = String.valueOf(today.get(Calendar.MONTH) + 1);
                    String year = String.valueOf(today.get(Calendar.YEAR));
                    if (Integer.valueOf(sDisplayDate) < 10) {
                        sDisplayDate = "0" + sDisplayDate;
                    }
                    if (Integer.valueOf(month) < 10) {
                        month = "0" + month;
                    }
                    String date = month + "/" + sDisplayDate + "/" + year;
                    try {
                        setDisplayDate(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ManagerCalendar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            k++;
        }

        outerloop:
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (k > today.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    break outerloop;
                } else {
                    b[row][col].setText(String.valueOf(k));
                    b[row][col].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ManagerCalendar.sDisplayDate = ((JButton) e.getSource()).getText();
                            String month = String.valueOf(today.get(Calendar.MONTH) + 1);
                            String year = String.valueOf(today.get(Calendar.YEAR));
                            if (Integer.valueOf(sDisplayDate) < 10) {
                                sDisplayDate = "0" + sDisplayDate;
                            }
                            if (Integer.valueOf(month) < 10) {
                                month = "0" + month;
                            }
                            String date = month + "/" + sDisplayDate + "/" + year;
                            try {
                                setDisplayDate(date);
                            } catch (ParseException ex) {
                                Logger.getLogger(ManagerCalendar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    k++;
                }
            }
        }
        return panel;
    }

}
