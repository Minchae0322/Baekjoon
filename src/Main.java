import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 기타 레슨 2343
public class Main {

    static int N;
    static int M;

    static int[] value;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        value = new int[N];

        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            min = Math.max(min, value[i]);
            max += value[i];
        }

        int start = min;
        int end = max;

        while (start <= end) {
            int middle = (start + end) / 2;
            int blueRay = divide(middle);

            if (blueRay <= M) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(start);


    }

    static int divide(int num) {
        int blueRayNum = 0;
        int blueRayVol = 0;
        for (int i = 0; i < N; i++) {
            if (blueRayVol + value[i] > num) {
                blueRayNum++;
                blueRayVol = 0;
            }
            blueRayVol += value[i];

        }
        if (blueRayVol == 0) {
            return blueRayNum;
        }
        return blueRayNum + 1;
    }



}

