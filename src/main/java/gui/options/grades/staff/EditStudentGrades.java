package gui.options.grades.staff;

import objects.Course;
import objects.Grades;
import objects.Staff;
import objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class EditStudentGrades {

    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    private static JLabel unit1 = new JLabel();
    private static JLabel unit2 = new JLabel();
    private static JLabel unit3 = new JLabel();
    private static JLabel unit4 = new JLabel();
    private static JLabel unit5 = new JLabel();

    private static JLabel section1 = new JLabel("Section 1");
    private static JLabel section2 = new JLabel("Section 2");
    private static JLabel section3 = new JLabel("Section 3");
    private static JLabel section4 = new JLabel("Section 4");
    private static JLabel section5 = new JLabel("Section 5");
    private static JTextField u1s1 = new JTextField();
    private static JTextField u1s2 = new JTextField();
    private static JTextField u1s3 = new JTextField();
    private static JTextField u1s4 = new JTextField();
    private static JTextField u1s5 = new JTextField();
    private static JTextField u2s1 = new JTextField();
    private static JTextField u2s2 = new JTextField();
    private static JTextField u2s3 = new JTextField();
    private static JTextField u2s4 = new JTextField();
    private static JTextField u2s5 = new JTextField();
    private static JTextField u3s1 = new JTextField();
    private static JTextField u3s2 = new JTextField();
    private static JTextField u3s3 = new JTextField();
    private static JTextField u3s4 = new JTextField();
    private static JTextField u3s5 = new JTextField();
    private static JTextField u4s1 = new JTextField();
    private static JTextField u4s2 = new JTextField();
    private static JTextField u4s3 = new JTextField();
    private static JTextField u4s4 = new JTextField();
    private static JTextField u4s5 = new JTextField();
    private static JTextField u5s1 = new JTextField();
    private static JTextField u5s2 = new JTextField();
    private static JTextField u5s3 = new JTextField();
    private static JTextField u5s4 = new JTextField();
    private static JTextField u5s5 = new JTextField();


    private static JButton save = new JButton("Save");
    private static JButton back = new JButton("Back");
    private static JLabel error = new JLabel();

    public void editStudentGrades(Staff staff, Student student, Course course) {

        setItems(course, student);

        frame.setSize(1300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        unit1.setBounds(205, 5, 200, 25);
        unit1.setHorizontalAlignment(SwingConstants.CENTER);
        unit2.setBounds(410, 5, 200, 25);
        unit2.setHorizontalAlignment(SwingConstants.CENTER);
        unit3.setBounds(615, 5, 200, 25);
        unit3.setHorizontalAlignment(SwingConstants.CENTER);
        unit4.setBounds(820, 5, 200, 25);
        unit4.setHorizontalAlignment(SwingConstants.CENTER);
        unit5.setBounds(1025, 5, 200, 25);
        unit5.setHorizontalAlignment(SwingConstants.CENTER);
        section1.setBounds(5, 35, 200, 25);
        section1.setHorizontalAlignment(SwingConstants.CENTER);
        section2.setBounds(5, 65, 200, 25);
        section2.setHorizontalAlignment(SwingConstants.CENTER);
        section3.setBounds(5, 95, 200, 25);
        section3.setHorizontalAlignment(SwingConstants.CENTER);
        section4.setBounds(5, 125, 200, 25);
        section4.setHorizontalAlignment(SwingConstants.CENTER);
        section5.setBounds(5, 155, 200, 25);
        section5.setHorizontalAlignment(SwingConstants.CENTER);
        u1s1.setBounds(205, 35, 200, 25);
        u1s2.setBounds(205, 65, 200, 25);
        u1s3.setBounds(205, 95, 200, 25);
        u1s4.setBounds(205, 125, 200, 25);
        u1s5.setBounds(205, 155, 200, 25);

        u2s1.setBounds(410, 35, 200, 25);
        u2s2.setBounds(410, 65, 200, 25);
        u2s3.setBounds(410, 95, 200, 25);
        u2s4.setBounds(410, 125, 200, 25);
        u2s5.setBounds(410, 155, 200, 25);

        u3s1.setBounds(615, 35, 200, 25);
        u3s2.setBounds(615, 65, 200, 25);
        u3s3.setBounds(615, 95, 200, 25);
        u3s4.setBounds(615, 125, 200, 25);
        u3s5.setBounds(615, 155, 200, 25);

        u4s1.setBounds(820, 35, 200, 25);
        u4s2.setBounds(820, 65, 200, 25);
        u4s3.setBounds(820, 95, 200, 25);
        u4s4.setBounds(820, 125, 200, 25);
        u4s5.setBounds(820, 155, 200, 25);

        u5s1.setBounds(1025, 35, 200, 25);
        u5s2.setBounds(1025, 65, 200, 25);
        u5s3.setBounds(1025, 95, 200, 25);
        u5s4.setBounds(1025, 125, 200, 25);
        u5s5.setBounds(1025, 155, 200, 25);

        save.setBounds(5, 185, 100, 25);
        save.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(save);
        back.setBounds(5, 215, 100, 25);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(back);
        error.setBounds(0, 245, 1300, 25);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.red);
        panel.add(error);

        panel.add(unit1);
        panel.add(unit2);
        panel.add(unit3);
        panel.add(unit4);
        panel.add(unit5);
        panel.add(section1);
        panel.add(section2);
        panel.add(section3);
        panel.add(section4);
        panel.add(section5);
        panel.add(u1s1);
        panel.add(u1s2);
        panel.add(u1s3);
        panel.add(u1s4);
        panel.add(u1s5);
        panel.add(u2s1);
        panel.add(u2s2);
        panel.add(u2s3);
        panel.add(u2s4);
        panel.add(u2s5);
        panel.add(u3s1);
        panel.add(u3s2);
        panel.add(u3s3);
        panel.add(u3s4);
        panel.add(u3s5);
        panel.add(u4s1);
        panel.add(u4s2);
        panel.add(u4s3);
        panel.add(u4s4);
        panel.add(u4s5);
        panel.add(u5s1);
        panel.add(u5s2);
        panel.add(u5s3);
        panel.add(u5s4);
        panel.add(u5s5);

        frame.setVisible(true);

        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UUID uuid = null;
                        boolean exists = false;
                        for (Grades g : student.getGrades()) {
                            if (g.getCourseUUID().toString().equals(course.getUuid().toString()))  {
                                exists = true;
                                uuid = g.getCourseUUID();
                            }
                        }
                        if (exists) {
                            List<Integer> marks = new ArrayList<>();
                            marks.add(Integer.parseInt(u1s1.getText()));
                            marks.add(Integer.parseInt(u1s2.getText()));
                            marks.add(Integer.parseInt(u1s3.getText()));
                            marks.add(Integer.parseInt(u1s4.getText()));
                            marks.add(Integer.parseInt(u1s5.getText()));
                            marks.add(Integer.parseInt(u2s1.getText()));
                            marks.add(Integer.parseInt(u2s2.getText()));
                            marks.add(Integer.parseInt(u2s3.getText()));
                            marks.add(Integer.parseInt(u2s4.getText()));
                            marks.add(Integer.parseInt(u2s5.getText()));
                            marks.add(Integer.parseInt(u3s1.getText()));
                            marks.add(Integer.parseInt(u3s2.getText()));
                            marks.add(Integer.parseInt(u3s3.getText()));
                            marks.add(Integer.parseInt(u3s4.getText()));
                            marks.add(Integer.parseInt(u3s5.getText()));
                            marks.add(Integer.parseInt(u4s1.getText()));
                            marks.add(Integer.parseInt(u4s2.getText()));
                            marks.add(Integer.parseInt(u4s3.getText()));
                            marks.add(Integer.parseInt(u4s4.getText()));
                            marks.add(Integer.parseInt(u4s5.getText()));
                            marks.add(Integer.parseInt(u5s1.getText()));
                            marks.add(Integer.parseInt(u5s2.getText()));
                            marks.add(Integer.parseInt(u5s3.getText()));
                            marks.add(Integer.parseInt(u5s4.getText()));
                            marks.add(Integer.parseInt(u5s5.getText()));
                            student.updateMarks(uuid, marks);
                            student.save();
                        } else {
                            if (!(Integer.parseInt(u1s1.getText()) >= 0 && Integer.parseInt(u1s1.getText()) <= 100) ||
                                    !(Integer.parseInt(u1s2.getText()) >= 0 && Integer.parseInt(u1s2.getText()) <= 100) ||
                                    !(Integer.parseInt(u1s3.getText()) >= 0 && Integer.parseInt(u1s3.getText()) <= 100) ||
                                    !(Integer.parseInt(u1s4.getText()) >= 0 && Integer.parseInt(u1s4.getText()) <= 100) ||
                                    !(Integer.parseInt(u1s5.getText()) >= 0 && Integer.parseInt(u1s5.getText()) <= 100) ||
                                    !(Integer.parseInt(u2s1.getText()) >= 0 && Integer.parseInt(u2s1.getText()) <= 100) ||
                                    !(Integer.parseInt(u2s2.getText()) >= 0 && Integer.parseInt(u2s2.getText()) <= 100) ||
                                    !(Integer.parseInt(u2s3.getText()) >= 0 && Integer.parseInt(u2s3.getText()) <= 100) ||
                                    !(Integer.parseInt(u2s4.getText()) >= 0 && Integer.parseInt(u2s4.getText()) <= 100) ||
                                    !(Integer.parseInt(u2s5.getText()) >= 0 && Integer.parseInt(u2s5.getText()) <= 100) ||
                                    !(Integer.parseInt(u3s1.getText()) >= 0 && Integer.parseInt(u3s1.getText()) <= 100) ||
                                    !(Integer.parseInt(u3s2.getText()) >= 0 && Integer.parseInt(u3s2.getText()) <= 100) ||
                                    !(Integer.parseInt(u3s3.getText()) >= 0 && Integer.parseInt(u3s3.getText()) <= 100) ||
                                    !(Integer.parseInt(u3s4.getText()) >= 0 && Integer.parseInt(u3s4.getText()) <= 100) ||
                                    !(Integer.parseInt(u3s5.getText()) >= 0 && Integer.parseInt(u3s5.getText()) <= 100) ||
                                    !(Integer.parseInt(u4s1.getText()) >= 0 && Integer.parseInt(u4s1.getText()) <= 100) ||
                                    !(Integer.parseInt(u4s2.getText()) >= 0 && Integer.parseInt(u4s2.getText()) <= 100) ||
                                    !(Integer.parseInt(u4s3.getText()) >= 0 && Integer.parseInt(u4s3.getText()) <= 100) ||
                                    !(Integer.parseInt(u4s4.getText()) >= 0 && Integer.parseInt(u4s4.getText()) <= 100) ||
                                    !(Integer.parseInt(u4s5.getText()) >= 0 && Integer.parseInt(u4s5.getText()) <= 100) ||
                                    !(Integer.parseInt(u5s1.getText()) >= 0 && Integer.parseInt(u5s1.getText()) <= 100) ||
                                    !(Integer.parseInt(u5s2.getText()) >= 0 && Integer.parseInt(u5s2.getText()) <= 100) ||
                                    !(Integer.parseInt(u5s3.getText()) >= 0 && Integer.parseInt(u5s3.getText()) <= 100) ||
                                    !(Integer.parseInt(u5s4.getText()) >= 0 && Integer.parseInt(u5s4.getText()) <= 100) ||
                                    !(Integer.parseInt(u5s5.getText()) >= 0 && Integer.parseInt(u5s5.getText()) <= 100)) {
                                error.setText("Grade must be between 0 & 100");
                                error.setVisible(true);
                            } else {
                                List<Integer> marks = new ArrayList<>();
                                marks.add(Integer.parseInt(u1s1.getText()));
                                marks.add(Integer.parseInt(u1s2.getText()));
                                marks.add(Integer.parseInt(u1s3.getText()));
                                marks.add(Integer.parseInt(u1s4.getText()));
                                marks.add(Integer.parseInt(u1s5.getText()));
                                marks.add(Integer.parseInt(u2s1.getText()));
                                marks.add(Integer.parseInt(u2s2.getText()));
                                marks.add(Integer.parseInt(u2s3.getText()));
                                marks.add(Integer.parseInt(u2s4.getText()));
                                marks.add(Integer.parseInt(u2s5.getText()));
                                marks.add(Integer.parseInt(u3s1.getText()));
                                marks.add(Integer.parseInt(u3s2.getText()));
                                marks.add(Integer.parseInt(u3s3.getText()));
                                marks.add(Integer.parseInt(u3s4.getText()));
                                marks.add(Integer.parseInt(u3s5.getText()));
                                marks.add(Integer.parseInt(u4s1.getText()));
                                marks.add(Integer.parseInt(u4s2.getText()));
                                marks.add(Integer.parseInt(u4s3.getText()));
                                marks.add(Integer.parseInt(u4s4.getText()));
                                marks.add(Integer.parseInt(u4s5.getText()));
                                marks.add(Integer.parseInt(u5s1.getText()));
                                marks.add(Integer.parseInt(u5s2.getText()));
                                marks.add(Integer.parseInt(u5s3.getText()));
                                marks.add(Integer.parseInt(u5s4.getText()));
                                marks.add(Integer.parseInt(u5s5.getText()));
                                student.addGrade(new Grades(course.getUuid(), marks));
                                student.save();
                                frame.hide();
                                error.setVisible(false);
                                new GetStudentGrades().getStudentGrades(staff);
                            }
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        error.setVisible(false);
                        new GetStudentGrades().getStudentGrades(staff);
                    }
                }
        );
    }

    private static void setItems(Course c, Student s) {
        unit1.setText(c.getUnit(1).getName());
        unit2.setText(c.getUnit(2).getName());
        unit3.setText(c.getUnit(3).getName());
        unit4.setText(c.getUnit(4).getName());
        unit5.setText(c.getUnit(5).getName());

        Grades course = null;
        boolean exists = false;
        for (Grades g : s.getGrades()) {
            if (g.getCourseUUID().toString().equals(c.getUuid().toString()))  {
                exists = true;
                course = g;
            }
        }
        if (exists) {
            u1s1.setText(String.valueOf(course.getMark(1)));
            u1s2.setText(String.valueOf(course.getMark(2)));
            u1s3.setText(String.valueOf(course.getMark(3)));
            u1s4.setText(String.valueOf(course.getMark(4)));
            u1s5.setText(String.valueOf(course.getMark(5)));

            u2s1.setText(String.valueOf(course.getMark(6)));
            u2s2.setText(String.valueOf(course.getMark(7)));
            u2s3.setText(String.valueOf(course.getMark(8)));
            u2s4.setText(String.valueOf(course.getMark(9)));
            u2s5.setText(String.valueOf(course.getMark(10)));

            u3s1.setText(String.valueOf(course.getMark(11)));
            u3s2.setText(String.valueOf(course.getMark(12)));
            u3s3.setText(String.valueOf(course.getMark(13)));
            u3s4.setText(String.valueOf(course.getMark(14)));
            u3s5.setText(String.valueOf(course.getMark(15)));

            u4s1.setText(String.valueOf(course.getMark(16)));
            u4s2.setText(String.valueOf(course.getMark(17)));
            u4s3.setText(String.valueOf(course.getMark(18)));
            u4s4.setText(String.valueOf(course.getMark(19)));
            u4s5.setText(String.valueOf(course.getMark(20)));

            u5s1.setText(String.valueOf(course.getMark(21)));
            u5s2.setText(String.valueOf(course.getMark(22)));
            u5s3.setText(String.valueOf(course.getMark(23)));
            u5s4.setText(String.valueOf(course.getMark(24)));
            u5s5.setText(String.valueOf(course.getMark(25)));
        } else {
            u1s1.setText("0");
            u1s2.setText("0");
            u1s3.setText("0");
            u1s4.setText("0");
            u1s5.setText("0");

            u2s1.setText("0");
            u2s2.setText("0");
            u2s3.setText("0");
            u2s4.setText("0");
            u2s5.setText("0");

            u3s1.setText("0");
            u3s2.setText("0");
            u3s3.setText("0");
            u3s4.setText("0");
            u3s5.setText("0");

            u4s1.setText("0");
            u4s2.setText("0");
            u4s3.setText("0");
            u4s4.setText("0");
            u4s5.setText("0");

            u5s1.setText("0");
            u5s2.setText("0");
            u5s3.setText("0");
            u5s4.setText("0");
            u5s5.setText("0");
        }
    }
}
