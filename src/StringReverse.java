import java.util.Stack;

/**
 *字符串反转
 * Created by JiaoShuntian on 2017/5/17.
 */
public class StringReverse {
    public static String reverse1(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String leftString = s.substring(0, length / 2);
        String rightSting = s.substring(length / 2, length);
        return reverse1(rightSting) + reverse1(leftString);
    }

    public static String reverse2(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    public static String reverse3(String s) {
        char[] sArray = s.toCharArray();
        String reverse = "";
        for (int i = sArray.length - 1; i >= 0; i--) {
            reverse += sArray[i];
        }
        return reverse;
    }

    public static String reverse4(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public static String reverse5(String orig) {
        char[] s = orig.toCharArray();
        int n = s.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - i];
            s[n - i] = temp;
        }
        return new String(s);
    }

    public static String reverse6(String s) {

        char[] str = s.toCharArray();

        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }

        return new String(str);
    }

    public static String reverse7(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length; i++)
            stack.push(str[i]);

        String reversed = "";
        for (int i = 0; i < str.length; i++)
            reversed += stack.pop();

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse4("abcdefg1234"));
    }
}

