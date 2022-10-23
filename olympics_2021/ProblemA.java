package olympics_2021;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    private static FastScanner scanner;

    public static void main(String[] args) {

        String answer = solve() ? "Yes" : "No";
        System.out.println(answer);
    }

    public static boolean solve() {
        scanner = new FastScanner();
        if (scanner.ni() != 1)
            return false;

        for (int i = 2; i <=5 ; i++) {
            boolean a = readInput(i);
            if (!a)
                return false;
        }
        return true;
    }

    public static boolean readInput(int n){
        boolean a = false;
        boolean b ;
        int c = 0;
        for (int i = 0; i <n ; i++) {
            c = scanner.ni();
            if (i==0)
                a = checkType(c);
            if (i !=1 && n != 3 && c==8) {
                return false;
            }
            if (i ==1 && n == 3 && c!=8){
                return false;
            }
        }
        b = checkType(c);
        return (a != b);
    }

    public static boolean checkType(int n) {
        // is striped -> true
        // is soilid -> true
        return n >= 1 && n <= 7;
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String filePath) {
            try {
                br = new BufferedReader(new FileReader(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        /**
         * @return an array of characters from the string read using next();
         */
        char[] nc() {
            return next().toCharArray();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
