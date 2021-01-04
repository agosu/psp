package extension;

public interface Extension {
    double getCost(int textLength);
    String getName();
    Extension getNext();
    void setNext(Extension extension);
}
