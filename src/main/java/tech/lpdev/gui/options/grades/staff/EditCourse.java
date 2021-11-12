package tech.lpdev.gui.options.grades.staff;

import tech.lpdev.gui.options.grades.GradesMenu;
import tech.lpdev.objects.Course;
import tech.lpdev.objects.Section;
import tech.lpdev.objects.Staff;
import tech.lpdev.objects.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditCourse {

    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    private static JLabel unitName = new JLabel("Unit Names:");
    private static JTextField unitName1 = new JTextField();
    private static JTextField unitName2 = new JTextField();
    private static JTextField unitName3 = new JTextField();
    private static JTextField unitName4 = new JTextField();
    private static JTextField unitName5 = new JTextField();
    private static JLabel unitWeight = new JLabel("Unit Weights:");
    private static JTextField unitWeight1 = new JTextField();
    private static JTextField unitWeight2 = new JTextField();
    private static JTextField unitWeight3 = new JTextField();
    private static JTextField unitWeight4 = new JTextField();
    private static JTextField unitWeight5 = new JTextField();

    private static JLabel sectionName1 = new JLabel("Section 1 Names:");
    private static JTextField sectionName11 = new JTextField();
    private static JTextField sectionName12 = new JTextField();
    private static JTextField sectionName13 = new JTextField();
    private static JTextField sectionName14 = new JTextField();
    private static JTextField sectionName15 = new JTextField();
    private static JLabel sectionWeight1 = new JLabel("Section 1 Weights:");
    private static JTextField sectionWeight11 = new JTextField();
    private static JTextField sectionWeight12 = new JTextField();
    private static JTextField sectionWeight13 = new JTextField();
    private static JTextField sectionWeight14 = new JTextField();
    private static JTextField sectionWeight15 = new JTextField();

    private static JLabel sectionName2 = new JLabel("Section 2 Names:");
    private static JTextField sectionName21 = new JTextField();
    private static JTextField sectionName22 = new JTextField();
    private static JTextField sectionName23 = new JTextField();
    private static JTextField sectionName24 = new JTextField();
    private static JTextField sectionName25 = new JTextField();
    private static JLabel sectionWeight2 = new JLabel("Section 2 Weights:");
    private static JTextField sectionWeight21 = new JTextField();
    private static JTextField sectionWeight22 = new JTextField();
    private static JTextField sectionWeight23 = new JTextField();
    private static JTextField sectionWeight24 = new JTextField();
    private static JTextField sectionWeight25 = new JTextField();

    private static JLabel sectionName3 = new JLabel("Section 3 Names:");
    private static JTextField sectionName31 = new JTextField();
    private static JTextField sectionName32 = new JTextField();
    private static JTextField sectionName33 = new JTextField();
    private static JTextField sectionName34 = new JTextField();
    private static JTextField sectionName35 = new JTextField();
    private static JLabel sectionWeight3 = new JLabel("Section 3 Weights:");
    private static JTextField sectionWeight31 = new JTextField();
    private static JTextField sectionWeight32 = new JTextField();
    private static JTextField sectionWeight33 = new JTextField();
    private static JTextField sectionWeight34 = new JTextField();
    private static JTextField sectionWeight35 = new JTextField();

    private static JLabel sectionName4 = new JLabel("Section 4 Names:");
    private static JTextField sectionName41 = new JTextField();
    private static JTextField sectionName42 = new JTextField();
    private static JTextField sectionName43 = new JTextField();
    private static JTextField sectionName44 = new JTextField();
    private static JTextField sectionName45 = new JTextField();
    private static JLabel sectionWeight4 = new JLabel("Section 4 Weights:");
    private static JTextField sectionWeight41 = new JTextField();
    private static JTextField sectionWeight42 = new JTextField();
    private static JTextField sectionWeight43 = new JTextField();
    private static JTextField sectionWeight44 = new JTextField();
    private static JTextField sectionWeight45 = new JTextField();

    private static JLabel sectionName5 = new JLabel("Section 5 Names:");
    private static JTextField sectionName51 = new JTextField();
    private static JTextField sectionName52 = new JTextField();
    private static JTextField sectionName53 = new JTextField();
    private static JTextField sectionName54 = new JTextField();
    private static JTextField sectionName55 = new JTextField();
    private static JLabel sectionWeight5 = new JLabel("Section 5 Weights:");
    private static JTextField sectionWeight51 = new JTextField();
    private static JTextField sectionWeight52 = new JTextField();
    private static JTextField sectionWeight53 = new JTextField();
    private static JTextField sectionWeight54 = new JTextField();
    private static JTextField sectionWeight55 = new JTextField();

    private static JLabel courseNameLabel = new JLabel("Course Name");
    private static JTextField courseName = new JTextField();
    private static JLabel courseCodeLabel = new JLabel("Course Code");
    private static JTextField courseCode = new JTextField();
    private static JButton save = new JButton("Save");
    private static JButton back = new JButton("Back");
    private static JLabel error = new JLabel();

    public void editCourse(Staff staff, Course c) {

        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        if (c == null) System.out.println("Null");
        else setItems(c);

        unitName.setBounds(5, 5, 125, 25);
        unitWeight.setBounds(5, 35, 125, 25);
        sectionName1.setBounds(5, 65, 125, 25);
        sectionWeight1.setBounds(5, 95, 125, 25);
        sectionName2.setBounds(5, 125, 125, 25);
        sectionWeight2.setBounds(5, 155, 125, 25);
        sectionName3.setBounds(5, 185, 125, 25);
        sectionWeight3.setBounds(5, 215, 125, 25);
        sectionName4.setBounds(5, 245, 125, 25);
        sectionWeight4.setBounds(5, 275, 125, 25);
        sectionName5.setBounds(5, 305, 125, 25);
        sectionWeight5.setBounds(5, 335, 125, 25);

        unitName1.setBounds(125, 5, 200, 25);
        unitName2.setBounds(330, 5, 200, 25);
        unitName3.setBounds(535, 5, 200, 25);
        unitName4.setBounds(740, 5, 200, 25);
        unitName5.setBounds(945, 5, 200, 25);
        unitWeight1.setBounds(125, 35, 200, 25);
        unitWeight2.setBounds(330, 35, 200, 25);
        unitWeight3.setBounds(535, 35, 200, 25);
        unitWeight4.setBounds(740, 35, 200, 25);
        unitWeight5.setBounds(945, 35, 200, 25);
        sectionName11.setBounds(125, 65, 200, 25);
        sectionName12.setBounds(330, 65, 200, 25);
        sectionName13.setBounds(535, 65, 200, 25);
        sectionName14.setBounds(740, 65, 200, 25);
        sectionName15.setBounds(945, 65, 200, 25);
        sectionWeight11.setBounds(125, 95, 200, 25);
        sectionWeight12.setBounds(330, 95, 200, 25);
        sectionWeight13.setBounds(535, 95, 200, 25);
        sectionWeight14.setBounds(740, 95, 200, 25);
        sectionWeight15.setBounds(945, 95, 200, 25);
        sectionName21.setBounds(125, 125, 200, 25);
        sectionName22.setBounds(330, 125, 200, 25);
        sectionName23.setBounds(535, 125, 200, 25);
        sectionName24.setBounds(740, 125, 200, 25);
        sectionName25.setBounds(945, 125, 200, 25);
        sectionWeight21.setBounds(125, 155, 200, 25);
        sectionWeight22.setBounds(330, 155, 200, 25);
        sectionWeight23.setBounds(535, 155, 200, 25);
        sectionWeight24.setBounds(740, 155, 200, 25);
        sectionWeight25.setBounds(945, 155, 200, 25);
        sectionName31.setBounds(125, 185, 200, 25);
        sectionName32.setBounds(330, 185, 200, 25);
        sectionName33.setBounds(535, 185, 200, 25);
        sectionName34.setBounds(740, 185, 200, 25);
        sectionName35.setBounds(945, 185, 200, 25);
        sectionWeight31.setBounds(125, 215, 200, 25);
        sectionWeight32.setBounds(330, 215, 200, 25);
        sectionWeight33.setBounds(535, 215, 200, 25);
        sectionWeight34.setBounds(740, 215, 200, 25);
        sectionWeight35.setBounds(945, 215, 200, 25);
        sectionName41.setBounds(125, 245, 200, 25);
        sectionName42.setBounds(330, 245, 200, 25);
        sectionName43.setBounds(535, 245, 200, 25);
        sectionName44.setBounds(740, 245, 200, 25);
        sectionName45.setBounds(945, 245, 200, 25);
        sectionWeight41.setBounds(125, 275, 200, 25);
        sectionWeight42.setBounds(330, 275, 200, 25);
        sectionWeight43.setBounds(535, 275, 200, 25);
        sectionWeight44.setBounds(740, 275, 200, 25);
        sectionWeight45.setBounds(945, 275, 200, 25);
        sectionName51.setBounds(125, 305, 200, 25);
        sectionName52.setBounds(330, 305, 200, 25);
        sectionName53.setBounds(535, 305, 200, 25);
        sectionName54.setBounds(740, 305, 200, 25);
        sectionName55.setBounds(945, 305, 200, 25);
        sectionWeight51.setBounds(125, 335, 200, 25);
        sectionWeight52.setBounds(330, 335, 200, 25);
        sectionWeight53.setBounds(535, 335, 200, 25);
        sectionWeight54.setBounds(740, 335, 200, 25);
        sectionWeight55.setBounds(945, 335, 200, 25);

        panel.add(unitName);
        panel.add(unitWeight);
        panel.add(sectionName1);
        panel.add(sectionWeight1);
        panel.add(sectionName2);
        panel.add(sectionWeight2);
        panel.add(sectionName3);
        panel.add(sectionWeight3);
        panel.add(sectionName4);
        panel.add(sectionWeight4);
        panel.add(sectionName5);
        panel.add(sectionWeight5);

        panel.add(unitName1);
        panel.add(unitName2);
        panel.add(unitName3);
        panel.add(unitName4);
        panel.add(unitName5);
        panel.add(unitWeight1);
        panel.add(unitWeight2);
        panel.add(unitWeight3);
        panel.add(unitWeight4);
        panel.add(unitWeight5);
        panel.add(sectionName11);
        panel.add(sectionName12);
        panel.add(sectionName13);
        panel.add(sectionName14);
        panel.add(sectionName15);
        panel.add(sectionWeight11);
        panel.add(sectionWeight12);
        panel.add(sectionWeight13);
        panel.add(sectionWeight14);
        panel.add(sectionWeight15);
        panel.add(sectionName21);
        panel.add(sectionName22);
        panel.add(sectionName23);
        panel.add(sectionName24);
        panel.add(sectionName25);
        panel.add(sectionWeight21);
        panel.add(sectionWeight22);
        panel.add(sectionWeight23);
        panel.add(sectionWeight24);
        panel.add(sectionWeight25);
        panel.add(sectionName31);
        panel.add(sectionName32);
        panel.add(sectionName33);
        panel.add(sectionName34);
        panel.add(sectionName35);
        panel.add(sectionWeight31);
        panel.add(sectionWeight32);
        panel.add(sectionWeight33);
        panel.add(sectionWeight34);
        panel.add(sectionWeight35);
        panel.add(sectionName41);
        panel.add(sectionName42);
        panel.add(sectionName43);
        panel.add(sectionName44);
        panel.add(sectionName45);
        panel.add(sectionWeight41);
        panel.add(sectionWeight42);
        panel.add(sectionWeight43);
        panel.add(sectionWeight44);
        panel.add(sectionWeight45);
        panel.add(sectionName51);
        panel.add(sectionName52);
        panel.add(sectionName53);
        panel.add(sectionName54);
        panel.add(sectionName55);
        panel.add(sectionWeight51);
        panel.add(sectionWeight52);
        panel.add(sectionWeight53);
        panel.add(sectionWeight54);
        panel.add(sectionWeight55);

        courseNameLabel.setBounds(5, 400, 125, 25);
        panel.add(courseNameLabel);
        courseName.setBounds(125, 400, 200, 25);
        panel.add(courseName);
        courseCodeLabel.setBounds(5, 430, 125, 25);
        panel.add(courseCodeLabel);
        courseCode.setBounds(125, 430, 200, 25);
        panel.add(courseCode);
        save.setBounds(0, 460, 125, 25);
        save.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(save);
        back.setBounds(1070, 460, 125, 25);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(back);
        error.setBounds(0, 490, 1200, 25);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.red);
        panel.add(error);

        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int[] course, firstUnit, secondUnit, thirdUnit, fourthUnit, fifthUnit;
                        course = new int[] {Integer.parseInt(unitWeight1.getText()),
                                Integer.parseInt(unitWeight2.getText()),
                                Integer.parseInt(unitWeight3.getText()),
                                Integer.parseInt(unitWeight4.getText()),
                                Integer.parseInt(unitWeight5.getText())};

                        firstUnit = new int[] {Integer.parseInt(sectionWeight11.getText()),
                                Integer.parseInt(sectionWeight21.getText()),
                                Integer.parseInt(sectionWeight31.getText()),
                                Integer.parseInt(sectionWeight41.getText()),
                                Integer.parseInt(sectionWeight51.getText())};

                        secondUnit = new int[] {Integer.parseInt(sectionWeight12.getText()),
                                Integer.parseInt(sectionWeight22.getText()),
                                Integer.parseInt(sectionWeight32.getText()),
                                Integer.parseInt(sectionWeight42.getText()),
                                Integer.parseInt(sectionWeight52.getText())};

                        thirdUnit = new int[] {Integer.parseInt(sectionWeight13.getText()),
                                Integer.parseInt(sectionWeight23.getText()),
                                Integer.parseInt(sectionWeight33.getText()),
                                Integer.parseInt(sectionWeight43.getText()),
                                Integer.parseInt(sectionWeight53.getText())};

                        fourthUnit = new int[] {Integer.parseInt(sectionWeight14.getText()),
                                Integer.parseInt(sectionWeight24.getText()),
                                Integer.parseInt(sectionWeight34.getText()),
                                Integer.parseInt(sectionWeight44.getText()),
                                Integer.parseInt(sectionWeight54.getText())};

                        fifthUnit = new int[] {Integer.parseInt(sectionWeight15.getText()),
                                Integer.parseInt(sectionWeight25.getText()),
                                Integer.parseInt(sectionWeight35.getText()),
                                Integer.parseInt(sectionWeight45.getText()),
                                Integer.parseInt(sectionWeight55.getText())};

                        error.setVisible(false);
                        if (course[0] + course[1] + course[2] + course[3] + course[4] != 100) {
                            error.setText("Please make sure that the weights of each unit adds up to 100");
                            error.setVisible(true);
                        } else if (firstUnit[0] + firstUnit[1] + firstUnit[2] + firstUnit[3] + firstUnit[4] != 100) {
                            error.setText("Please make sure that the weights of each section in unit 1 add up to 100");
                            error.setVisible(true);
                        } else if (secondUnit[0] + secondUnit[1] + secondUnit[2] + secondUnit[3] + secondUnit[4] != 100) {
                            error.setText("Please make sure that the weights of each section in unit 2 add up to 100");
                            error.setVisible(true);
                        } else if (thirdUnit[0] + thirdUnit[1] + thirdUnit[2] + thirdUnit[3] + thirdUnit[4] != 100) {
                            error.setText("Please make sure that the weights of each section in unit 3 add up to 100");
                            error.setVisible(true);
                        } else if (fourthUnit[0] + fourthUnit[1] + fourthUnit[2] + fourthUnit[3] + fourthUnit[4] != 100) {
                            error.setText("Please make sure that the weights of each section in unit 4 add up to 100");
                            error.setVisible(true);
                        } else if (fifthUnit[0] + fifthUnit[1] + fifthUnit[2] + fifthUnit[3] + fifthUnit[4] != 100) {
                            error.setText("Please make sure that the weights of each section in unit 5 add up to 100");
                            error.setVisible(true);
                        } else if (courseName.getText().equals("")) {
                            error.setText("Please name the course");
                            error.setVisible(true);
                        } else if (courseCode.getText().equals("")) {
                            error.setText("Please give the course a code");
                            error.setVisible(true);
                        } else if (unitName1.getText().equals("") ||
                                unitName2.getText().equals("") ||
                                unitName3.getText().equals("") ||
                                unitName4.getText().equals("") ||
                                unitName5.getText().equals("") ||
                                sectionName11.getText().equals("") ||
                                sectionName12.getText().equals("") ||
                                sectionName13.getText().equals("") ||
                                sectionName14.getText().equals("") ||
                                sectionName15.getText().equals("") ||
                                sectionName21.getText().equals("") ||
                                sectionName22.getText().equals("") ||
                                sectionName23.getText().equals("") ||
                                sectionName24.getText().equals("") ||
                                sectionName25.getText().equals("") ||
                                sectionName31.getText().equals("") ||
                                sectionName32.getText().equals("") ||
                                sectionName33.getText().equals("") ||
                                sectionName34.getText().equals("") ||
                                sectionName35.getText().equals("") ||
                                sectionName41.getText().equals("") ||
                                sectionName42.getText().equals("") ||
                                sectionName43.getText().equals("") ||
                                sectionName44.getText().equals("") ||
                                sectionName45.getText().equals("") ||
                                sectionName51.getText().equals("") ||
                                sectionName52.getText().equals("") ||
                                sectionName53.getText().equals("") ||
                                sectionName54.getText().equals("") ||
                                sectionName55.getText().equals("")) {
                            error.setText("One or more name boxes are empty");
                            error.setVisible(true);
                        } else {
                            java.util.List<Section> sections1 = new ArrayList<>();
                            java.util.List<Section> sections2 = new ArrayList<>();
                            java.util.List<Section> sections3 = new ArrayList<>();
                            java.util.List<Section> sections4 = new ArrayList<>();
                            java.util.List<Section> sections5 = new ArrayList<>();
                            sections1.add(new Section(sectionName11.getText(), Integer.parseInt(sectionWeight11.getText())));
                            sections1.add(new Section(sectionName12.getText(), Integer.parseInt(sectionWeight12.getText())));
                            sections1.add(new Section(sectionName13.getText(), Integer.parseInt(sectionWeight13.getText())));
                            sections1.add(new Section(sectionName14.getText(), Integer.parseInt(sectionWeight14.getText())));
                            sections1.add(new Section(sectionName15.getText(), Integer.parseInt(sectionWeight15.getText())));
                            sections2.add(new Section(sectionName21.getText(), Integer.parseInt(sectionWeight21.getText())));
                            sections2.add(new Section(sectionName22.getText(), Integer.parseInt(sectionWeight22.getText())));
                            sections2.add(new Section(sectionName23.getText(), Integer.parseInt(sectionWeight23.getText())));
                            sections2.add(new Section(sectionName24.getText(), Integer.parseInt(sectionWeight24.getText())));
                            sections2.add(new Section(sectionName25.getText(), Integer.parseInt(sectionWeight25.getText())));
                            sections3.add(new Section(sectionName31.getText(), Integer.parseInt(sectionWeight31.getText())));
                            sections3.add(new Section(sectionName32.getText(), Integer.parseInt(sectionWeight32.getText())));
                            sections3.add(new Section(sectionName33.getText(), Integer.parseInt(sectionWeight33.getText())));
                            sections3.add(new Section(sectionName34.getText(), Integer.parseInt(sectionWeight34.getText())));
                            sections3.add(new Section(sectionName35.getText(), Integer.parseInt(sectionWeight35.getText())));
                            sections4.add(new Section(sectionName41.getText(), Integer.parseInt(sectionWeight41.getText())));
                            sections4.add(new Section(sectionName42.getText(), Integer.parseInt(sectionWeight42.getText())));
                            sections4.add(new Section(sectionName43.getText(), Integer.parseInt(sectionWeight43.getText())));
                            sections4.add(new Section(sectionName44.getText(), Integer.parseInt(sectionWeight44.getText())));
                            sections4.add(new Section(sectionName45.getText(), Integer.parseInt(sectionWeight45.getText())));
                            sections5.add(new Section(sectionName51.getText(), Integer.parseInt(sectionWeight51.getText())));
                            sections5.add(new Section(sectionName52.getText(), Integer.parseInt(sectionWeight52.getText())));
                            sections5.add(new Section(sectionName53.getText(), Integer.parseInt(sectionWeight53.getText())));
                            sections5.add(new Section(sectionName54.getText(), Integer.parseInt(sectionWeight54.getText())));
                            sections5.add(new Section(sectionName55.getText(), Integer.parseInt(sectionWeight55.getText())));

                            List<Unit> units = new ArrayList<>();
                            units.add(new Unit(unitName1.getText(), Integer.parseInt(unitWeight1.getText()), sections1));
                            units.add(new Unit(unitName2.getText(), Integer.parseInt(unitWeight2.getText()), sections2));
                            units.add(new Unit(unitName3.getText(), Integer.parseInt(unitWeight3.getText()), sections3));
                            units.add(new Unit(unitName4.getText(), Integer.parseInt(unitWeight4.getText()), sections4));
                            units.add(new Unit(unitName5.getText(), Integer.parseInt(unitWeight5.getText()), sections5));

                            c.setName(courseName.getText());
                            c.setCode(courseCode.getText());
                            c.setUnits(units);
                            c.save();

                            frame.hide();
                            error.setVisible(false);
                            new GradesMenu().gradesMenu(staff);
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
                        new SearchCourses().searchCourses(staff);
                    }
                }
        );

        frame.setVisible(true);
    }

    private static void setItems(Course c) {

        unitName1.setText(c.getUnit(1).getName());
        unitName2.setText(c.getUnit(2).getName());
        unitName3.setText(c.getUnit(3).getName());
        unitName4.setText(c.getUnit(4).getName());
        unitName5.setText(c.getUnit(5).getName());
        unitWeight1.setText(String.valueOf(c.getUnit(1).getWeight()));
        unitWeight2.setText(String.valueOf(c.getUnit(2).getWeight()));
        unitWeight3.setText(String.valueOf(c.getUnit(3).getWeight()));
        unitWeight4.setText(String.valueOf(c.getUnit(4).getWeight()));
        unitWeight5.setText(String.valueOf(c.getUnit(5).getWeight()));

        sectionName11.setText(c.getUnit(1).getSection(1).getName());
        sectionName12.setText(c.getUnit(1).getSection(2).getName());
        sectionName13.setText(c.getUnit(1).getSection(3).getName());
        sectionName14.setText(c.getUnit(1).getSection(4).getName());
        sectionName15.setText(c.getUnit(1).getSection(5).getName());
        sectionWeight11.setText(String.valueOf(c.getUnit(1).getSection(1).getWeight()));
        sectionWeight12.setText(String.valueOf(c.getUnit(1).getSection(2).getWeight()));
        sectionWeight13.setText(String.valueOf(c.getUnit(1).getSection(3).getWeight()));
        sectionWeight14.setText(String.valueOf(c.getUnit(1).getSection(4).getWeight()));
        sectionWeight15.setText(String.valueOf(c.getUnit(1).getSection(5).getWeight()));

        sectionName21.setText(c.getUnit(2).getSection(1).getName());
        sectionName22.setText(c.getUnit(2).getSection(2).getName());
        sectionName23.setText(c.getUnit(2).getSection(3).getName());
        sectionName24.setText(c.getUnit(2).getSection(4).getName());
        sectionName25.setText(c.getUnit(2).getSection(5).getName());
        sectionWeight21.setText(String.valueOf(c.getUnit(2).getSection(1).getWeight()));
        sectionWeight22.setText(String.valueOf(c.getUnit(2).getSection(2).getWeight()));
        sectionWeight23.setText(String.valueOf(c.getUnit(2).getSection(3).getWeight()));
        sectionWeight24.setText(String.valueOf(c.getUnit(2).getSection(4).getWeight()));
        sectionWeight25.setText(String.valueOf(c.getUnit(2).getSection(5).getWeight()));

        sectionName31.setText(c.getUnit(3).getSection(1).getName());
        sectionName32.setText(c.getUnit(3).getSection(2).getName());
        sectionName33.setText(c.getUnit(3).getSection(3).getName());
        sectionName34.setText(c.getUnit(3).getSection(4).getName());
        sectionName35.setText(c.getUnit(3).getSection(5).getName());
        sectionWeight31.setText(String.valueOf(c.getUnit(3).getSection(1).getWeight()));
        sectionWeight32.setText(String.valueOf(c.getUnit(3).getSection(2).getWeight()));
        sectionWeight33.setText(String.valueOf(c.getUnit(3).getSection(3).getWeight()));
        sectionWeight34.setText(String.valueOf(c.getUnit(3).getSection(4).getWeight()));
        sectionWeight35.setText(String.valueOf(c.getUnit(3).getSection(5).getWeight()));

        sectionName41.setText(c.getUnit(4).getSection(1).getName());
        sectionName42.setText(c.getUnit(4).getSection(2).getName());
        sectionName43.setText(c.getUnit(4).getSection(3).getName());
        sectionName44.setText(c.getUnit(4).getSection(4).getName());
        sectionName45.setText(c.getUnit(4).getSection(5).getName());
        sectionWeight41.setText(String.valueOf(c.getUnit(4).getSection(1).getWeight()));
        sectionWeight42.setText(String.valueOf(c.getUnit(4).getSection(2).getWeight()));
        sectionWeight43.setText(String.valueOf(c.getUnit(4).getSection(3).getWeight()));
        sectionWeight44.setText(String.valueOf(c.getUnit(4).getSection(4).getWeight()));
        sectionWeight45.setText(String.valueOf(c.getUnit(4).getSection(5).getWeight()));

        sectionName51.setText(c.getUnit(5).getSection(1).getName());
        sectionName52.setText(c.getUnit(5).getSection(2).getName());
        sectionName53.setText(c.getUnit(5).getSection(3).getName());
        sectionName54.setText(c.getUnit(5).getSection(4).getName());
        sectionName55.setText(c.getUnit(5).getSection(5).getName());
        sectionWeight51.setText(String.valueOf(c.getUnit(5).getSection(1).getWeight()));
        sectionWeight52.setText(String.valueOf(c.getUnit(5).getSection(2).getWeight()));
        sectionWeight53.setText(String.valueOf(c.getUnit(5).getSection(3).getWeight()));
        sectionWeight54.setText(String.valueOf(c.getUnit(5).getSection(4).getWeight()));
        sectionWeight55.setText(String.valueOf(c.getUnit(5).getSection(5).getWeight()));

        courseName.setText(c.getName());
        courseCode.setText(c.getCode());
        error = new JLabel();
    }
}
