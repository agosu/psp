package templateMethod;

import common.Event;

import java.time.LocalDateTime;

public class CrazyEvents {

    public static Event createEvent(int budget, int numberOfAttendees) {
        Event event =  new Event(budget, numberOfAttendees);
        event.setType(getType());
        String place = getPlace(budget, numberOfAttendees);
        event.setPlace(place);
        event.setDressCode(getDressCode(place));
        event.setDateTime(LocalDateTime.of(2020, 12, 23, 12, 30));
        return event;
    }

    public static String getType() {
        return "crazy";
    }

    public static String getPlace(int budget, int numberOfAttendees) {
        if (budget < 1000 && numberOfAttendees < 250) {
            return "roof terrace";
        }
        return "lukiskes";
    }

    public static String getDressCode(String place) {
        if (place.equals("roof terrace")) {
            return "themed";
        }
        return "warm";
    }
}
