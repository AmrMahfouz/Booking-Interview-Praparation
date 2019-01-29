package careercup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelAvailability {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        Map<String, Integer> hotelRooms = new HashMap<>();
        hotelRooms.put("Waston", 1);
        hotelRooms.put("Best Western", 2);
        hotelRooms.put("Hilton", 1);

        Map<String, List<HotelReservation>> hotelReservations = new HashMap<>();
        List<HotelReservation> hiltonReservations = Arrays.asList(
                new HotelReservation(format.parse("2015-04-02"), format.parse("2015-04-03")),
                new HotelReservation(format.parse("2015-04-02"), format.parse("2015-04-04"))
        );
        hotelReservations.put("Hilton", hiltonReservations);
        List<HotelReservation> wastonReservations = Arrays.asList(
                new HotelReservation(format.parse("2015-05-01"), format.parse("2015-05-20"))
        );
        hotelReservations.put("Waston", wastonReservations);
        availableHotels(format.parse("2015-05-01"), format.parse("2015-05-03"), hotelRooms, hotelReservations).forEach(System.out::println);
    }

    // assuming that there are no miss spilling in hotel names
    private static List<String> availableHotels(Date checkIn, Date checkOut, Map<String, Integer> hotelRooms, Map<String, List<HotelReservation>> hotelReservations) {
        for (Map.Entry<String, List<HotelReservation>> entry : hotelReservations.entrySet()) {
            String hotelId = entry.getKey();
            for (HotelReservation hotelReservation : entry.getValue()) {
                if(isDateInsideInterval(checkIn, hotelReservation)) {
                    hotelRooms.put(hotelId, hotelRooms.get(hotelId) - 1);
                    break;
                }
            }
        }
        List<String> availableHotels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hotelRooms.entrySet()) {
            if (entry.getValue() > 0) {
                availableHotels.add(entry.getKey());
            }
        }
        return availableHotels;
    }

    private static boolean isDateInsideInterval(Date checkIn, HotelReservation hotelReservation) {
        if (checkIn.equals(hotelReservation.checkIn) || (checkIn.after(hotelReservation.checkIn) && checkIn.before(hotelReservation.checkOut))) {
            return true;
        }
        return false;
    }

    private static class HotelReservation {
        Date checkIn;
        Date checkOut;

        public HotelReservation(Date checkIn, Date checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }
}
