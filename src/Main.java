import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 추월
public class Main {

    static int N;

    static int result = 0;

    static class Before {
        public String front;

        public boolean isOk;

        public Before(String s, boolean isOk) {
            this.front = s;
            this.isOk = isOk;
        }
    }


    static HashMap<String, Before> before = new HashMap<>();
    static List<String> afterList = new ArrayList<>();
    static HashMap<String, Integer> after = new HashMap<>();





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        before.put(first, new Before(first, true));
        String front = first;
        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            before.put(s, new Before(front, false));
            front = s;
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            afterList.add(i, s);
            after.put(s, i);
        }


        for (String s : afterList) {
            String ss = s;
            while (true) {
                Before b = before.get(ss);
                Before bb = before.get(b.front);
                if (after.get(s) < after.get(b.front)) {
                    result++;
                    break;
                }
                if (bb.isOk) {
                    b.isOk = true;
                    break;
                }
                ss = b.front;

            }
        }

        System.out.println(result);

    }
}

