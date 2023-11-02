import java.util.*;

class Solution {
    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            return this.end - o.end;
        }
    }

    static Queue<Schedule> que = new PriorityQueue<>();
    static List<Schedule> list = new ArrayList<>();
    static int maxRoom = 0;

    public int solution(String[][] book_time) {
        int answer = 0;
        for(int i=0; i<book_time.length; i++) {
            int start = timeToMinute(book_time[i][0]);
            int end = timeToMinute(book_time[i][1]);
            list.add(new Schedule(start, end));
        }
        list.sort(((o1, o2) -> o1.start - o2.start));

        for(Schedule s : list) {
            if(que.isEmpty()) {
                que.add(s);
                maxRoom = Math.max(maxRoom, que.size());
                continue;
            }
            Schedule now = que.poll();
            if(now.end + 10 > s.start) {
                que.add(now);
            }
            que.add(s);
            maxRoom = Math.max(maxRoom, que.size());
        }

        return maxRoom;
    }


    static int timeToMinute(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3));
        return hour * 60 + minute;
    }
}