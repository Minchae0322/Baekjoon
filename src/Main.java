import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 지구온난화
public class Main {

    static int[][] map;
    static int R;
    static int C;

    static int N;

    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {-1, 1, 0, 0};

    static char[][] board;

    static int[] M = new int[2];
    static int[] Z = new int[2];

    static int block = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        map = new int[7][2];

        for (int i = 0; i < 7; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        System.out.println(solution(map));


    }

    static int solution(int[][] targets) {
        int answer = 0;
        sort(targets);
        for (int i = 0; i < 7; i++) {
            System.out.println(targets[i][0] + " " + targets[i][1]);
        }
        answer = run(targets);
        return answer;
    }

    static void sort(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
    }

    static int run(int[][] sorted) {
        int num = 0;
        int firstNum = sorted[0][1];
        for(int i=1; i<sorted.length; i++) {
            if(firstNum < sorted[i][0]) {
                continue;
            }
            num++;
            firstNum = sorted[i][1];
        }

        return num;
    }

}

