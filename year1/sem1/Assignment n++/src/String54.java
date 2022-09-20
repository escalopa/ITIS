public class String54 {

    //Хелали Ахмед
    public static void main(String[] args) {
        String sentence="Дана строка предложение на русском языке Подсчитать количество содержащихся в строке гласных букв";
        String vowels="аяоёэеуюыиАЯОЁЭЕУЮЫИ";
        int count =0;
        for (int i = 0; i <sentence.length(); i++) {
            if (vowels.contains(Character.toString(sentence.charAt(i)))) {
                count++;
                System.out.print(sentence .charAt(i));
            }
        }

        System.out.println("\nколичество содержащихся в строке гласных букв равно "+count);
    }
}
