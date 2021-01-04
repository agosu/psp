package decorator;

public class TextEditor implements ITextEditor {

    public String fixErrors(String text) {
        return text + " {errors fixed}";
    }

    public double getCost(int textLength) {
        return 0.25 * textLength;
    }

    public String getName() {
        return "TextEditor";
    }
}
