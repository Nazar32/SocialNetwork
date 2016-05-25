package Interface.ComponentsFactory;

import javax.swing.*;
import java.awt.*;

public class WindowCreationManagment {

    private AbstractFactory factory;

    public WindowCreationManagment(AbstractFactory factory) {
        this.factory = factory;
    }

    public Window createWindow(String windowName) {

        return factory.createWindow(windowName);
    }
}
