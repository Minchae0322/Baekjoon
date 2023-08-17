import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.jar.JarEntry;

//todo 지구온난화
public class Main {

    static int R;
    static int C;

    static char[][] value;

    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {-1, 1, 0, 0};

    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        value = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                value[i][j] = s.charAt(j);
                if (value[i][j] == 'X') {
                    que.add(new int[]{i, j});

                }
            }
        }

        getMap();

    }

    static void getMap() {
        char[][] map = fifty();
        int startY = R;
        int startX = C;
        int endY = 0;
        int endX = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (map[i][j] == 'X') {
                    startY = Math.min(startY, i);
                    startX = Math.min(startX, j);
                    endY = Math.max(endY, i);
                    endX = Math.max(endX, j);

                }
            }
        }

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


    static char[][] fifty() {
        char[][] v = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                v[i][j] = value[i][j];
            }
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int dy = now[0] + yy[i];
                int dx = now[1] + xx[i];

                if (dy < 0 || dx < 0 || dy > R - 1 || dx > C - 1) {
                    cnt++;
                    continue;
                }
                if (value[dy][dx] == '.') {
                    cnt++;
                }
            }
            if (cnt >= 3) {
                v[now[0]][now[1]] = '.';
            }
        }
        return v;
    }




}

