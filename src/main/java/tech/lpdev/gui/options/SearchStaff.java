package tech.lpdev.gui.options;

import tech.lpdev.gui.OptionMenu;
import tech.lpdev.gui.options.edit.EditStaff;
import lombok.Getter;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class SearchStaff {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel searchLabel = new JLabel("Enter a staff username:");
    private static final JTextField search = new JTextField();
    private static final JButton searchButton = new JButton("Search");
    private static final JLabel searchResult = new JLabel();
    private static final JButton back = new JButton("Back");

    public void staff(Staff staff, Student student) {
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.gray);

        searchLabel.setBounds(0, 50, 800, 25);
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(searchLabel);

        search.setBounds(300, 75, 200, 25);
        panel.add(search);

        searchButton.setBounds(350, 100, 100, 25);
        frame.getRootPane().setDefaultButton(searchButton);
        searchButton.requestFocus();
        panel.add(searchButton);

        searchResult.setBounds(0, 125, 800, 25);
        searchResult.setHorizontalAlignment(SwingConstants.CENTER);
        searchResult.setForeground(Color.RED);
        searchResult.setVisible(false);
        panel.add(searchResult);

        back.setBounds(720, 5, 75, 25);
        panel.add(back);

        frame.setVisible(true);

        searchButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        searchResult.setVisible(false);
                        Staff searched = Staff.getByUsername(search.getText());
                        if (searched != null) {
                            if (staff != null) {
                                frame.hide();
                                search.setText("");
                                new EditStaff().editStaff(staff, student, searched);
                            }
                            if (student != null) {
                                frame.hide();
                                search.setText("");
                                new EditStaff().editStaff(staff, student, searched);
                            }
                        } else {
                            if (search.getText().equals("")) {
                                searchResult.setText("Please enter a username");
                                searchResult.setVisible(true);
                            } else {
                                searchResult.setText(search.getText() + " is not a valid username!");
                                searchResult.setVisible(true);
                            }
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        search.setText("");
                        new OptionMenu().setVisible();
                    }
                }
        );
    }
    public void setVisible() {frame.show();}
}
