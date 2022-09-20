package Problems;

import java.util.Scanner;

public class Report {

    static int mMax, nMax;

    private static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] ma = new int[m];
        mMax = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            ma[i] = scanner.nextInt();
            mMax = Integer.max(mMax, ma[i]);
        }
        int[] na = new int[n];
        nMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            na[i] = scanner.nextInt();
            nMax = Integer.max(nMax, na[i]);
        }
        //System.out.println(solveGreedy(k, ma, na, (mMax + nMax) / 2));
        System.out.println(solveNormal(k, ma, na));
    }

    public static int solveGreedy(int k, int[] m, int[] n, int delimiter) {
        int minHeight = -1;
        if (mMax <= delimiter)
            while (mMax <= delimiter)
                delimiter++;
        if (nMax <= k - delimiter)
            while (mMax <= k - delimiter)
                delimiter--;
        Pair pair = compareHeights(delimiter, k, m, n);
        if (pair.a > pair.b)
            return Integer.min(pair.a, solveGreedy(k, m, n, delimiter + 1));
        return Integer.min(pair.a, solveGreedy(k, m, n, delimiter - 1));
    }

    public static Pair compareHeights(int d, int k, int[] m, int[] n) {
        int mHeight = getHeight(m, d);
        int nHeight = getHeight(n, k - d);
        return new Pair(mHeight, nHeight);
    }

    public static int solveNormal(int k, int[] m, int[] n) {
        int minHeight = Integer.MAX_VALUE;
        int mHeight;
        int nHeight;
        for (int i = mMax; i <= k - nMax; i++) {
            mHeight = getHeight(m, i);
            nHeight = getHeight(n, k - i);
            minHeight = Integer.min(minHeight, Integer.max(mHeight, nHeight));
            //System.out.println(minHeight + " " + mHeight + " " + nHeight + " " + i);
        }
        return minHeight;
}

    public static int getHeight(int[] a, int l) {
        int height = 1;
        int length = 0;
        for (int j : a) {
            if (j > l)
                return -1;
            if (length + j < l)
                length += j + 1;
            else if (length + j == l)
                length += j;
            else {
                height++;
                length = j;
                if (length != l)
                    length++;
            }
        }
        return height;
    }
}
/*
* import java.util.Scanner;

public class Raport {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int w = sc.nextInt();
int n = sc.nextInt();
int m = sc.nextInt();
int[] arr1 = new int[n];
int[] arr2 = new int[m];
int max1 = 0, max2 = 0;
for (int i = 0; i < n; i++) {
arr1[i] = sc.nextInt();
max1 = Math.max(max1, arr1[i]);
}
for (int i = 0; i < m; i++) {
arr2[i] = sc.nextInt();
max2 = Math.max(max2, arr2[i]);
}

max2 = w-max2;

int answer = w;
int i = (max1+max2)/2;

while (max1 <= max2){
int count1 = 1, t = -1;
for (int j = 0; j < n; j++) {
if (t + arr1[j] + 1 > i) {
t = arr1[j];
count1++;
} else {
t += arr1[j] + 1;
}
}

int count2 = 1;
t = -1;
for (int j = 0; j < m; j++) {
if (t + arr2[j] + 1 > w-i) {
t = arr2[j];
count2++;
} else {
t += arr2[j] + 1;
}
}

answer = Math.min(answer, Math.max(count1, count2));

if (count1 == count2) {
System.out.println(count1);
System.exit(0);
}

if (count1 > count2) {
max1 = i+1;
} else {
max2 = i-1;
}
i = (max1+max2)/2;
}
System.out.println(answer);
}
}*/