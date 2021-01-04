package templateMethod;

import common.Event;

import java.time.LocalDateTime;

public class NormalEvents {
    public static Event createEvent(int budget, int numberOfAttendees) {
        Event event =  new Event(budget, numberOfAttendees);
        event.setType(getType());
        String place = getPlace(budget, numberOfAttendees);
        event.setPlace(place);
        event.setDressCode(getDressCode(place));
        event.setDateTime(LocalDateTime.of(2020, 12, 23, 12, 30));
        return event;
    }

    private static String getType() {
        return "normal";
    }

    private static  String getPlace(int budget, int numberOfAttendees) {
        if (budget < 250 && numberOfAttendees > 10) {
            return "simple bar";
        }
        return "fancy bar";
    }

    private static String getDressCode(String place) {
        if (place.contains("simple")) {
            return "casual";
        }
        return "business";
    }
}
