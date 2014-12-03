import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegistration extends JFrame
{

    static JPanel panel = new JPanel();

    public static void main(String[] args)
    {
        Manager manager = new Manager();
        HotelCalifornia.populateRooms();
        new LoginRegistration();
    }

    public LoginRegistration()
    {
        super("Login/Registration");

        setSize(390, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

//      panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(null);
        JLabel l1 = new JLabel("User ID:");
        JTextField t1 = new JTextField(20);
        JButton b1 = new JButton("Login");

        l1.setBounds(10, 10, 50, 20);
        panel.add(l1);
        t1.setBounds(60, 10, 200, 20);
        panel.add(t1);
        b1.setBounds(270, 10, 80, 20);
        panel.add(b1);

        JLabel l2 = new JLabel("New User?");
//      panel.setLayout(new GridLayout(1, 0));
        JLabel l3 = new JLabel("Enter an ID:");
        JTextField t2 = new JTextField(20);
        JButton b2 = new JButton("Register");

        l2.setBounds(10, 200, 70, 20);
        panel.add(l2);

        l3.setBounds(10, 230, 100, 20);
        panel.add(l3);
        t2.setBounds(80, 230, 200, 20);
        panel.add(t2);
        b2.setBounds(290, 230, 90, 20);
        panel.add(b2);

        this.add(panel);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = t1.getText();
                boolean result = HotelCalifornia.login(name);

                if (result)
                {
                    MakeReservation mR = new MakeReservation();
                    mR.setVisible(true);
                    dispose();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
