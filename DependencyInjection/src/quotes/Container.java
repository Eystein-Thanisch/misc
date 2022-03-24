package quotes;

public class Container {

    private ContentProvider provider;

    public String getContent() {
        return provider.getContent();
    }

    public void setContentProvider(ContentProvider provider) {
        this.provider = provider;
    }
}
