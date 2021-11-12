package tech.lpdev.gui;

import tech.lpdev.Login;
import tech.lpdev.gui.options.*;
import tech.lpdev.gui.options.grades.GradesMenu;
import tech.lpdev.gui.options.grades.student.Marks;
import tech.lpdev.gui.options.AddStaff;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionMenu{

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton button0 = new JButton("Reset Password");
    private static final JButton button1 = new JButton("Students");
    private static final JButton button2 = new JButton("Staff");
    private static final JButton button3 = new JButton("Add Student");
    private static final JButton button4 = new JButton("Add Staff");
    private static final JButton button5 = new JButton("Grades");
    private static final JButton logout = new JButton("Logout");

    public void optionMenu(Staff staff, Student student) {
        int components = 0;

        frame.setSize(200, 245);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        if (staff != null) {
            if (staff.getSecurity() >= 1) {
                button1.setBounds(0,5, 200,25);
                button1.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button1);
            }
            if (staff.getSecurity() > 2) {
                components++;
                button2.setBounds(0,5 + (30 * components), 200,25);
                button2.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button2);
            }
            if (staff.getSecurity() >= 3) {
                components++;
                button3.setBounds(0,5 + (30 * components), 200,25);
                button3.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button3);
            }
            if (staff.getSecurity() >= 4) {
                components++;
                button4.setBounds(0,5 + (30 * components), 200,25);
                button4.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button4);
            }
            if (staff.getSecurity() >= 1) {
                components++;
                button5.setBounds(0,5 + (30 * components), 200,25);
                button5.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button5);
            }
            if (staff.getSecurity() >= 1) {
                components++;
                button0.setBounds(0,5 + (30 * components), 200,25);
                button0.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button0);
            }
        }
        if (student != null) {
            if (student.getSecurity() > 1) {
                components++;
                button1.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button1.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button1);
            }
            if (student.getSecurity() > 2) {
                components++;
                button2.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button2.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button2);
            }
            if (student.getSecurity() >= 3) {
                components++;
                button3.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button3.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button3);
            }
            if (student.getSecurity() >= 4) {
                components++;
                button4.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button4.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button4);
            }
            if (student.getSecurity() >= 1) {
                components++;
                button5.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button5.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button5);
            }
            if (student.getSecurity() >= 1) {
                components++;
                button0.setBounds(0,5 + (30 * (components - 1)), 200,25);
                button0.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(button0);
            }
        }

        logout.setBounds(0, 185, 200, 25);
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logout);

        frame.setVisible(true);

        button0.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        new ResetPassword().resetPassword(staff, student);
                    }
                }
        );

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        frame.hide();
                        new SearchStudents().student(staff, student);
                    }
                }
        );

        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        frame.hide();
                        new SearchStaff().staff(staff, student);
                    }
                }
        );

        button3.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        frame.hide();
                        new AddStudent().addStudent(staff, student);
                    }
                }
        );

        button4.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        frame.hide();
                        new AddStaff().addStaff(staff, student);
                    }
                }
        );

        button5.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        if (student != null) new Marks().marks(student);
                        else new GradesMenu().gradesMenu(staff);
                    }
                }
        );

//        logout.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        frame.hide();
//                        Login.setVisible();
//                    }
//                }
//        );
    }
    public void setVisible() {
        frame.show();
    }
}
