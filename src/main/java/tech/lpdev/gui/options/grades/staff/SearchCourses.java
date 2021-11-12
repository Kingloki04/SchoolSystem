package tech.lpdev.gui.options.grades.staff;

import tech.lpdev.gui.options.grades.GradesMenu;
import tech.lpdev.objects.Course;
import tech.lpdev.objects.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCourses {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel searchLabel = new JLabel("Enter course code:");
    private static final JTextField search = new JTextField();
    private static final JButton searchButton = new JButton("Search");
    private static final JLabel searchResult = new JLabel();
    private static final JButton back = new JButton("Back");

    public void searchCourses(Staff staff) {

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

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
        searchResult.setVisible(true);
        panel.add(searchResult);

        back.setBounds(720, 5, 75, 25);
        panel.add(back);

        frame.setVisible(true);

        searchButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchResult.setVisible(false);
                        if (Course.getByCode(search.getText(), staff) != null) {
                            frame.hide();
                            searchResult.setVisible(false);
                            new EditCourse().editCourse(staff, Course.getByCode(search.getText(), staff));
                            search.setText("");
                        }
                        else {
                            searchResult.setVisible(true);
                            searchResult.setText("Course not found");
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        search.setText("");
                        searchResult.setText("");
                        searchResult.setVisible(false);
                        new GradesMenu().gradesMenu(staff);
                    }
                }
        );
    }
}
