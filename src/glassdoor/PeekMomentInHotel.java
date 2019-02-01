package glassdoor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PeekMomentInHotel {

    public static void main(String[] args) throws ParseException {
        List<HotelReservation> reservations = new LinkedList<>();
        SimpleDateFormat dataFormatter = new SimpleDateFormat("yyyy-mm-dd");
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-01"), dataFormatter.parse("2018-10-05")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-02"), dataFormatter.parse("2018-10-06")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-03"), dataFormatter.parse("2018-10-04")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-04"), dataFormatter.parse("2018-10-05")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-05"), dataFormatter.parse("2018-10-06")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-06"), dataFormatter.parse("2018-10-07")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-02"), dataFormatter.parse("2018-10-05")));
        reservations.add(new HotelReservation(dataFormatter.parse("2018-10-03"), dataFormatter.parse("2018-10-05")));
        System.out.println(findPeekMoment(reservations));
    }

    private static Date findPeekMoment(List<HotelReservation> reservations) {
        List<Event> events = new ArrayList<>();
        for (HotelReservation hotelReservation : reservations) {
            events.add(new Event(hotelReservation.checkIn, EventType.CHECK_IN));
            events.add(new Event(hotelReservation.checkOut, EventType.CHECK_OUT));
        }
        Collections.sort(events, (e1, e2) -> e1.date.compareTo(e2.date));
        int peopleCount = 0;
        int maxPeopleCount = 0;
        Date peekDate = null;
        for (Event event : events) {
            if (event.type == EventType.CHECK_IN) {
                peopleCount++;
            } else if (event.type == EventType.CHECK_OUT) {
                peopleCount--;
            }
            if (peopleCount > maxPeopleCount) {
                maxPeopleCount = peopleCount;
                peekDate = event.date;
            }
        }
        return peekDate;
    }

    private static class HotelReservation {
        Date checkIn;
        Date checkOut;

        public HotelReservation(Date checkIn, Date checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    private static class Event {
        Date date;
        EventType type;

        public Event(Date date, EventType type) {
            this.date = date;
            this.type = type;
        }
    }

    private static enum EventType {
        CHECK_IN, CHECK_OUT
    }

}
