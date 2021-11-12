package tech.lpdev;

import tech.lpdev.gui.OptionMenu;
import tech.lpdev.hidden.Private;
import lombok.Getter;
import tech.lpdev.objects.Course;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Student;
import tech.lpdev.managers.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class Login implements ActionListener {

    // Gets the URI to the database
    final static String mongoURI = new Private().getMongoURI();

    // Defines all the components of the GUI
    private static final JFrame frame = new JFrame("Login");
    private static final JPanel panel = new JPanel();
    private static final JLabel userLabel = new JLabel("Username:");
    private static final JTextField userText = new JTextField();
    private static final JLabel passLabel = new JLabel("Password:");;
    private static final JPasswordField passText = new JPasswordField();
    private static final JLabel loginResult = new JLabel();

    public static void main(String[] args) {

        // Initializes the database, the student objects and the staff objects
        new DatabaseManager().setupMongo(mongoURI, "StudentManagement");
        Staff.initialize();
        Student.initialize();
        Course.initialize();

        // Sets up the GUI frame
        frame.setSize(360, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        // Sets up the GUI panel
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // Sets up the username label and text field
        userLabel.setBounds(40, 25, 80, 25);
        panel.add(userLabel);
        userText.setBounds(120, 25, 120, 25);
        panel.add(userText);

        // Sets up the password label and text field
        passLabel.setBounds(40, 60, 80, 25);
        panel.add(passLabel);
        passText.setBounds(120, 60, 120, 25);
        panel.add(passText);

        // Sets up the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 95, 60, 25);
        loginButton.addActionListener(new Login());
        frame.getRootPane().setDefaultButton(loginButton);
        loginButton.requestFocus();
        panel.add(loginButton);

        // Sets up the error label
        loginResult.setBounds(0, 130, 360, 25);
        loginResult.setHorizontalAlignment(SwingConstants.CENTER);
        loginResult.setForeground(Color.RED);
        panel.add(loginResult);

        frame.setVisible(true);
    }

    /**
     * Checks the database to see if the given credentials in the username and password text fields are valid
     *
     * @param e The given event that initiated the method
     */
    public void actionPerformed(ActionEvent e) {

        // Searches whether the given username exists in either the student or staff databases
        Staff staff = Staff.getByUsername(userText.getText());
        Student student = Student.getByUsername(userText.getText());

        // Displays an error message if there is no text in one or both text fields
        if (userText.getText().equals("") || passText.getText().equals("")) {
            loginResult.setText("One or more fields are empty");
        } else {
            // Checks whether the returned object is a staff object
            if (staff != null) {
                // Hides the current page and displays the next menu
                if (passText.getText().equals(staff.getPassword())) {
                    new OptionMenu().optionMenu(staff, null);
                    userText.setText("");
                    passText.setText("");
                    loginResult.setText("");
                    frame.hide();
                    return;
                } else {
                    // Displays an error message telling the user that they gave the wrong password
                    loginResult.setText("Invalid password");
                    return;
                }
                // Checks whether the returned object is a student object
            } else if (student != null) {
                // Hides the current page and displays the next menu
                if (passText.getText().equals(student.getPassword())) {
                    new OptionMenu().optionMenu(null, student);
                    frame.setVisible(false);
                    return;
                } else {
                    // Displays an error message telling the user that they gave the wrong password
                    loginResult.setText("Invalid password");
                    return;
                }
            }
            // Shows an error message if the given username is incorrect
            loginResult.setText("Invalid username");
        }
    }

    public static void setVisible() {
        userText.setText("");
        passText.setText("");
        frame.show();
    }
}
