import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo 9012 DNA
public class Main {

    static int N;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            String s = br.readLine();
            int num = s.length();
            if (run(num, s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static boolean run(int num, String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < num; i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    stack.push('(');
                    continue;
                }

                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
            return stack.isEmpty();
        }
    }

