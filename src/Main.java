import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.function.IntPredicate;

//todo 1343 폴리오미노
public class Main {






    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder result = new StringBuilder();
        String[] ss = s.split("\\.");

        for (int i = 0; i < ss.length; i++) {
            if (ss[i].length() % 2 == 1) {
                System.out.println(-1);
                return;
            }
            if (ss[i].length() == 4) {
                result.append("AAAA");
            } else {
                result.append("BB");
            }
            result.append(".");
        }

        if (s.charAt(0) == '.') {
            System.out.println("." + result);
        } else {
            System.out.println(result);
        }






    }









}

