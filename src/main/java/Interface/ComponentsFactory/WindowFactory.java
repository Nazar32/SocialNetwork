package Interface.ComponentsFactory;

import javax.swing.*;
import java.awt.*;

public class WindowFactory extends AbstractFactory {

    @Override
    Window createWindow(String windowName) {

        Window window = null;

        switch (windowName) {

            case "JFrame" :
                window = new JFrame();
                break;

            case "JDialog" :
                window = new JDialog();
                break;
        }

        return window;
    }

    @Override
    JComponent createComponent(String componentName) {
        return null;
    }


}
