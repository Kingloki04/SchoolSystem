package tech.lpdev.gui.options;

import tech.lpdev.gui.OptionMenu;
import lombok.Getter;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class AddStudent {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel label_first_name = new JLabel("First Name");
    private static final JTextField first_name = new JTextField();
    private static final JLabel label_middle_name = new JLabel("Middle Name");
    private static final JTextField middle_name = new JTextField();
    private static final JLabel label_last_name = new JLabel("Last Name");
    private static final JTextField last_name = new JTextField();
    private static final JLabel label_username = new JLabel("Username");
    private static final JTextField username = new JTextField();
    private static final JLabel label_position = new JLabel("Position");
    private static final JTextField position = new JTextField();
    private static final JLabel label_security = new JLabel("Security Level");
    private static final String[] levels = {"1", "2", "3", "4"};
    private static final JComboBox<String> securityMenu = new JComboBox<>(levels);
    private static final JTextField securityLocked = new JTextField();
    private static final JLabel error = new JLabel("Please add a first name");
    private static final JButton create = new JButton("Create User");
    private static final JButton back = new JButton("Back");

    public void addStudent(Staff staff, Student student) {
        frame.setSize(250, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        label_first_name.setBounds(0, 25, 250, 25);
        label_first_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_first_name);
        first_name.setBounds(50, 50, 150, 25);
        panel.add(first_name);

        label_middle_name.setBounds(0, 75, 250, 25);
        label_middle_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_middle_name);
        middle_name.setBounds(50, 100, 150, 25);
        panel.add(middle_name);

        label_last_name.setBounds(0, 125, 250, 25);
        label_last_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_last_name);
        last_name.setBounds(50, 150, 150, 25);
        panel.add(last_name);

        label_username.setBounds(0, 175, 250, 25);
        label_username.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_username);
        username.setBounds(50, 200, 150, 25);
        panel.add(username);

        label_position.setBounds(0, 225, 250, 25);
        label_position.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_position);
        position.setBounds(50, 250, 150, 25);
        panel.add(position);

        label_security.setBounds(0, 275, 250, 25);
        label_security.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_security);

        securityMenu.setBounds(50, 300, 150, 25);
        securityMenu.setSelectedItem("1");
        panel.add(securityMenu);
        securityMenu.setVisible(false);

        securityLocked.setBounds(50, 300, 150, 25);
        securityLocked.setText(String.valueOf("1"));
        securityLocked.setEditable(false);
        panel.add(securityLocked);


        error.setBounds(0, 325, 250, 25);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.RED);
        panel.add(error);
        error.setVisible(false);

        create.setBounds(50, 350, 150, 25);
        panel.add(create);

        back.setBounds(50, 425, 150, 25);
        panel.add(back);

        if (staff != null) {
            if (staff.getSecurity() == 4) {
                securityLocked.setVisible(false);
                securityMenu.setVisible(true);
            }
        }
        if (student != null) {
            if (student.getSecurity() == 4) {
                securityLocked.setVisible(false);
                securityMenu.setVisible(true);
            }
        }

        frame.setVisible(true);

        create.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if (first_name.getText().equals("")) {
                            if (first_name.getText().equals("")) error.setVisible(true);
                        } else if (username.getText().equals("")) {
                            error.setText("Please add a username");
                            error.setVisible(true);
                        } else if (Student.getByUsername(username.getText()) != null) {
                            error.setText("That username already exists");
                            error.setVisible(true);
                        } else if (Staff.getByUsername(username.getText()) != null) {
                            error.setText("That username already exists");
                            error.setVisible(true);
                        } else {
                            String fName = "", mName = "", lName = "", uName = "", pos = "";
                            int sec = 0;

                            fName = first_name.getText();
                            if (middle_name.getText().equals("")) mName = null;
                            else mName = middle_name.getText();
                            if (last_name.getText().equals("")) lName = null;
                            else lName = last_name.getText();
                            uName = username.getText();
                            if (position.getText().equals("")) pos = null;
                            else pos = position.getText();
                            sec = Integer.parseInt(securityMenu.getItemAt(securityMenu.getSelectedIndex()));

                            Student newStudent = new Student(
                                    fName,
                                    mName,
                                    lName,
                                    uName,
                                    uName,
                                    pos,
                                    sec
                            );
                            newStudent.save();
                            frame.hide();
                            new OptionMenu().setVisible();
                            first_name.setText("");
                            middle_name.setText("");
                            last_name.setText("");
                            username.setText("");
                            position.setText("");
                            securityMenu.setSelectedItem("1");
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        first_name.setText("");
                        middle_name.setText("");
                        last_name.setText("");
                        username.setText("");
                        position.setText("");
                        securityMenu.setSelectedItem("1");
                        new OptionMenu().setVisible();
                    }
                }
        );
    }
}
