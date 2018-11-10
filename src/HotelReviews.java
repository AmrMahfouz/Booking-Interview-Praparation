import java.util.*;

public class HotelReviews {

    public static void main(String[] args) {
        List<HotelReview> reviews = new ArrayList<>();
        reviews.add(new HotelReview(1001, 501, 7));
        reviews.add(new HotelReview(1001, 502, 7));
        reviews.add(new HotelReview(1001, 503, 7));
        reviews.add(new HotelReview(2001, 504, 10));
        reviews.add(new HotelReview(3001, 505, 5));
        reviews.add(new HotelReview(2001, 506, 5));
        for (int hotelId : getHotels(reviews, 5)) {
            System.out.print(hotelId + " ");
        }
        System.out.println();
        for (int hotelId : getHotels(reviews, 7)) {
            System.out.print(hotelId + " ");
        }
    }

    private static List<Integer> getHotels(List<HotelReview> reviews, int avgScore) {
        Map<Integer, HotelScore> hotelAvgScore = new HashMap<>();
        for (HotelReview hotelReview : reviews) {
            HotelScore hotelScore = hotelAvgScore.getOrDefault(hotelReview.hotelId, new HotelScore());
            hotelScore.count++;
            hotelScore.score += hotelReview.score;
            hotelAvgScore.put(hotelReview.hotelId, hotelScore);
        }

        List<Integer> hotelIds = new ArrayList<>();

        for (Map.Entry<Integer, HotelScore> entry : hotelAvgScore.entrySet()) {
            if (entry.getValue().getAverageScore() >= avgScore) {
                hotelIds.add(entry.getKey());
            }
        }
        return hotelIds;
    }

    static class HotelScore {
        int count;
        int score;

        double getAverageScore() {
            return score / count;
        }
    }

    static class HotelReview {
        int hotelId;
        int userId;
        int score;

        public HotelReview(int hotelId, int userId, int score) {
            this.hotelId = hotelId;
            this.userId = userId;
            this.score = score;
        }
    }

}
