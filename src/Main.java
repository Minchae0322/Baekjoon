import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 21608 상어초등학교
public class Main {


    static int[] small;
    static int sum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        small = new int[9];
        for (int i = 0; i < 9; i++) {
            small[i] = sc.nextInt();
            sum += small[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (small[i] + small[j]) == 100) {
                    for (int n = 0; n < 9; n++) {
                        if (n != i && n != j) {
                            System.out.println(small[n]);
                        }
                    }
                    return;
                }
            }
        }

    }


}
