import java.io.IOException;
import java.util.*;

//todo 게임 1072번
public class Main {

    static long X;
    static long Y;

    static long end;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        X = sc.nextLong();
        Y = sc.nextLong();

        end = Math.min(X * 2, 1000000000);

        long start = 0;
        long min = Integer.MAX_VALUE;

        double initRate = calRate(0);

        while (start <= end) {
            long middle = (start + end) / 2;
            double rate = calRate(middle);

            if (initRate < rate) {
                min = Math.min(min, middle);
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);




    }


    static double calRate(long num) {
        return Math.floor((((num + Y)  * 100) / (X + num)));
    }


}

