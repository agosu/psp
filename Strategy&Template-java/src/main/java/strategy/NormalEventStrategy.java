package strategy;

public class NormalEventStrategy implements EventStrategy {
    private static final String TYPE = "normal";
    private static NormalEventStrategy instance;

    public static NormalEventStrategy getInstance() {
        if (instance == null) {
            instance = new NormalEventStrategy();
        }

        return instance;
    }

    private NormalEventStrategy() {}

    public String getType() {
        return TYPE;
    }

    public String getPlace(int budget, int numberOfAttendees) {
        if (budget < 250 && numberOfAttendees > 10) {
            return "simple bar";
        }
        return "fancy bar";
    }

    public String getDressCode(String place) {
       if (place.contains("simple")) {
           return "casual";
       }
       return "business";
    }
}
