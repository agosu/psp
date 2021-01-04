package extension;

public class AgeCensor implements Extension {

    private Extension next;

    public double getCost(int textLength) {
        if (next != null) {
            return textLength * 0.5 + next.getCost(textLength);
        }
        return textLength * 0.5;
    }

    public String getName() {
        if (next != null) {
            return "-AgeCensor" + next.getName();
        }
        return "-AgeCensor";
    }

    public Extension getNext() {
        return next;
    }

    public void setNext(Extension extension) {
        next = extension;
    }

    public String censor(String text, int age) {
        return text + " {censored for age " + age + "}";
    }
}
