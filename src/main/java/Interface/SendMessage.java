package Interface;

import Interface.ComponentsFactory.ComponentsCreationManagment;
import Interface.ComponentsFactory.FactoryProducer;
import Interface.ComponentsFactory.WindowCreationManagment;
import Logic.ManagmentSystem;
import Logic.Message;
import Logic.Proxy.ProxyManagmentSystem;
import Logic.User;
import res.R;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class SendMessage extends JDialog implements ActionListener {

    User currentUser;
    JButton sendMessageBtn, cancelBtn;
    JPanel panel;
    JLabel headerLab, contentLab, receiverLab;
    final JTextField headerTxt, receiverTxt;
    final JTextArea contentTxt;
    ComponentsCreationManagment componentsCreationManagment = new ComponentsCreationManagment(FactoryProducer.getFactory("components"));
    WindowCreationManagment windowCreationManagment = new WindowCreationManagment(FactoryProducer.getFactory("windows"));

    SendMessage(User user)
    {
        currentUser = user;
        this.setTitle("Send Message");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setModal(true);

        headerLab = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
        headerLab.setText("Header: ");
        headerTxt = ((JTextField) componentsCreationManagment.createComponent("JTextField"));
        headerTxt.setColumns(15);

        contentLab = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
        contentLab.setText("Content: ");
        contentTxt =  ((JTextArea) componentsCreationManagment.createComponent("JTextArea"));
        contentTxt.setRows(10);
        contentTxt.setColumns(25);
        contentTxt.setLineWrap(true);
        contentTxt.setWrapStyleWord(true);

        receiverLab = ((JLabel) componentsCreationManagment.createComponent("JLabel"));
        receiverLab.setText("Receiver email: ");
        receiverTxt =  ((JTextField) componentsCreationManagment.createComponent("JTextField"));
        receiverTxt.setColumns(2);

        sendMessageBtn = ((JButton) componentsCreationManagment.createComponent("JButton"));
        sendMessageBtn.setText("Send");

        cancelBtn = ((JButton) componentsCreationManagment.createComponent("JButton"));
        cancelBtn.setText("Cancel");

        panel = ((JPanel) componentsCreationManagment.createComponent("JPanel"));


        this.add(headerLab, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.add(headerTxt, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.add(contentLab, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));


        this.add(new JScrollPane(contentTxt), new GridBagConstraints(1, 1, 1, 5, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.add(receiverLab, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.add(receiverTxt, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));


        this.add(sendMessageBtn, new GridBagConstraints(0, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.add(cancelBtn, new GridBagConstraints(1, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        this.pack();

        sendMessageBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command) {

            case "Send":

                if  (!R.matchEmail(receiverTxt.getText())) {

                    JOptionPane.showMessageDialog(this, "Input receiver email is not correct", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ProxyManagmentSystem.getInstance().getUserByEmail(receiverTxt.getText()) == null) {

                    JOptionPane.showMessageDialog(this, "There exists no such user", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }

                Message message = new Message();
                String header = headerTxt.getText();
                String content = contentTxt.getText();
                String receiver = receiverTxt.getText();
                message.setHeader(header);
                message.setSendDate(new Date());
                message.setAuthor(currentUser.getEmail());
                message.setContent(content);
                message.setReceiver(receiver);
                message.setMessage_id(ProxyManagmentSystem.getInstance().getMessages().size());
                try {
                    ProxyManagmentSystem.getInstance().sendMessage(message);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "You send message to " + receiver + " successfully");
                dispose();
                break;

            case "Cancel":

               dispose();

                break;
        }
    }

    public static void main(String[] args) {


    }


}
