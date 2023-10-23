import java.util.*;

class Solution {

    static class Store {
        int start;
        int end;
        int length;

        public Store(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start;
        }
    }

    static int dp[];
    static List<Store> list = new ArrayList<>();

    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        dp = new int[sequence.length];
        for(int i=0; i<sequence.length; i++) {
            for(int j=0; j<=i; j++) {
                dp[j] = dp[j] + sequence[i];
                if(dp[j] == k) {
                    list.add(new Store(j, i));
                }
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.length == o2.length) {
                return o1.start - o2.start;
            }
            return o1.length - o2.length;
        });

        Store s = list.get(0);
        int index = 0;
        answer = new int[2];
        answer[0] = s.start;
        answer[1] = s.end;

        return answer;
    }
}