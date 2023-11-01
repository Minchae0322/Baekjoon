import java.util.*;

class Solution {
    static int[] alphabat = new int[26];
    static int[] result;
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        result = new int[targets.length];
        Arrays.fill(alphabat, Integer.MAX_VALUE);
        makeNumber(keymap);
        return solve(targets);


    }

    static int[] solve(String[] targets) {
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            String s = targets[i];
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if(alphabat[c - 65] == Integer.MAX_VALUE) {
                    result[i] = -1;
                    break;
                }
                sum += alphabat[c - 65];
            }
            result[i] = sum;
        }
        return result;
    }

    static void makeNumber(String[] keymap) {
        for(int i=0; i<keymap.length; i++) {
            String s = keymap[i];
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                alphabat[c - 65] = Math.min(j + 1, alphabat[c - 65]);
            }
        }
    }
}