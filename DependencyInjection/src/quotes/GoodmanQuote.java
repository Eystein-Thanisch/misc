package quotes;

public class GoodmanQuote implements ContentProvider {
    private static GoodmanQuote goodmanQuote = new GoodmanQuote();
    private GoodmanQuote() {}

    public String getContent() {
        return "History is our mother. We best do her honour, this way.";
    }

    public static GoodmanQuote createInstance() {
        return goodmanQuote;
    }

}
