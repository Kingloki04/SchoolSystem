package gui.options.grades.student;

import hidden.Private;
import managers.DatabaseManager;
import objects.Course;
import objects.Grades;
import objects.Staff;
import objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Marks {

    private static final JFrame frame = new JFrame("Marks");
    private static final JPanel panel = new JPanel();
    private static final JComboBox courses = new JComboBox();
    private static final JLabel finalMark = new JLabel();
    private static final JLabel unit1 = new JLabel();
    private static final JLabel unit2 = new JLabel();
    private static final JLabel unit3 = new JLabel();
    private static final JLabel unit4 = new JLabel();
    private static final JLabel unit5 = new JLabel();
    private static final JLabel teacher = new JLabel();
    private static final JButton back = new JButton("Back");


    private static String teacherName;
    private static int finalMarkValue, unit1Value, unit2Value, unit3Value, unit4Value, unit5Value;

    public void marks(Student student) {

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        Map<String, Staff> staff = new HashMap<>();
        Map<String, Grades> markList = new HashMap<>();
        for (Grades g : student.getGrades()) {
            courses.addItem(Course.getByUUID(g.getCourseUUID()).getCode());
            staff.put(Course.getByUUID(g.getCourseUUID()).getCode(), Course.getByUUID(g.getCourseUUID()).getTeacher());
            markList.put(Course.getByUUID(g.getCourseUUID()).getCode(), g);
        }
        courses.setBounds(5, 5, 200, 25);
        panel.add(courses);

        finalMark.setBounds(250, 5, 200, 25);
        panel.add(finalMark);
        unit1.setBounds(250, 35, 200, 25);
        panel.add(unit1);
        unit2.setBounds(250, 65, 200, 25);
        panel.add(unit2);
        unit3.setBounds(250, 95, 200, 25);
        panel.add(unit3);
        unit4.setBounds(250, 125, 200, 25);
        panel.add(unit4);
        unit5.setBounds(250, 155, 200, 25);
        panel.add(unit5);
        teacher.setBounds(250, 185, 200, 25);
        panel.add(teacher);

        Grades marks = markList.get(courses.getSelectedItem().toString());
        Staff s = staff.get(courses.getSelectedItem().toString());
        Course c = Course.getByCode(courses.getSelectedItem().toString(), s);
        unit1Value = ((c.getUnit(1).getSection(1).getWeight() * marks.getMark(1)) +
                (c.getUnit(1).getSection(2).getWeight() * marks.getMark(2)) +
                (c.getUnit(1).getSection(3).getWeight() * marks.getMark(3)) +
                (c.getUnit(1).getSection(4).getWeight() * marks.getMark(4)) +
                (c.getUnit(1).getSection(5).getWeight() * marks.getMark(5))) / 100;
        unit2Value = ((c.getUnit(2).getSection(1).getWeight() * marks.getMark(6)) +
                (c.getUnit(2).getSection(2).getWeight() * marks.getMark(7)) +
                (c.getUnit(2).getSection(3).getWeight() * marks.getMark(8)) +
                (c.getUnit(2).getSection(4).getWeight() * marks.getMark(9)) +
                (c.getUnit(2).getSection(5).getWeight() * marks.getMark(10))) / 100;
        unit3Value = ((c.getUnit(3).getSection(1).getWeight() * marks.getMark(11)) +
                (c.getUnit(3).getSection(2).getWeight() * marks.getMark(12)) +
                (c.getUnit(3).getSection(3).getWeight() * marks.getMark(13)) +
                (c.getUnit(3).getSection(4).getWeight() * marks.getMark(14)) +
                (c.getUnit(3).getSection(5).getWeight() * marks.getMark(15))) / 100;
        unit4Value = ((c.getUnit(4).getSection(1).getWeight() * marks.getMark(16)) +
                (c.getUnit(4).getSection(2).getWeight() * marks.getMark(17)) +
                (c.getUnit(4).getSection(3).getWeight() * marks.getMark(18)) +
                (c.getUnit(4).getSection(4).getWeight() * marks.getMark(19)) +
                (c.getUnit(4).getSection(5).getWeight() * marks.getMark(20))) / 100;
        unit5Value = ((c.getUnit(5).getSection(1).getWeight() * marks.getMark(21)) +
                (c.getUnit(5).getSection(2).getWeight() * marks.getMark(22)) +
                (c.getUnit(5).getSection(3).getWeight() * marks.getMark(23)) +
                (c.getUnit(5).getSection(4).getWeight() * marks.getMark(24)) +
                (c.getUnit(5).getSection(5).getWeight() * marks.getMark(25))) / 100;
        finalMarkValue = ((c.getUnit(1).getWeight() * unit1Value) +
                (c.getUnit(2).getWeight() * unit2Value) +
                (c.getUnit(3).getWeight() * unit3Value) +
                (c.getUnit(4).getWeight() * unit4Value) +
                (c.getUnit(5).getWeight() * unit5Value)) / 100;
        teacherName = s.getFirstName() + " " + s.getLastName();
        setItems(Course.getByCode(courses.getSelectedItem().toString(), staff.get(courses.getSelectedItem().toString())));

        frame.setVisible(true);

        courses.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Grades marks = markList.get(courses.getSelectedItem().toString());
                        Staff s = staff.get(courses.getSelectedItem().toString());
                        Course c = Course.getByCode(courses.getSelectedItem().toString(), s);
                        // grade = ((weight * grade) + (weight * grade)) / 100
                        unit1Value = ((c.getUnit(1).getSection(1).getWeight() * marks.getMark(1)) +
                                (c.getUnit(1).getSection(2).getWeight() * marks.getMark(2)) +
                                (c.getUnit(1).getSection(3).getWeight() * marks.getMark(3)) +
                                (c.getUnit(1).getSection(4).getWeight() * marks.getMark(4)) +
                                (c.getUnit(1).getSection(5).getWeight() * marks.getMark(5))) / 100;
                        unit2Value = ((c.getUnit(2).getSection(1).getWeight() * marks.getMark(6)) +
                                (c.getUnit(2).getSection(2).getWeight() * marks.getMark(7)) +
                                (c.getUnit(2).getSection(3).getWeight() * marks.getMark(8)) +
                                (c.getUnit(2).getSection(4).getWeight() * marks.getMark(9)) +
                                (c.getUnit(2).getSection(5).getWeight() * marks.getMark(10))) / 100;
                        unit3Value = ((c.getUnit(3).getSection(1).getWeight() * marks.getMark(11)) +
                                (c.getUnit(3).getSection(2).getWeight() * marks.getMark(12)) +
                                (c.getUnit(3).getSection(3).getWeight() * marks.getMark(13)) +
                                (c.getUnit(3).getSection(4).getWeight() * marks.getMark(14)) +
                                (c.getUnit(3).getSection(5).getWeight() * marks.getMark(15))) / 100;
                        unit4Value = ((c.getUnit(4).getSection(1).getWeight() * marks.getMark(16)) +
                                (c.getUnit(4).getSection(2).getWeight() * marks.getMark(17)) +
                                (c.getUnit(4).getSection(3).getWeight() * marks.getMark(18)) +
                                (c.getUnit(4).getSection(4).getWeight() * marks.getMark(19)) +
                                (c.getUnit(4).getSection(5).getWeight() * marks.getMark(20))) / 100;
                        unit5Value = ((c.getUnit(5).getSection(1).getWeight() * marks.getMark(21)) +
                                (c.getUnit(5).getSection(2).getWeight() * marks.getMark(22)) +
                                (c.getUnit(5).getSection(3).getWeight() * marks.getMark(23)) +
                                (c.getUnit(5).getSection(4).getWeight() * marks.getMark(24)) +
                                (c.getUnit(5).getSection(5).getWeight() * marks.getMark(25))) / 100;
                        finalMarkValue = ((c.getUnit(1).getWeight() * unit1Value) +
                                (c.getUnit(2).getWeight() * unit2Value) +
                                (c.getUnit(3).getWeight() * unit3Value) +
                                (c.getUnit(4).getWeight() * unit4Value) +
                                (c.getUnit(5).getWeight() * unit5Value)) / 100;
                        teacherName = s.getFirstName() + " " + s.getLastName();
                        setItems(Course.getByCode(courses.getSelectedItem().toString(), staff.get(courses.getSelectedItem().toString())));
                    }
                }
        );
    }

    private static void setItems(Course c) {
        finalMark.setText(String.valueOf("Final mark: " + finalMarkValue) + "%");
        unit1.setText(String.valueOf("Unit 1 mark: " + unit1Value) + "%");
        unit2.setText(String.valueOf("Unit 2 mark: " + unit2Value) + "%");
        unit3.setText(String.valueOf("Unit 3 mark: " + unit3Value) + "%");
        unit4.setText(String.valueOf("Unit 4 mark: " + unit4Value) + "%");
        unit5.setText(String.valueOf("Unit 5 mark: " + unit5Value) + "%");
        teacher.setText("Teacher: " + teacherName);
    }
}
