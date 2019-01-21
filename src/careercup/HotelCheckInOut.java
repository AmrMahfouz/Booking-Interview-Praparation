package careercup;

import java.util.Arrays;

public class HotelCheckInOut {

    public static void main(String[] args) {
        System.out.println(maxDay(new int[]{1, 2, 10, 5, 5}, new int[]{4, 5, 12, 9, 12}));
    }

    private static int maxDay(int[] checkInDays, int[] checkoutDays) {
        Arrays.sort(checkInDays);
        Arrays.sort(checkoutDays);
        int n = checkInDays.length;
        int numOfPeoples = 0;
        int maxNumOfPeoples = 0;
        int day = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (checkInDays[i] <= checkoutDays[j]) {
                numOfPeoples++;
                if (numOfPeoples > maxNumOfPeoples) {
                    maxNumOfPeoples = numOfPeoples;
                    day = checkInDays[i];
                }
                i++;
            } else {
                numOfPeoples--;
                j++;
            }
        }
        return day;
    }

}
