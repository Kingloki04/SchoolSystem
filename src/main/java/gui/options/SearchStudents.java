package gui.options;

import gui.OptionMenu;
import gui.options.edit.EditStudent;
import lombok.Getter;
import objects.Staff;
import objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class SearchStudents {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel searchLabel = new JLabel("Enter a student username:");
    private static final JTextField search = new JTextField();
    private static final JButton searchButton = new JButton("Search");
    private static final JLabel searchResult = new JLabel();
    private static final JButton back = new JButton("Back");

    public void student(Staff staff, Student student) {
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
        searchResult.setVisible(false);
        panel.add(searchResult);

        back.setBounds(720, 5, 75, 25);
        panel.add(back);

        frame.setVisible(true);

        searchButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        searchResult.setVisible(false);
                        Student searched = Student.getByUsername(search.getText());
                        if (searched != null) {
                            if (staff != null) {
                                frame.hide();
                                search.setText("");
                                searchResult.setVisible(false);
                                new EditStudent().editStudent(staff, student, searched);
                            }
                            if (student != null) {
                                frame.hide();
                                search.setText("");
                                searchResult.setVisible(false);
                                new EditStudent().editStudent(staff, student, searched);
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
