import javax.swing.*;

public class Palindrome {

    public static boolean Check(String Sentence)
    {
        if(Sentence.charAt(0)!=Sentence.charAt(Sentence.length()-1))
        {
            return false;
        }
        if(Sentence.length()<=1)
        {
            return true;
        }
        return Check(Sentence.substring(1,Sentence.length()-1));
    }

    public static void main(String[] args) {
        boolean Palindrome;
        String Sentence="abcaabcba";
        Palindrome=Check(Sentence);
        System.out.println(Palindrome);
    }
}