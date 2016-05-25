package Interface.ComponentsFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factory) {

        AbstractFactory abstractFactory = null;

        switch (factory) {

            case "components" : {

                abstractFactory = new ComponentFactory();
                break;
            }

            case "windows" : {

                abstractFactory = new WindowFactory();
                break;
            }
        }

        return abstractFactory;
    }
}
