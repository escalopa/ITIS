public class String57 {

    //Хелали Ахмед
    public static String Space_remover(String sentence, int start_at,int lenght)
    {
        for (; start_at+2<lenght; start_at++)
        {
            if (sentence.charAt(start_at+1)==' ' && sentence.charAt(start_at+2)==' ')
            {
                lenght--;
                sentence= sentence.substring(0,start_at+1 ) + sentence.substring(start_at+2);
                start_at--;
            }
        }
        return sentence;
    }
    public static void main(String[] args) {
        String sentence="Дана    строка-предложение  с   избыточными          пробелами     между    словами.   Преобразовать ее так, чтобы  между   словами    был    ровно  один   пробел. ";
        System.out.println(sentence);
        sentence=Space_remover(sentence,0,sentence.length());
        System.out.println(sentence);
    }
}
