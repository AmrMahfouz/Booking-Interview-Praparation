package careercup;

import java.util.*;

public class HotelReviews {

    public static void main(String[] args) {
        Set<String> goodWords = new HashSet<>(Arrays.asList("good", "nice", "great"));
        List<HotelReview> hotelReviews = new ArrayList<>();
        hotelReviews.add(new HotelReview("hotel1", "this hotel is bad"));
        hotelReviews.add(new HotelReview("hotel2", "this hotel is good"));
        hotelReviews.add(new HotelReview("hotel3", "this hotel is good and very nice"));
        hotelReviews.add(new HotelReview("hotel4", "this hotel is good"));
        sortHotelReviews(goodWords, hotelReviews).forEach(System.out::println);
    }

    private static List<String> sortHotelReviews(Set<String> goodWords, List<HotelReview> hotelReviews) {
        hotelReviews.stream().forEach(hr -> hr.rank = calculateRank(hr.review, goodWords));
        hotelReviews.sort((r1, r2) -> {
            if (r1.rank == r2.rank) {
                return r2.hotelId.compareTo(r1.hotelId);
            }
            return r2.rank - r1.rank;
        });
        List<String> sortedHotelIds = new ArrayList<>();
        hotelReviews.stream().forEach(hotelReview -> sortedHotelIds.add(hotelReview.hotelId));
        return sortedHotelIds;
    }

    private static int calculateRank(String review, Set<String> goodWords) {
        review = review.toLowerCase()
                .replace(".", "")
                .replace(",", "?")
                .replace("!", "")
                .replace("  ", "")
                .replace("?", "");
        int goodWordsCount = 0;
        for (String word : review.split(" ")) {
            if (goodWords.contains(word)) {
                goodWordsCount++;
            }
        }
        return goodWordsCount;
    }

    private static class HotelReview {

       String hotelId;

       String review;

       int rank;

       HotelReview(String hotelId, String review) {
           this.hotelId = hotelId;
           this.review = review;
       }
    }
}
