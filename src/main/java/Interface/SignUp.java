package Interface;

import Interface.ComponentsFactory.ComponentsCreationManagment;
import Interface.ComponentsFactory.FactoryProducer;
import Interface.ComponentsFactory.WindowCreationManagment;
import Logic.City;
import Logic.ManagmentSystem;
import Logic.Proxy.ProxyManagmentSystem;
import Logic.User;
import res.R;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class SignUp extends JDialog implements ActionListener{


    ComponentsCreationManagment componentsCreationManagment = new ComponentsCreationManagment(FactoryProducer.getFactory("components"));
    WindowCreationManagment windowCreationManagment = new WindowCreationManagment(FactoryProducer.getFactory("windows"));

    //B in the end marks that it is button
    private JButton signUpB = ((JButton) componentsCreationManagment.createComponent("JButton"));
    private JButton cancelB = ((JButton) componentsCreationManagment.createComponent("JButton"));


    //L in the end marks that it is label
    private JLabel firstNameL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel surnameL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel patronymicL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel eMailL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel passwordL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel confirmPasswordL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel chooseSexL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel selectLocationL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
    private JLabel ageL = ((JLabel) componentsCreationManagment.createComponent("JLabel"));

    private JTextField firstNameTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
    private JTextField surnameTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
    private JTextField patronymicTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
    private JTextField eMailTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
    private JTextField ageTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
    private JTextField passwordTxt = ((JTextField) componentsCreationManagment.createComponent("JPasswordField"));
    private JTextField confirmPasswordTxt = ((JTextField) componentsCreationManagment.createComponent("JPasswordField"));

    //C in the end marks that it is Combo Box
    private JComboBox chooseSexC = ((JComboBox) componentsCreationManagment.createComponent("JComboBox"));
    private JComboBox selectLocationC;

    public SignUp() throws HeadlessException, IOException {

        setTitle("Sign Up");
        setModal(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(300, 350);

        firstNameL.setText("Your First Name");
        surnameL.setText("Your surname");
        patronymicL.setText("Your patronymic");

        eMailL.setText("Your email");
        passwordL.setText("Your password");
        confirmPasswordL.setText("Confirm password");

        chooseSexL.setText("Choose your sex");
        selectLocationL.setText("Choose your location");
        ageL.setText("Input your age");

        signUpB.setText("Sign Up");
        cancelB.setText("Cancel");

        chooseSexC.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,2,5,5));

        container.add(firstNameL);
        container.add(firstNameTxt);
        container.add(surnameL);
        container.add(surnameTxt);
        container.add(patronymicL);
        container.add(patronymicTxt);
        container.add(eMailL);
        container.add(eMailTxt);
        container.add(passwordL);
        container.add(passwordTxt);
        container.add(confirmPasswordL);
        container.add(confirmPasswordTxt);
        container.add(ageL);
        container.add(ageTxt);
        container.add(chooseSexL);
        container.add(chooseSexC);
        container.add(selectLocationL);

        List<City> cities = ProxyManagmentSystem.getInstance().getCities();
        Collections.sort(cities);
        Vector<String> v = new Vector<>();

        for (City city : cities) {
            v.add(city.getName());
        }

        selectLocationC = new JComboBox(v);
        container.add(selectLocationC);

        signUpB.addActionListener(this);
        cancelB.addActionListener(this);
        signUpB.setName("sign Up");
        cancelB.setName("cancel");
        container.add(signUpB);
        container.add(cancelB);

    }

    public static void main(String[] args) throws IOException {

        SignUp signUp = new SignUp();
        signUp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonPressed = e.getActionCommand();

            if (buttonPressed.equals("Sign Up")) {

                String firstName = firstNameTxt.getText();
                String surname = surnameTxt.getText();
                String patronymic = patronymicTxt.getText();
                String eMail = eMailTxt.getText();
                String password = passwordTxt.getText();
                String confirmPassword = confirmPasswordTxt.getText();
                String age = ageTxt.getText();

                if (firstName.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input first name", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (surname.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input surname", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (patronymic.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input patronymic", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (eMail.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (age.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input age", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if (password.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please input password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (confirmPassword.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please confirm password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!R.matchName(firstName)) {

                    JOptionPane.showMessageDialog(this, "Input first name is invalid\n It should begin from uppercase letter and contain not more than 20 letters", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!R.matchName(surname)) {

                    JOptionPane.showMessageDialog(this, "Input surname is invalid\n It should begin from uppercase letter and contain not more than 20 letters", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!R.matchName(patronymic)) {

                    JOptionPane.showMessageDialog(this, "Input patronymic is invalid\n It should begin from uppercase letter and contain not more than 20 letters", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!R.matchEmail(eMail)) {

                    JOptionPane.showMessageDialog(this, "Input email is invalid\n Please make sure that input email is like example: example@email.com", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!R.matchPassword(password)) {

                    JOptionPane.showMessageDialog(this, "Input password is invalid\n It should contains upper and lower case letter, symbols and digits", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if (Integer.parseInt(age) <= 16) {

                    JOptionPane.showMessageDialog(this, "Sorry but you must be older than 16 years old", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (Integer.parseInt(age) > 60) {

                    JOptionPane.showMessageDialog(this, "Sorry but you must be younger than 60 years old", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {

                    JOptionPane.showMessageDialog(this, "The passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ProxyManagmentSystem.getInstance().getUserByEmail(eMail) != null) {

                    JOptionPane.showMessageDialog(this, "You have already signed up", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                    return;
                }

                String s = selectLocationC.getSelectedItem().toString();
                int city_id = ProxyManagmentSystem.getInstance().getCityByName(s).getCity_id();

               User user = new User(firstName, surname, patronymic, eMail,
                        Integer.parseInt(age), password, chooseSexC.getSelectedItem().toString().charAt(0),
                       ProxyManagmentSystem.getInstance().getUsers().size(), city_id);

                try {
                    ProxyManagmentSystem.getInstance().insertUser(user);
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "Gratulations!\n You signed up successfully");
                this.dispose();

            }


            else if (buttonPressed.equals("Cancel"))
            {
                this.dispose();
            }

        }
    }

