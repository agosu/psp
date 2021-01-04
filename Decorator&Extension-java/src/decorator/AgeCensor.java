package decorator;

public class AgeCensor extends Decorator {

    public AgeCensor(ITextEditor wrappee) {
        this.wrappee = wrappee;
    }

    public String censor(String text, int age) {
        return text + " {censored for age " + age + "}";
    }

    public double getCost(int textLength) {
        return wrappee.getCost(textLength) + textLength * 0.5;
    }

    public String getName() {
        return wrappee.getName() + "-AgeCensor";
    }
}
