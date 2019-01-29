package careercup;

import java.util.Map;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("abababaabbbaaaaa"));
    }

    private static String compress(String input) {
        char prev = input.charAt(0);
        int charCount = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == prev) {
                charCount++;
            } else {
                result.append(prev);
                if (charCount > 1) {
                    result.append(charCount);
                }
                charCount = 1;
                prev = c;
            }
        }
        result.append(prev);
        result.append(charCount);
        return result.toString();
    }

}
