package extension;

public class Translator implements Extension {

    private Extension next;

    public double getCost(int textLength) {
        if (next != null) {
            return textLength + next.getCost(textLength);
        }
        return textLength;
    }

    public String getName() {
        if (next != null) {
            return "-Translator" + next.getName();
        }
        return "-Translator";
    }

    public Extension getNext() {
        return next;
    }

    public void setNext(Extension extension) {
        next = extension;
    }

    public String translate(String text, String langFrom, String langTo) {
        return text + " {translated from " + langFrom + " to " + langTo + "}";
    }
}
