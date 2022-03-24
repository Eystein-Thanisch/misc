package quotes;

public interface ContentProvider {

    public String getContent();

    public static ContentProvider createInstance() {
        return null;
    }

}
