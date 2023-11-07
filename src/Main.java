import java.util.*;

class Solution {
    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {-1, 1, 0, 0};
    static boolean[][] isChecked;
    static int yLength;
    static int xLength;

    public int[] solution(String[] maps) {
        int[] answer = {};D
        yLength = maps.length;
        xLength = maps[0].length();
        List<Integer> list = new ArrayList<>();
        isChecked = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(!isChecked[i][j] && maps[i].charAt(j) != 'X') {
                    list.add(bfs(i, j, maps));

                }
            }
        }
        Collections.sort(list);
        if(list.size() == 0) {
            return new int[]{-1};
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static int bfs(int y, int x, String[] maps) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {y, x});
        isChecked[y][x] = true;
        int sum = Character.getNumericValue(maps[y].charAt(x));;

        while(!que.isEmpty()) {
            int[] now = que.poll();

            for(int i=0; i<4; i++) {
                int dy = now[0] + yy[i];
                int dx = now[1] + xx[i];

                if(dy < 0 || dx < 0 || dy >= yLength || dx >= xLength) {
                    continue;
                }

                if(isChecked[dy][dx] || maps[dy].charAt(dx) == 'X') {
                    continue;
                }
                que.add(new int[] {dy, dx});
                sum += Character.getNumericValue(maps[dy].charAt(dx));
                isChecked[dy][dx] = true;
            }
        }
        return sum;
    }
}