import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.function.IntPredicate;

//todo 추월
public class Main {


    static int N;
    static List<Num> list = new ArrayList<>();

    static class Num {
        public char[] num;
        public int strike;
        public int ball;

        public Num(char[] num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            list.add(new Num(new char[]{num.charAt(0), num.charAt(1), num.charAt(2)}, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 111; i <= 999; i++) {
            String str = String.valueOf(i);
            if(str.charAt(0)=='0' || str.charAt(1)=='0' || str.charAt(2)=='0') continue;

            // 문제에 따르면 모든 자릿수의 숫자가 달라야 하기 때문에 같은 숫자가 있을 경우 제외
            if(str.charAt(0)==str.charAt(1) || str.charAt(0)==str.charAt(2) || str.charAt(1)==str.charAt(2)) continue;
            if (run(i)) {
                result++;
            }
        }

        System.out.println(result);


    }

    static boolean run(int expectedNum) {
        String ex = String.valueOf(expectedNum);
        for (Num now : list) {
            // System.out.println(ex +  " strike: " + getStrike(ex, now));
            int strike = getStrike(ex, now);
            if (now.strike != strike) {
                return false;
            }
            //System.out.println(ex +  " ball: " + getBall(ex, now));
            if (now.ball != getBall(ex, now) - strike) {
                return false;
            }
        }
        return true;
    }

    static int getStrike(String ex, Num now) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (ex.charAt(i) == now.num[i]) {
                strike++;
            }
        }
        return strike;
    }


    static int getBall(String ex, Num now) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (ex.contains(String.valueOf(now.num[i]))) {
                ball++;
            }
        }
        return ball;
    }







}

