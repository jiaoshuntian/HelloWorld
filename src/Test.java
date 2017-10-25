import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiaoShuntian on 2017/7/20.
 */
public class Test {
    public static void main(String[] args) {
       /* String s1 = new String("123");
        String s2 = "123";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));*/
        List<List<String>> fatherList = new LinkedList<>();
        List<String> childList = new ArrayList<>();
        childList.add("before add child list");
        fatherList.add(childList);
        childList.add("after add child list");
        System.out.println(fatherList);
        int a = 1;
        Test test = new Test();
        test.add(a);
        System.out.println(a);
    }
    int add(int a) {
        a++;
        return a;
    }
}
