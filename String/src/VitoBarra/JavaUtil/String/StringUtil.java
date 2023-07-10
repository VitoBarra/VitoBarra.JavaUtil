package VitoBarra.JavaUtil.String;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static boolean IsEqualToAny(String s1, String... s2) {
        if(s1 == null) return  false;
        for (String s : s2) {
            if (s1.equals(s))
                return true;
        }
        return false;
    }

    public static String Stringer(String[] s, String Spacer) {
        return Arrays.stream(s).reduce((r, x) -> r + Spacer + x).orElse("");
    }

    public static String Stringer(List<String> s, String Spacer) {
        return s.stream().reduce((r, x) -> r + Spacer + x).orElse("");
    }


    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(int s, int size) {
        return center(String.valueOf(s), size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++)
            sb.append(pad);

        sb.append(s);

        while (sb.length() < size)
            sb.append(pad);

        return sb.toString();
    }
}
