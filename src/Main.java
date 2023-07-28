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

    static List<Virus> virus = new ArrayList<>();

    static boolean[] actVirus;

    static int min = Integer.MAX_VALUE;

    static int zero =0;

    static class Virus {
        int y;
        int x;
        int time;

        public Virus(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }



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
                    virus.add(new Virus(i, j, 0));
                    continue;
                }
                if (map[i][j] == 0) {
                    zero++;
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
            min = Math.min(bfs(), min);
        } else {
            for (int i = start; i < virus.size(); i++) {
                if (!actVirus[i]) {
                    actVirus[i] = true;
                    backTracking(depth + 1, i + 1);
                    actVirus[i] = false;

                }


            }
        }


    }

    static int bfs() {

        Queue<Virus> que = new LinkedList<>();
        boolean[][] isChecked = new boolean[N][N];
        for (int i = 0; i < virus.size(); i++) {
            if (actVirus[i]) {
                Virus v = virus.get(i);
                que.add(new Virus(v.y, v.x, 0));
            }
        }

        int max = 0;
        int count = 0;
        while (!que.isEmpty()) {
            Virus now = que.poll();

            for (int i = 0; i < 4; i++) {
                int dy = now.y + yy[i];
                int dx = now.x + xx[i];

                if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                    continue;
                }

                if (map[dy][dx] == 1 || isChecked[dy][dx]) {
                    continue;
                }

                if (!isChecked[dy][dx] && map[dy][dx] != 1) {
                    if (map[dy][dx] == 0) {
                        count++;
                        max = now.time + 1;
                    }
                    isChecked[dy][dx] = true;
                    que.add(new Virus(dy, dx, now.time + 1));
                }

            }
        }

        if (zero == count) {
            return max;
        }


        return Integer.MAX_VALUE;
    }







}

