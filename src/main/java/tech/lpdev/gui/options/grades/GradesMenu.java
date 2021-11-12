package tech.lpdev.gui.options.grades;

import tech.lpdev.gui.OptionMenu;
import tech.lpdev.gui.options.grades.staff.*;
import tech.lpdev.objects.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradesMenu {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton button1 = new JButton("Edit Student Grades");
    private static final JButton button2 = new JButton("Create Course");
    private static final JButton button3 = new JButton("Edit Course");
    private static final JButton back = new JButton("Back");

    public void gradesMenu(Staff staff) {

        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        button1.setBounds(0, 5, 200, 25);
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button1);

        button2.setBounds(0, 35, 200, 25);
        button2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button2);

        button3.setBounds(0, 65, 200, 25);
        button3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button3);

        back.setBounds(0, 95, 200, 25);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(back);

        frame.setVisible(true);

        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new GetStudentGrades().getStudentGrades(staff);
                    }
                }
        );

        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new CreateCourse().createCourse(staff);
                    }
                }
        );

        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new SearchCourses().searchCourses(staff);
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new OptionMenu().setVisible();
                    }
                }
        );
    }
}
