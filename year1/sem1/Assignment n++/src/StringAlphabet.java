public class StringAlphabet {

    //Хелали Ахмед
    public static void count_letters(String sentence)
    {
        int []alphabet= new int[26];
        char letter, start='A';
        for (int i = 0; i <sentence.length() ; i++) {
            letter=sentence.charAt(i);
            if (letter>='a' && letter<='z')
            {
                alphabet[letter-97]+=1;
            }
            if (letter>='A' && letter<='Z')
            {
                alphabet[letter-65]+=1;
            }
        }
        for (; start <='Z' ; start++) {
            System.out.println("Буква ("+start+") повторилась "+alphabet[start-65]);
        }
    }
    public static void main(String[] args) {
        String sentence="I hope not. You might pull a muscle You need to start small in order to achieve something big like that. When it comes to learning English, what if I told you that you can understand big ideas with just a little bit of text? You do not need to wait several years to deal with complex concepts. Just because you are learning a language does not mean you need to limit your thinking. Stories are all about going beyond reality. It is no wonder that they let you understand big concepts with only a little bit of reading practice. But this works better when you’re reading better stories. I am talking about award-winning short stories, told using language easily understood by beginners. These will not only improve your English reading comprehension but also open your mind to different worlds.";
        count_letters(sentence);

    }
}
