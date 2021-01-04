package decorator;

public class HtmlEscaper extends Decorator {

    public HtmlEscaper(ITextEditor wrappee) {
        this.wrappee = wrappee;
    }

    public String escapeHtml(String text) {
        return text + " {html escaped}";
    }

    public double getCost(int textLength) {
        return wrappee.getCost(textLength) + textLength + 2;
    }

    public String getName() {
        return wrappee.getName() + "-HtmlEscaper";
    }
}
