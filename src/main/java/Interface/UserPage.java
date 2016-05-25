package Interface;

import Interface.ComponentsFactory.ComponentsCreationManagment;
import Interface.ComponentsFactory.FactoryProducer;
import Interface.ComponentsFactory.WindowCreationManagment;
import Interface.State.*;
import Interface.UserPageTemplate.UserPageTemplate;
import Logic.*;
import Logic.Proxy.ProxyManagmentSystem;
import res.R;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserPage extends UserPageTemplate implements ActionListener{

    public User user = ProxyManagmentSystem.getInstance().getUserByEmail("nastia@mail.ru");
    ProxyManagmentSystem pr = ProxyManagmentSystem.getInstance();
    ComponentsCreationManagment componentsCreationManagment = new ComponentsCreationManagment(FactoryProducer.getFactory("components"));
    WindowCreationManagment windowCreationManagment = new WindowCreationManagment(FactoryProducer.getFactory("windows"));

    JScrollPane messagesPanel = new JScrollPane();
    JScrollPane newsPanel = new JScrollPane();
    JPanel settingsPanel = new JPanel();
    JButton newsBtn = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton messagesBtn = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton settingsBtn = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton exitBtn = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton sendMessage = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton deleteMessage = (JButton) componentsCreationManagment.createComponent("JButton");
    JButton updateMessages = (JButton) componentsCreationManagment.createComponent("JButton");

    JLabel menuL = (JLabel) componentsCreationManagment.createComponent("JLabel");
    public JLabel currentPageL = (JLabel) componentsCreationManagment.createComponent("JLabel");
    JLabel currentUserL = (JLabel) componentsCreationManagment.createComponent("JLabel");
    JList messagesList = (JList) componentsCreationManagment.createComponent("JList");
    ArrayList<Message> messagesForCurrentUser = new ArrayList<>();
    Context context = new Context();
    State[] states = new State[] {new NewsPageState(), new MessagesPageState(), new DeleteMessageState(), new UpdateMessagesState(),
            new SettingsPageState(),     new ExitState()};

    public UserPage(User user) throws HeadlessException, SQLException {

        this.user = user;
        setTitle("User page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 500);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[] {20,90};
        setLayout(layout);
        setVisible(true);

         messagesPanel.setVisible(false);
         newsPanel.setVisible(false);
         settingsPanel.setVisible(false);

        menuL.setText("                  Menu");

        currentPageL.setText("News");
        currentPageL.setHorizontalAlignment(SwingConstants.CENTER);
        newsBtn.setText("News");
        messagesBtn.setText("Messages");
        settingsBtn.setText("Settings");
        exitBtn.setText("Exit");
        currentUserL.setText(user.getEmail());

        add(menuL, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(currentPageL, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(currentUserL, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(newsBtn, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(20, 0, 20, 0), 0, 0));

        add(messagesBtn, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 20, 0), 0, 0));

        add(settingsBtn, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 20, 0), 0, 0));

        add(exitBtn, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 190, 0), 0, 0));


        newsBtn.addActionListener(this);
        messagesBtn.addActionListener(this);
        settingsBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        createUserPage();

    }

    public static void main(String[] args) throws SQLException {

        User user = new User();

        new UserPage(user);

    }

    private void createUserPage() throws SQLException {

        initializeMessages();
        initializeNews();
        initializeSettings();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonPressed = e.getActionCommand();

        switch (buttonPressed) {

            case "News" :

                states[0].doAction(context, this);
                break;

            case "Messages" :

                states[1].doAction(context, this);
                break;

            case "Send" :

                sendMessage();
                break;

            case "Delete":

                states[2].doAction(context, this);
                break;

            case "Update" :

                states[3].doAction(context, this);
                break;

            case "Settings" :

                states[4].doAction(context, this);
                break;

            case "Exit" :

                states[5].doAction(context, this);
                break;



        }
    }


    public void initializeSettings() {

        showMessageBtns(false);


        JButton changeEmailBtn = new JButton("Change");
        JButton confirmPasswordBtn = new JButton("Change");
        JLabel  changeEmailL = new JLabel("Change Email");
        JLabel  changePasswordL = new JLabel("Change Password");
        final JTextField newEmailTxt = new JTextField();
        final JTextField newPasswordTxt = new JPasswordField();
        final JTextField confirmPasswordTxt = new JPasswordField();

        settingsPanel = new JPanel();
        settingsPanel.setVisible(false);
        settingsPanel.setLayout(new GridBagLayout());

        settingsPanel.add(changeEmailL, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(newEmailTxt, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(changeEmailBtn, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(changePasswordL, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(newPasswordTxt, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(confirmPasswordTxt, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));

        settingsPanel.add(confirmPasswordBtn, new GridBagConstraints(2, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(50, 10, 50, 10), 0, 0));


        add(settingsPanel, new GridBagConstraints(1, 1, 1, 4, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 50, 10), 0, 0));

        changeEmailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newEmail = newEmailTxt.getText();

                if (!R.matchEmail(newEmail)) {

                    JOptionPane.showMessageDialog(settingsPanel, "New email is invalid\n" +
                            " Please make sure that your email matches example : name@domen.com", "Error", ERROR);

                    return;
                }

                try {
                    UserPage.this.changeEmail(newEmail);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(settingsPanel, "You changed email successfully", "", JOptionPane.INFORMATION_MESSAGE);
                currentUserL.setText(user.getEmail());
                newEmailTxt.setText("");
            }
        });


        confirmPasswordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newPassword = confirmPasswordTxt.getText();
                String oldPassword = newPasswordTxt.getText();

                if (!R.matchPassword(newPassword)) {

                    JOptionPane.showMessageDialog(settingsPanel, "Input password is invalid\n " +
                            "It should contains upper and lower case letter, symbols and digits", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!newPassword.equals(oldPassword)) {

                    JOptionPane.showMessageDialog(settingsPanel, "Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }

                try {
                    UserPage.this.changePassword(newPassword);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(settingsPanel, "You changed password successfully", "", JOptionPane.INFORMATION_MESSAGE);
                confirmPasswordTxt.setText("");
                newPasswordTxt.setText("");
            }
        });

        validate();
        repaint();

    }

    public void showSettings(boolean show) {

        if (show) {

            settingsPanel.setVisible(true);
        }

        else {

            settingsPanel.setVisible(false);
        }

        validate();
        repaint();

    }

    public void showMessages(boolean show) {

        if (show) {

            messagesPanel.setVisible(true);
            showMessageBtns(true);
        }

        else {

            messagesPanel.setVisible(false);
            showMessageBtns(false);

        }

        validate();
        repaint();
    }

    public void showNews(boolean show) {

        if (show) {

            newsPanel.setVisible(true);
        }

        else {

            newsPanel.setVisible(false);
        }
        validate();
        repaint();

    }

    private void changePassword(String newPassword) throws SQLException {

        user.setPassword(newPassword);
        ProxyManagmentSystem.getInstance().updateUser(user);
    }

    private void changeEmail(String newEmail) throws SQLException {

        user.setEmail(newEmail);
        ProxyManagmentSystem.getInstance().updateUser(user);
    }

    public void initializeMessages() {

        messagesForCurrentUser = new ArrayList<>();
        ArrayList<Message> messages = ProxyManagmentSystem.getInstance().getMessages();


        for (Message message : messages) {

            if (message.getReceiver().equals(user.getEmail()))
                messagesForCurrentUser.add(message);
        }



        DefaultListModel listModel = new DefaultListModel();
        messagesList.setPreferredSize(new Dimension(0, 5000)); // make height equal to count of messages


        if (messagesForCurrentUser.size() == 0) {

            JOptionPane.showMessageDialog(this, "You have no messages");
        }

        else {

            for (int i = 0; i < messagesForCurrentUser.size(); i++) {

                listModel.addElement(messagesForCurrentUser.get(i).getHeader() + "... " +
                        messagesForCurrentUser.get(i).getContent() + "... " +
                        messagesForCurrentUser.get(i).getAuthor() + "   " +
                        messagesForCurrentUser.get(i).getSendDate());

            }
        }

        messagesList.setModel(listModel);


        messagesPanel = new JScrollPane(messagesList);
        messagesPanel.setVisible(false);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());


        showMessageBtns(true);
        sendMessage.setText("Send");
        deleteMessage.setText("Delete");
        updateMessages.setText("Update");

        add(messagesPanel, new GridBagConstraints(1, 1, 1, 4, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 50, 10), 0, 0));

        buttons.add(sendMessage, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        buttons.add(deleteMessage, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 10, 0, 0), 0, 0));

        buttons.add(updateMessages, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(0, 10, 0, 0), 0, 0));


        add(buttons, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(190, 10, 0, 0), 1, 1));

        sendMessage.addActionListener(this);
        deleteMessage.addActionListener(this);
        updateMessages.addActionListener(this);
        validate();
        repaint();

    }

    public void updateMessages() {

        messagesForCurrentUser = new ArrayList<>();
        ArrayList<Message> messages = ProxyManagmentSystem.getInstance().getMessages();


        for (Message message : messages) {

            if (message.getReceiver().equals(user.getEmail()))
                messagesForCurrentUser.add(message);
        }



        DefaultListModel listModel = new DefaultListModel();
        messagesList = new JList();
        messagesList.setPreferredSize(new Dimension(0, 5000)); // make height equal to count of messages


        if (messagesForCurrentUser.size() == 0) {

            JOptionPane.showMessageDialog(this, "You have no messages");
        }

        else {

            for (int i = 0; i < messagesForCurrentUser.size(); i++) {

                listModel.addElement(messagesForCurrentUser.get(i).getHeader() + "... " +
                        messagesForCurrentUser.get(i).getContent() + "... " +
                        messagesForCurrentUser.get(i).getAuthor() + "   " +
                        messagesForCurrentUser.get(i).getSendDate());

            }
        }

        messagesList.setModel(listModel);

        remove(messagesPanel);

        messagesPanel = new JScrollPane(messagesList);

        add(messagesPanel, new GridBagConstraints(1, 1, 1, 4, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 50, 10), 0, 0));

        repaint();
        validate();
    }

    private void sendMessage() {

        new SendMessage(user);
    }

    public void deleteMessage() throws SQLException {

        Message message = messagesForCurrentUser.get(messagesList.getSelectedIndex());

        ProxyManagmentSystem.getInstance().deleteMessage(message);
        ProxyManagmentSystem.getInstance().updateMessages();
        updateMessages();

    }

    private void showMessageBtns(boolean show) {

        sendMessage.setVisible(show);
        deleteMessage.setVisible(show);
        updateMessages.setVisible(show);

    }

    public void initializeNews() throws SQLException {

        showMessageBtns(false);

        ArrayList<News> allUserNews = new ArrayList<>();

        for (News aNew : ProxyManagmentSystem.getInstance().getNews()) {

                allUserNews.add(aNew);
        }

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(allUserNews.size(), 1));

        for (int i = 0; i < allUserNews.size(); i++) {

            jPanel.add(createNewsComponent(allUserNews.get(i)));

        }

        newsPanel = new JScrollPane(jPanel);
        newsPanel.setVisible(false);
        add(newsPanel, new GridBagConstraints(1, 1, 1, 5, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

        validate();
        repaint();
    }

    private Component createNewsComponent(News news) {

        JPanel oneNewsPanel = new JPanel();
        oneNewsPanel.setLayout(new GridBagLayout());

        JLabel jLabel = new JLabel(news.getHeader());
        jLabel.setFont(new Font("Verdana", Font.BOLD, 12));

        oneNewsPanel.add(jLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

        oneNewsPanel.add(new JSeparator(),  new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

        StringBuilder stringBuilder = new StringBuilder(news.getContent());

        int counter = 1;
        int temp = 0;

        for (int i = 100; i < stringBuilder.length(); i += 100) {
            String substring = stringBuilder.substring(temp, i);
            oneNewsPanel.add(new JLabel(substring), new GridBagConstraints(0, counter, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                    new Insets(10, 10, 10, 10), 0, 0));
            counter++;
            temp = i;
        }

        oneNewsPanel.add(new JLabel(news.getAuthor()),new GridBagConstraints(0, counter++, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

        oneNewsPanel.add(new JLabel(R.formatDate(news.getCreationDate())), new GridBagConstraints(0, counter++, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

        oneNewsPanel.setVisible(true);
        return oneNewsPanel;
    }


}
