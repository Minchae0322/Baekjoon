import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 추월
public class Main {


    static int[] triNum;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();

            System.out.println(init(n));
        }






    }

    static int init(int n) {
        for (int i = 1; i < 100; i++) {
            int check1 = (i*(i+1)) / 2;
            if (check1 > 1000) {
                break;
            }
            for (int j = 1; j < 100; j++) {
                int check2 = (i*(i+1)) / 2;
                if (check2 > 1000) {
                    break;
                }
                for (int k = 1; k < 100; k++) {
                    int check3 = (i*(i+1)) / 2;
                    if (check3 > 1000) {
                        break;
                    }
                    int tri = ((i * (i + 1)) / 2) + ((j * (j + 1)) / 2) + ((k * (k + 1)) / 2);
                    if (tri == n) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

