package olympics_2021;

import java.util.*;
import java.io.*;

public class X {
    static FastScanner sc;
    static PrintWriter pw;
    static int[] arr;
    private static int mat(int s, int i) {
        int sum = 0;
        for (int j = s; j <= i; j++) {
            sum+=arr[j];
        }
        return (int)Math.ceil((double)sum / (i-s+1));
    }
    private static void solve() {
        int q = sc.ni();
        for (int i = 0; i < q; i++) {
            int s = sc.ni()-1;
            int f = sc.ni()-1;
            int x = s;
            int count = 0;
            while(x < f) {
                x = Math.min(f, x + mat(s,x));
                count++;
            }
            pw.println(count);
        }
    }
    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int n = sc.ni();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.ni();
        }
        solve();
        sc.close();
        pw.close();
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