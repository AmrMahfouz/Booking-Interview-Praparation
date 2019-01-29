package careercup;

public class SmartSubstring {

    public static void main(String[] args) {
        System.out.println(substringSmart("Featuring stylish rooms and moorings for recreation boats, Room Mate Aitana is designer hotel built in 2013 on an island in the IJ River in Amsterdam"));
    }

    private static String substringSmart(String input) {
        int index = 30;
        if (input.length() < 30) {
            return input;
        }
        while (input.charAt(index) != ' ') {
            index--;
        }
        return input.substring(0, index);
    }

}
