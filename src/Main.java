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
                    block++;
                }
                board[i][j] = c;
            }
        }


        run(findStart(M[0], M[1]));

    }

    static void run(int[] first) {
        int dy = first[0];
        int dx = first[1];
        int dir = first[2];
        while (canFlow(dy, dx, dir)) {
            dy = dy + yy[dir];
            dx = dx + xx[dir];
            dir = getDir(dy, dx, dir);

        }
        makeBlock(dy, dx, dir);
    }

    static void makeBlock(int y, int x, int dir) {
        int blockY = y + yy[dir];
        int blockX = x + xx[dir];

        System.out.println(blockY + " " + blockX);

        board[blockY][blockX] = '|';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + " " + blockX + '|');
            return;
        }
        board[blockY][blockX] = '-';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '-');
            return;
        }
        board[blockY][blockX] = '+';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '+');
            return;
        }
        board[blockY][blockX] = '1';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '1');
            return;
        }
        board[blockY][blockX] = '2';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '2');
            return;
        }board[blockY][blockX] = '3';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '3');
            return;
        }board[blockY][blockX] = '4';
        if (run2(findStart(M[0], M[1]), block)) {
            System.out.println(blockY + blockX + '4');
            return;
        }




    }

    static boolean run2(int[] first, int blockNum) {
        int dy = first[0];
        int dx = first[1];
        int dir = first[2];
        while (canFlow(dy, dx, dir)) {
            dy = dy + yy[dir];
            dx = dx + xx[dir];
            dir = getDir(dy, dx, dir);
            blockNum--;
        }

        if (blockNum == block - 1) {
            return true;
        } else {
            return false;
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
                if (dir == 0) {
                    return 3;
                } else {
                    return 0;
                }
        }

        return dir;
    }
    /*static int getDir(int y, int x, int dir) {
        int dy = 0;
        int dx = 0;
        System.out.println(board[y][x]);
        switch (board[y][x]) {
            case '-':
            case '|':
            case '+':
                dy = y + yy[dir];
                dx = x + xx[dir];

                return new int[]{dy, dx, dir};
            case '1':
                if (dir == 0) {
                    dy = y + yy[3];
                    dx = x + xx[3];
                    return new int[]{dy, dx, 3};
                } else {
                    dy = y + yy[1];
                    dx = x + xx[1];
                    return new int[]{dy, dx, 1};
                }

            case '2':
                if (dir == 3) {
                    dy = y + yy[1];
                    dx = x + xx[1];
                    return new int[]{dy, dx, 1};
                } else {
                    dy = y + yy[2];
                    dx = x + xx[2];
                    return new int[]{dy, dx, 2};
                }

            case '3':
                if (dir == 3) {
                    dy = y + yy[0];
                    dx = x + xx[0];
                    return new int[]{dy, dx, 0};
                } else {
                    dy = y + yy[2];
                    dx = x + xx[2];
                    return new int[]{dy, dx, 2};
                }
            case '4':
                if (dir == 0) {
                    dy = y + yy[3];
                    dx = x + xx[3];
                    return new int[]{dy, dx, 3};
                } else {
                    dy = y + yy[0];
                    dx = x + xx[0];
                    return new int[]{dy, dx, 0};
                }
        }

        return null;
    }*/

    static int[] findStart(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int dy = y + yy[i];
            int dx = x + xx[i];

            if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
                continue;
            }

            if (board[dy][dx] != '.') {
                return new int[]{dy, dx, i};
            }
        }
        return new int[]{0, 0, 0};
    }

    static boolean canFlow(int y, int x, int direction) {
        int dy = y + yy[direction];
        int dx = x + xx[direction];
        char block = board[y][x];

        if (dy < 0 || dx < 0 || dy >= R || dx >= C) {
            return false;
        }

        if (board[dy][dx] == '.' || board[dy][dx] == 'M') {
            return false;
        }

        return true;
    }









}

