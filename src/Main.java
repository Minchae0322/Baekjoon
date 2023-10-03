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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if (c == 'M') {
                    M = new int[]{i, j};
                }
                if (c == 'Z') {
                    Z = new int[]{i, j};
                }
                if (c != 'M' && c != '.') {
                    if (c == '+') {
                        block += 2;
                    } else {
                        block++;
                    }

                }
                board[i][j] = c;
            }
        }


        run();

    }

    static void run() {
        int dy = M[0];
        int dx = M[1];
        int dir = startDirection();

        while (canFlow(dy, dx, dir)) {
            dy = dy + yy[dir];
            dx = dx + xx[dir];
            dir = getDir(dy, dx, dir);
        }
        makeBlock(dy, dx, dir);
    }

    static boolean run2(int blockNum) {
        int dy = M[0];
        int dx = M[1];
        int dir = startDirection();

        while (canFlow(dy, dx, dir)) {
            dy = dy + yy[dir];
            dx = dx + xx[dir];
            dir = getDir(dy, dx, dir);
            blockNum--;
            if ((dy == Z[0] && dx == Z[1])) {
                break;

            }

        };
        return blockNum == 0;
    }

    static void makeBlock(int y, int x, int dir) {
        int blockY = y + yy[dir];
        int blockX = x + xx[dir];


        board[blockY][blockX] = '|';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '|');
            return;
        }
        board[blockY][blockX] = '-';
        if (run2( block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '-');
            return;
        }
        board[blockY][blockX] = '+';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '+');
            return;
        }
        board[blockY][blockX] = '1';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '1');
            return;
        }
        board[blockY][blockX] = '2';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '2');
            return;
        }board[blockY][blockX] = '3';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '3');
            return;
        }board[blockY][blockX] = '4';
        if (run2(block + 1)) {
            blockY++;
            blockX++;
            System.out.println(blockY + " " + blockX + " " + '4');
            return;
        }




    }



    static int getDir(int y, int x, int dir) {
        switch (board[y][x]) {
            case '-':
            case '|':
            case '+':
                return dir;
            case '1':
                if (dir == 0) {
                    return 3;
                } else {
                    return 1;
                }

            case '2':
                if (dir == 3) {
                    return 1;
                } else {
                    return 2;
                }

            case '3':
                if (dir == 3) {
                    return 0;
                } else {
                    return 2;
                }
            case '4':
                if (dir == 1) {
                    return 3;
                } else {
                    return 0;
                }
        }

        return dir;
    }


    static int startDirection() {
        for (int i = 0; i < 4; i++) {
            int dy = M[0] + yy[i];
            int dx = M[1] + xx[i];

            if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
                continue;
            }

            if (board[dy][dx] != '.' && board[dy][dx] != 'Z') {
                return i;
            }
        }
        return 0;
    }

    static boolean canFlow(int y, int x, int direction) {
        int dy = y + yy[direction];
        int dx = x + xx[direction];

        if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
            return false;
        }

        if (board[dy][dx] == '.' || board[dy][dx] == 'M') {
            return false;
        }

        if (board[dy][dx] == '|') {
            return direction != 0 && direction != 1;
        }

        if (board[dy][dx] == '-') {
            return direction != 2 && direction != 3;
        }

        if (board[dy][dx] == '1') {
            return direction != 1 && direction != 3;
        }

        if (board[dy][dx] == '2') {
            return direction != 1 && direction != 2;
        }

        if (board[dy][dx] == '3') {
            return direction != 0 && direction != 2;
        }

        if (board[dy][dx] == '4') {
            return direction != 0 && direction != 3;
        }

        return true;
    }









}

