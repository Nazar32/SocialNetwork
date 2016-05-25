package Interface.ComponentsFactory;

import javax.swing.*;
import java.awt.*;

public abstract  class AbstractFactory {

    abstract JComponent createComponent(String componentName);
    abstract Window createWindow(String windowName);
}
