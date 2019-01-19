package careercup;

import java.util.*;

public class CommonHotelIds {

    public static void main(String[] args) {
        Map<String, List<Integer>> userHotelIds = new HashMap<>();
        userHotelIds.put("UserA", Arrays.asList(1,2,3,4));
        userHotelIds.put("UserB", Arrays.asList(5,2,6,8));
        userHotelIds.put("UserC", Arrays.asList(20,2,15,14));
        commonHotelIds(userHotelIds).stream().forEach(System.out::println);
    }

    private static Set<Integer> commonHotelIds(Map<String, List<Integer>> userHotelIds) {
        Map<Integer, Integer> hotelIdsCount = new HashMap<>();
        int usersSize = userHotelIds.size();
        for (Map.Entry<String, List<Integer>> entry : userHotelIds.entrySet()) {
            for (int hotelId : entry.getValue()) {
                hotelIdsCount.put(hotelId, hotelIdsCount.getOrDefault(hotelId, 0) + 1);
            }
        }
        Set<Integer> commonHotelIds = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : hotelIdsCount.entrySet()) {
            int hotelId = entry.getKey();
            int count = entry.getValue();
            if (count == usersSize) {
                commonHotelIds.add(hotelId);
            }
        }
        return commonHotelIds;
    }

}
