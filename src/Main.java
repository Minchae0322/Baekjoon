import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.function.IntPredicate;

//todo 16935 배열 돌리기 3
public class Main {

    static int N;
    static int M;
    static int R;
    static int[] arr;

    static int[][] board;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];

        R = sc.nextInt();
        arr = new int[R];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < R; i++) {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five(divide());
                    break;
                case 6:
                    six(divide());
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void one() {
        int[][] changed = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                changed[i][j] = board[N - i - 1][j];
            }
        }
        board = changed;
    }

    static void two() {
        int[][] changed = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                changed[i][j] = board[i][M - j - 1];
            }
        }
        board = changed;
    }

    static void three() {
        int[][] changed = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                changed[j][N - i - 1] = board[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        board = changed;
    }

    static void four() {
        int[][] changed = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                changed[M - j - 1][i] = board[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        board = changed;
    }

    static List<int[][]> divide() {
        List<int[][]> list = new ArrayList<>();
        int[][] one = new int[N / 2][M / 2];
        int[][] two = new int[N / 2][M / 2];
        int[][] three = new int[N / 2][M / 2];
        int[][] four = new int[N / 2][M / 2];


        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                one[i][j] = board[i][j];
            }
        }
        list.add(0, one);
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                two[i][j - M / 2] = board[i][j];
            }
        }
        list.add(1, two);

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                three[i - N / 2][j -  M / 2] = board[i][j];
            }
        }
        list.add(2, three);
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                four[i - N / 2][j] = board[i][j];
            }

        }
        list.add(3, four);
        return list;
    }

    static void five(List<int[][]> list) {
        int[][] one = list.get(3);
        int[][] two = list.get(0);
        int[][] three = list.get(1);
        int[][] four = list.get(2);

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                board[i][j] = one[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                board[i][j] = two[i][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                board[i][j] = three[i - N / 2][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                board[i][j] = four[i - N / 2][j];
            }

        }


    }

    static void six(List<int[][]> list) {
        int[][] one = list.get(1);
        int[][] two = list.get(2);
        int[][] three = list.get(3);
        int[][] four = list.get(0);

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                board[i][j] = one[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                board[i][j] = two[i][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                board[i][j] = three[i - N / 2][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                board[i][j] = four[i - N / 2][j];
            }

        }


    }







}

