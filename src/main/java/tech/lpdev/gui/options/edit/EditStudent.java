package tech.lpdev.gui.options.edit;

import tech.lpdev.gui.options.SearchStudents;
import lombok.Getter;
import lombok.Setter;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class EditStudent {

    private static JFrame frame = new JFrame();
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
    private static final JLabel noFirstName = new JLabel("Please add a first name");
    private static final JButton submit = new JButton("Submit");
    private static final JButton back = new JButton("Back");
    private static final JButton delete = new JButton("Delete");

    public void editStudent(Staff staff, Student student, Student searched) {
        frame.setSize(800, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        label_first_name.setBounds(25, 25, 150, 25);
        label_first_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_first_name);
        first_name.setBounds(25, 50, 150, 25);
        first_name.setText(searched.getFirstName());
        panel.add(first_name);

        label_middle_name.setBounds(200, 25, 150, 25);
        label_middle_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_middle_name);
        middle_name.setBounds(200, 50, 150, 25);
        middle_name.setText(searched.getMiddleName());
        panel.add(middle_name);

        label_last_name.setBounds(375, 25, 150, 25);
        label_last_name.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_last_name);
        last_name.setBounds(375, 50, 150, 25);
        last_name.setText(searched.getLastName());
        panel.add(last_name);

        label_username.setBounds(550, 25, 150, 25);
        label_username.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_username);
        username.setBounds(550, 50, 150, 25);
        username.setText(searched.getUsername());
        panel.add(username);

        label_position.setBounds(25, 75, 150, 25);
        label_position.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_position);
        position.setBounds(25, 100, 150, 25);
        position.setText(searched.getPosition());
        panel.add(position);

        label_security.setBounds(200, 75, 150, 25);
        label_security.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_security);

        securityMenu.setBounds(200, 100, 75, 25);
        securityMenu.setSelectedItem(String.valueOf(searched.getSecurity()));
        securityLocked.setBounds(200, 100, 75, 25);

        securityLocked.setText(String.valueOf(searched.getSecurity()));
        securityLocked.setEditable(false);

        noFirstName.setBounds(0 , 150, 800, 25);
        noFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        noFirstName.setForeground(Color.red);
        panel.add(noFirstName);
        noFirstName.setVisible(false);

        submit.setBounds(25, 150, 75, 25);

        back.setBounds(720, 5, 75, 25);
        panel.add(back);

        delete.setBounds(100, 150, 75, 25);

        if (staff != null) {
            if (staff.getSecurity() == 1) {
                first_name.setEditable(false);
                middle_name.setEditable(false);
                last_name.setEditable(false);
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
            }
            if (staff.getSecurity() == 2) {
                first_name.setEditable(false);
                middle_name.setEditable(false);
                last_name.setEditable(false);
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
            }
            if (staff.getSecurity() == 3 && searched.getSecurity() < 3) {
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
                panel.add(submit);
                panel.add(delete);
            } else if (staff.getSecurity() == 3 && searched.getSecurity() > 3) {
                first_name.setEditable(false);
                middle_name.setEditable(false);
                last_name.setEditable(false);
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
            }
            if (staff.getSecurity() == 4) {
                panel.add(securityMenu);
                panel.add(submit);
                panel.add(delete);
            }
        }
        if (student != null) {
            if (student.getSecurity() == 2) {
                first_name.setEditable(false);
                middle_name.setEditable(false);
                last_name.setEditable(false);
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
            }
            if (student.getSecurity() == 3 && searched.getSecurity() < 3) {
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
                panel.add(submit);
                panel.add(delete);
            } else if (student.getSecurity() == 3 && searched.getSecurity() > 3) {
                first_name.setEditable(false);
                middle_name.setEditable(false);
                last_name.setEditable(false);
                username.setEditable(false);
                position.setEditable(false);
                panel.add(securityLocked);
            }
            if (student.getSecurity() == 4) {
                panel.add(securityMenu);
                panel.add(submit);
                panel.add(delete);
            }
        }
        frame.setVisible(true);

        submit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (first_name.getText().equals("")) {
                            noFirstName.setVisible(true);
                        } else {
                            if (first_name.getText().equals(searched.getFirstName()))
                                searched.setFirstName(searched.getFirstName());
                            else searched.setFirstName(first_name.getText());
                            if (middle_name.getText().equals(searched.getMiddleName()))
                                searched.setMiddleName(searched.getMiddleName());
                            else if (middle_name.getText().equals("")) searched.setMiddleName(null);
                            else searched.setMiddleName(middle_name.getText());
                            if (last_name.getText().equals(searched.getLastName()))
                                searched.setLastName(searched.getLastName());
                            else if (last_name.getText().equals("")) searched.setLastName(null);
                            else searched.setLastName(last_name.getText());
                            if (username.getText().equals(searched.getUsername()))
                                searched.setUsername(searched.getUsername());
                            else if (username.getText().equals("")) searched.setUsername(searched.getUsername());
                            else searched.setUsername(username.getText());
                            if (position.getText().equals(searched.getPosition()))
                                searched.setPosition(searched.getPosition());
                            else if (position.getText().equals("")) searched.setPosition(null);
                            else searched.setPosition(position.getText());
                            if (Integer.parseInt(securityMenu.getItemAt(securityMenu.getSelectedIndex())) == searched.getSecurity())
                                searched.setSecurity(searched.getSecurity());
                            else
                                searched.setSecurity(Integer.parseInt(securityMenu.getItemAt(securityMenu.getSelectedIndex())));
                            searched.save();
                            noFirstName.setVisible(false);
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new SearchStudents().setVisible();
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final JFrame vFrame = new JFrame();
                        final JPanel vPanel = new JPanel();
                        final JLabel message = new JLabel();
                        final JButton yes = new JButton("Yes");
                        final JButton no = new JButton("No");

                        vFrame.setSize(300, 150);
                        vFrame.setLocationRelativeTo(null);
                        vFrame.add(vPanel);

                        vPanel.setLayout(null);

                        message.setBounds(0, 25, 300, 25);
                        message.setHorizontalAlignment(SwingConstants.CENTER);
                        message.setForeground(Color.red);
                        message.setText("Are you sure you want to delete " + searched.getFirstName() + "?");
                        vPanel.add(message);

                        yes.setBounds(25, 75, 75, 25);
                        vPanel.add(yes);

                        no.setBounds(200, 75, 75, 25);
                        vPanel.add(no);

                        vFrame.setVisible(true);

                        yes.addActionListener(
                                new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        searched.remove();
                                        vFrame.hide();
                                        frame.hide();
                                        new SearchStudents().setVisible();
                                    }
                                }
                        );

                        no.addActionListener(
                                new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        vFrame.hide();
                                    }
                                }
                        );
                    }
                }
        );
    }
}
