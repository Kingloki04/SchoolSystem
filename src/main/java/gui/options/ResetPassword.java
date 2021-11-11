package gui.options;

import gui.OptionMenu;
import objects.Staff;
import objects.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPassword {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JLabel newPasswordLabel = new JLabel("Enter New Password");
    private static final JLabel verPasswordLabel = new JLabel("Re-Enter New Password");
    private static final JPasswordField newPasswordText = new JPasswordField();
    private static final JPasswordField verPasswordText = new JPasswordField();
    private static final JButton reset = new JButton("Reset");
    private static final JLabel error = new JLabel();
    private static final JButton back = new JButton("Back");


    public void resetPassword(Staff staff, Student student) {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        newPasswordLabel.setBounds(0, 5, 350, 25);
        newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(newPasswordLabel);
        newPasswordText.setBounds(100, 30, 150, 25);
        panel.add(newPasswordText);

        verPasswordLabel.setBounds(0, 55, 350, 25);
        verPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(verPasswordLabel);
        verPasswordText.setBounds(100, 70, 150, 25);
        panel.add(verPasswordText);

        reset.setBounds(125, 100, 100, 25);
        panel.add(reset);

        error.setBounds(0, 125, 350, 25);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.RED);
        panel.add(error);
        error.setVisible(false);

        back.setBounds(125, 145, 100, 25);
        panel.add(back);

        frame.setVisible(true);

        reset.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        error.setVisible(false);
                        if (newPasswordText.getText().equals("") || verPasswordText.getText().equals("")) {
                            error.setText("One or more fields are empty");
                            error.setVisible(true);
                        } else if (!newPasswordText.getText().equals(verPasswordText.getText())) {
                            error.setText("Please make sure both passwords are the same");
                            error.setVisible(true);
                        } else {
                            if (staff != null) {
                                staff.setPassword(newPasswordText.getText());
                                staff.save();
                            }
                            if (student != null) {
                                student.setPassword(newPasswordText.getText());
                                student.save();
                            }
                            System.exit(0);
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.hide();
                        newPasswordText.setText("");
                        verPasswordText.setText("");
                        new OptionMenu().setVisible();
                    }
                }
        );
    }
}
