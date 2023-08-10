import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.function.IntPredicate;

//todo 16935 2467번 용액
public class Main {

    static int N;

    static long[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        value = new long[N];

        for (int i = 0; i < N; i++) {
            value[i] = Long.parseLong(st.nextToken());
        }

        run(0, N - 1);

    }


        static void run(int start , int end) {
        long min = Long.MAX_VALUE;
        long sv = value[start];
        long ev = value[end];

        while (start < end) {
            long sum = (value[start] + value[end]);

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                sv = value[start];
                ev = value[end];
            }
            if (sum == 0) {
                System.out.println(sv + " " + ev);
                return;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(sv + " " + ev);
    }






}

