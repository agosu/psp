package strategy;

public class CrazyEventStrategy implements EventStrategy {
    private static final String TYPE = "crazy";
    private static CrazyEventStrategy instance;

    public static CrazyEventStrategy getInstance() {
        if (instance == null) {
            instance = new CrazyEventStrategy();
        }

        return instance;
    }

    private CrazyEventStrategy() {}

    public String getType() {
        return TYPE;
    }

    public String getPlace(int budget, int numberOfAttendees) {
        if (budget < 1000 && numberOfAttendees < 250) {
            return "roof terrace";
        }
        return "lukiskes";
    }

    public String getDressCode(String place) {
        if (place.equals("roof terrace")) {
            return "themed";
        }
        return "warm";
    }
}
