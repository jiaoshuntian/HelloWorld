import java.util.Random;

/**
 * Created by Administrator on 2017/5/2.
 */
public class TestRandom {
    public static void main(String[] args) {
        //double random1 = Math.random();
        Random random2 = new Random();
        //System.out.println(random1);
        for (int i = 0; i < 10; i++) {
            int random3 = random2.nextInt(5) + 5;
            System.out.println(random3);
        }
    }
}