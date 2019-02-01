package glassdoor;

public class MaximumFromOneSwap {

    public static void main(String[] args) {
        System.out.println(maxValue(1886329));
        System.out.println(maxValue(3580));
        System.out.println(maxValue(980632900));
    }

    private static int maxValue(int num) {
        // convert number to digits
        short[] digits = new short[Integer.toString(num).length()];
        int index = digits.length - 1;
        while (num != 0) {
            int digit = num % 10;
            digits[index--] = (short) digit;
            num /= 10;
        }

        int i = 0;
        int j = digits.length - 1;
        short minValue = digits[i];
        short maxValue = digits[j];
        int minIndex = i;
        int maxIndex = j;
        while(i < j) {
            i++;
            j--;
            if (digits[j] > maxValue) {
                maxIndex = j;
                maxValue = digits[j];
            }
            if (digits[i] < minValue) {
                minIndex = i;
                minValue = digits[i];
            }
        }
        short temp = digits[minIndex];
        digits[minIndex] = digits[maxIndex];
        digits[maxIndex] = temp;
        int result = 0;
        for (short digit : digits) {
            result = (result * 10) + digit;
        }
        return result;
    }

}
