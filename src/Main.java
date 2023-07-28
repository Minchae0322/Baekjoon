import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.function.IntPredicate;

//todo 추월
public class Main {


    static int N;
    static int M;
    static int[][] map;
    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {-1, 1, 0, 0};

    static List<int[]> virus = new ArrayList<>();

    static boolean[] actVirus;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        actVirus = new boolean[virus.size()];
        backTracking(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);

    }

    static void backTracking(int depth, int start) {
        if (depth == M) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < virus.size(); i++) {
                if (actVirus[i]) {
                    list.add(virus.get(i));
                }
            }
            if (list.size() >= M) {
                min = Math.min(bfs(list), min);
            }
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            int[] v = virus.get(i);
            actVirus[i] = true;
            backTracking(depth + 1, start + 1);
            actVirus[i] = false;
        }
    }

    static int bfs(List<int[]> startVirus) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, board[i], 0, N);
        }
        Queue<int[]> que = new LinkedList<>();
        for (int[] v : startVirus) {
            board[v[0]][v[1]] = 3;
            que.add(new int[]{v[0], v[1]});
        }


        int max = 3;
        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int dy = now[0] + yy[i];
                int dx = now[1] + xx[i];

                if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                    continue;
                }

                if (board[dy][dx] == 1) {
                    continue;
                }

                if (board[dy][dx] == 0) {
                    board[dy][dx] = board[now[0]][now[1]] + 1;
                    max = board[dy][dx];
                    que.add(new int[]{dy, dx});
                }

                if (board[dy][dx] == 2) {
                    board[dy][dx] = board[now[0]][now[1]];
                    que.add(new int[]{dy, dx});
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return max - 3;
    }







}

