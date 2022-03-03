   public class String52 {

    //Хелали Ахмед
    public static String Uppercase_first_letter(String sentence)
    {
        String []words=sentence.split( " +");
        String temp_word;
        char first_element;

        for (int i = 0; i < words.length ; i++)
        {
            first_element=words[i].charAt(0);
            if((first_element>='а' && first_element<='я') || (first_element>='А' && first_element<='Я') )
            {
                temp_word=Character.toString(Character.toUpperCase(words[i].charAt(0)));

                if(words[i].length()>1)
                {
                    temp_word+=(words[i].substring(1));
                }
                sentence=sentence.replace(" "+words[i]+" "," "+temp_word+" ");

            }
        }
        return sentence;
    }

    public static void main(String[] args) {

        String sentence="Дана строка .предложение на русском /языке Преобразовать *строку так чтобы каждое8 слово начиналось с заглавной буквы";
        System.out.println(sentence+" \n");
        sentence=Uppercase_first_letter(sentence);
        System.out.println(sentence);
    }
}
