package strategy;

public interface EventStrategy {
    String getType();
    String getPlace(int budget, int numberOfAttendees);
    String getDressCode(String place);
}
