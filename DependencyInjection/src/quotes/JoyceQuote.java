package quotes;

public class JoyceQuote implements ContentProvider {
    private static JoyceQuote joyceQuote = new JoyceQuote();
    private JoyceQuote() {}

    public String getContent() {
        return "History is a nightmare from which I am trying to awake.";
    }

    public static JoyceQuote createInstance() {
        return joyceQuote;
    }

}
