package Interface.ComponentsFactory;

import javax.swing.*;

public class ComponentsCreationManagment {

    private AbstractFactory factory;

    public ComponentsCreationManagment(AbstractFactory factory) {
        this.factory = factory;
    }

    public JComponent createComponent(String componentName) {

        return factory.createComponent(componentName);
    }
}
