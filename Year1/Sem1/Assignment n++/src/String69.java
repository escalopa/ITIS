public class String69 {

    //Хелали Ахмед
    public static int get_brackets(String sentence) {
        int count_normal = 0, count_normal_close = 0;
        for (int i = 0; i < sentence.length(); i++) {
            switch (sentence.charAt(i)) {
                case ')' -> count_normal_close++;
                case '(' -> count_normal++;
            }
            if (count_normal_close > count_normal) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence = "((s))j(fk)))";
        String sentence2 = "d[)h}}{]]kp}m{]}{vGgL[Ji)(a]PVBI)Elg))[v[KOQ[W{})a";
        String sentence3 = "53465g678jUVCD$%^*&T^HBHGVD66gh))(({{}}[[]]";
        System.out.println(get_brackets(sentence));
    }
}
