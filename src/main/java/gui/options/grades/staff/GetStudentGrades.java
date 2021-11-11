package gui.options.grades.staff;

import gui.options.grades.GradesMenu;
import objects.Course;
import objects.Staff;
import objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetStudentGrades {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel codeLabel = new JLabel("Enter course code:");
    private static final JTextField code = new JTextField();
    private static final JLabel nameLabel = new JLabel("Enter students username:");
    private static final JTextField name = new JTextField();
    private static final JButton searchButton = new JButton("Search");
    private static final JLabel searchResult = new JLabel();
    private static final JButton back = new JButton("Back");

    public void getStudentGrades(Staff staff) {

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        codeLabel.setBounds(0, 50, 800, 25);
        codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(codeLabel);

        code.setBounds(300, 75, 200, 25);
        panel.add(code);

        nameLabel.setBounds(0, 100, 800, 25);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);

        name.setBounds(300, 125, 200, 25);
        panel.add(name);

        searchButton.setBounds(350, 150, 100, 25);
        frame.getRootPane().setDefaultButton(searchButton);
        searchButton.requestFocus();
        panel.add(searchButton);

        searchResult.setBounds(0, 175, 800, 25);
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
                        searchResult.setVisible(false);
                        if (Course.getByCode(code.getText(), staff) == null) {
                            searchResult.setText("Course does not exist");
                            searchResult.setVisible(true);
                        } else if (Student.getByUsername(name.getText()) == null) {
                            searchResult.setText("There is no student matching this username");
                            searchResult.setVisible(true);
                        } else {
                            frame.hide();
                            searchResult.setVisible(false);
                            new EditStudentGrades().editStudentGrades(staff, Student.getByUsername(name.getText()), Course.getByCode(code.getText(), staff));
                            name.setText("");
                            code.setText("");
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        code.setText("");
                        name.setText("");
                        searchResult.setText("");
                        searchResult.setVisible(false);
                        new GradesMenu().gradesMenu(staff);
                    }
                }
        );
    }
}
