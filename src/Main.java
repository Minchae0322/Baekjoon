import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 추월
public class Main {


    static int[] rc = new int[4];
    static int num;
    static int max;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            rc[i] = sc.nextInt();
        }
        num = 0;
        max = Math.abs(rc[0]);
        for (int i = 1; i < 3; i++) {
            if (max <= Math.abs(rc[i])) {
                max = Math.abs(rc[i]);
                num = i;
            }
        }
        if (max < Math.abs(rc[3])) {
            max = Math.abs(rc[3]);
            num = 3;
        }

        int one = max * 2 + 1;
        int maxNum = one * one;



    }
}

