package careercup;

public class ConvertIntegerToString {

    public static void main(String[] args) {
        System.out.println(integerToString(-1235));
        System.out.println(123123);
    }

    private static String integerToString(int n) {
        StringBuilder result = new StringBuilder();
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }
        while (n > 0) {
            short digit = (short) (n % 10);
            n /= 10;
            switch (digit) {
                case 0:
                    result.append('0');
                    break;
                case 1:
                    result.append('1');
                    break;
                case 2:
                    result.append('2');
                    break;
                case 3:
                    result.append('3');
                    break;
                case 4:
                    result.append('4');
                    break;
                case 5:
                    result.append('5');
                    break;
                case 6:
                    result.append('6');
                    break;
                case 7:
                    result.append('7');
                    break;
                case 8:
                    result.append('8');
                    break;
                case 9:
                    result.append('9');
                    break;
            }
        }
        result = result.reverse();
        if (isNegative) {
            return '-' + result.toString();
        }
        return result.toString();
    }

}
