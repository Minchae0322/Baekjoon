import java.util.*;

class Solution {
    static int[] sequencePlus;
    static int[] sequenceMinus;
    static int sequenceLength;
    static long max = -100001;

    public long solution(int[] sequence) {
        sequenceLength = sequence.length;
        sequencePlus = new int[sequenceLength];
        sequenceMinus = new int[sequenceLength];
        getSequencePulse(sequence);
        getMaxSum(sequencePlus);
        getMaxSum(sequenceMinus);
        return max;
    }

    static void getSequencePulse(int[] sequence) {
        for(int i=0; i<sequenceLength; i++) {
            if(i % 2 == 0) {
                sequencePlus[i] = sequence[i];
                sequenceMinus[i] = -sequence[i];
            } else {
                sequenceMinus[i] = sequence[i];
                sequencePlus[i] = -sequence[i];
            }
        }
    }

    static void getMaxSum(int[] sequence) {
        long sum = 0;
        for(int i=0; i<sequenceLength; i++) {
            sum += sequence[i];
            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
    }
}