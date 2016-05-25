package Interface;

import Interface.ComponentsFactory.*;
import Logic.ManagmentSystem;
import Logic.Proxy.ProxyManagmentSystem;
import Logic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class SignIn extends JFrame implements ActionListener
{
    JButton signInBtn, registerBtn;
    JPanel panel;
    JLabel emailLab, passwordLab;
    final JTextField emailTxt, passwordTxt;
    ComponentsCreationManagment componentsCreationManagment = new ComponentsCreationManagment(FactoryProducer.getFactory("components"));
    WindowCreationManagment windowCreationManagment = new WindowCreationManagment(FactoryProducer.getFactory("windows"));

    public SignIn()
    {
        JFrame frame = new JFrame("Sign In");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());


        emailLab = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
        emailLab.setText("Email: ");
        emailTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
        emailTxt.setColumns(15);
        emailTxt.setText("nastia@mail.ru");

        passwordLab = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
        passwordLab.setText("Password: ");
        passwordTxt =  ((JPasswordField) componentsCreationManagment.createComponent("JPasswordField"));
        passwordTxt.setColumns(15);
        passwordTxt.setText("1111");

        signInBtn = ((JButton) componentsCreationManagment.createComponent("JButton"));
        signInBtn.setText("Sign In");

        registerBtn = ((JButton) componentsCreationManagment.createComponent("JButton"));
        registerBtn.setText("Sign Up");

        panel = ((JPanel) componentsCreationManagment.createComponent("JPanel"));


        frame.add(emailLab, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(emailTxt, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(passwordLab, new GridBagConstraints(0, 1, 1, 1, 1, 1,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(2, 2, 2, 2), 0, 0));

        frame.add(passwordTxt, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(signInBtn, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(registerBtn, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.pack();
        frame.setVisible(true);
        signInBtn.addActionListener(this);
        registerBtn.addActionListener(this);

    }


    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command) {

            case "Sign In":

                if (emailTxt.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (passwordTxt.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String email = emailTxt.getText();
                String password = passwordTxt.getText();

                User foundUser = ProxyManagmentSystem.getInstance().getUserByEmail(email);

                if (foundUser == null) {

                    JOptionPane.showMessageDialog(this, "Input email is not correct", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                else if (!foundUser.getPassword().equals(password)) {

                    JOptionPane.showMessageDialog(this, "Your password is not correct", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }

                JOptionPane.showMessageDialog(this, "You signed in successfully", "Ok", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                UserPage userPage = null;
                try {
                    userPage = new UserPage(ProxyManagmentSystem.getInstance().getUserByEmail(email));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                userPage.setVisible(true);

                break;

            case "Sign Up":

                try {
                    SignUp signUp = new SignUp();
                    signUp.setVisible(true);
                }

                catch (IOException e1) {
                    e1.printStackTrace();
                }

                break;
        }
    }

    public static void main(String arg[]) {

        SignIn frame = new SignIn();

    }
}
