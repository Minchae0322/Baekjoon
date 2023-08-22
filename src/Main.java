import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.jar.JarEntry;

//todo 지구온난화
public class Main {

    static int[][] map;
    static int R;
    static int C;

    static int N;

    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {-1, 1, 0, 0};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());





    }

    static void down(boolean[][] isChecked) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !isChecked[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (isAbleDown(list, isChecked)) {
            move(isChecked, list);
            down(isChecked);
        }
    }

    static void move(boolean[][] isChecked, List<int[]> list) {
        for (int[] now : list) {
            int dy = now[0] + 1;
            int dx = now[1];

            map[dy][dx] = 'x';
            map[now[0]][now[1]] = '.';
            isChecked[dy][dx] = false;
            isChecked[now[0]][now[1]] = true;
        }
    }

    static boolean isAbleDown(List<int[]> list, boolean[][] isChecked) {
        for (int[] now : list) {
            int dy = now[0] + 1;
            int dx = now[1];
            if (dy < 0) {
                return false;
            }
            if (map[dy][dx] == 'x' && isChecked[dy][dx]) {
                return false;
            }
        }
        return true;
    }

    static void bfs(boolean[][] isChecked, int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int dy = now[0] + yy[i];
                int dx = now[1] + xx[i];

                if (dy < 0 || dx < 0 || dy > R - 1 || dx > C - 1) {
                    continue;
                }

                if (!isChecked[dy][dx] && map[dy][dx] == 'x') {
                    que.add(new int[]{dy, dx});
                    isChecked[dy][dx] = true;
                }

            }
        }
        down(isChecked);
    }











}

