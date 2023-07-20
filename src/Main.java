import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 1969 DNA
public class Main {

    static class Alphabet implements Comparable<Alphabet>{
        int alpha;
        int cnt;


        public Alphabet(int alpha, int cnt) {
            this.alpha = alpha;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Alphabet o) {
            if (this.cnt == o.cnt) {
                return this.alpha - o.alpha;
            }
            return o.cnt - this.cnt;
        }
    }

    static Alphabet[][] alphabets;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        alphabets = new Alphabet[M][26];


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 26; j++) {
                alphabets[i][j] = new Alphabet(j + 65, 0);
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                alphabets[j][c - 65].cnt++;
            }
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(alphabets[i]);
            sum += N - alphabets[i][0].cnt;
            System.out.print((char) alphabets[i][0].alpha);
        }
        System.out.println();

        System.out.println(sum);




    }


}
