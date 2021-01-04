package decorator;

public interface ITextEditor {
    String fixErrors(String text);
    double getCost(int textLength);
    String getName();
}
