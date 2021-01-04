package decorator;

public class Translator extends Decorator {

    public Translator(ITextEditor wrappee) {
        this.wrappee = wrappee;
    }

    public String translate(String text, String langFrom, String langTo) {
        return text + " {translated from " + langFrom + " to " + langTo + "}";
    }

    public double getCost(int textLength) {
        return wrappee.getCost(textLength) + textLength;
    }

    public String getName() {
        return wrappee.getName() + "-Translator";
    }
}
