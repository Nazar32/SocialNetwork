package Interface.ComponentsFactory;

import javax.swing.*;

public class ComponentFactory extends AbstractFactory {

    @Override
    JComponent createComponent(String componentName) {

        JComponent component = null;

        switch (componentName) {

            case "JTextField" :

                component = new JTextField();
                break;

            case "JTextArea" :

                component = new JTextArea();
                break;

            case "JComboBox" :

                component = new JComboBox<>();
                break;

            case "JLabel" :

                component = new JLabel();
                break;

            case "JList" :

                component = new JList<>();
                break;

            case "JMenuBar" :

                component = new JMenuBar();
                break;

            case "JOptionPane" :

                component = new JOptionPane();
                break;


            case "JPanel" :

                component = new JPanel();
                break;

            case "JScrollBar" :

                component = new JScrollBar();
                break;

            case "JButton" :

                component = new JButton();
                break;

            case "JMenu" :

                component = new JMenu();
                break;

            case "JMenuItem" :

                component = new JMenuItem();
                break;

            case "JRadioButton" :

                component = new JRadioButton();
                break;

            case "JCheckBox" :

                component = new JCheckBox();
                break;

            case "JPasswordField" :

                component = new JPasswordField();
                break;

        }

        return component;
    }

    @Override
    JWindow createWindow(String windowName) {
        return null;
    }
}
