package ConTest;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {

    static class Pairs implements Comparable<Pairs> {
        final private int from;
        final private int to;

        Pairs(int from, int to) {
            this.from = from;
            this.to = to;
        }

        int getFrom() {
            return this.from;
        }

        int getTo() {
            return this.to;
        }

        @Override
        public String toString() {
            return "Pairs{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }

        @Override
        public int compareTo(Pairs o) {
            int i = Integer.compare(this.getFrom(), o.getFrom());
            if (i == 0)
                return Integer.compare(this.getTo(), o.getTo());
            return i;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pairs[] a = new Pairs[n];
        for (int i = 0; i < n; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            a[i] = new Pairs(from, to);
        }
        scanner.close();
        Arrays.sort(a);
        System.out.println(getMinPatrols(a, n));
    }

    private static int getMinPatrols(Pairs[] a, int n) {
        int max = 1;
        int start = a[0].getFrom();
        int end = a[0].getTo();
        for (int i = 1; i < n; i++) {
            int from = a[i].getFrom();
            int to = a[i].getTo();
            if (from > end) {
                max++;
                start = from;
                end = to;
            } else {
                start = Math.max(start, from);
                end = Math.min(end, to);

            }
        }
        return max;
    }
}
/*
            if (a[i].getFrom() > end || ((a[i].getFrom() == end) && a[i].getTo() < end) ||
                    ((a[i].getFrom() == start) && (a[i].getTo() == end && end - start == 1))) {
                end = a[i].getTo();
                start = a[i].getFrom();
                max++;
            } else if (a[i].getFrom() > start && a[i].getTo() < end) {
                end = a[i].getTo();
                start = a[i].getFrom();
            }
*/