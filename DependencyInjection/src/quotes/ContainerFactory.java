package quotes;

public class ContainerFactory {

    private Container container;

    public Container createJoyceContainerInstance() {
        container = new Container();
        container.setContentProvider(new JoyceQuote());
        return container;
    }

    public Container createGoodmanContainerInstance() {
        container = new Container();
        container.setContentProvider(new GoodmanQuote());
        return container;
    }

}
