package extension;

public class HtmlEscaper implements Extension {

    private Extension next;

    public double getCost(int textLength) {
        if (next != null) {
            return textLength + 2 + next.getCost(textLength);
        }
        return textLength + 2;
    }

    public String getName() {
        if (next != null) {
            return "-HtmlEscaper" + next.getName();
        }
        return "-HtmlEscaper";
    }

    public Extension getNext() {
        return next;
    }

    public void setNext(Extension extension) {
        next = extension;
    }

    public String escapeHtml(String text) {
        return text + " {html escaped}";
    }
}
