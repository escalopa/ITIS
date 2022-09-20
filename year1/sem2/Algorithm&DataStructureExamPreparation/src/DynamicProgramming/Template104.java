package DynamicProgramming;

import java.util.Scanner;

public class Template104 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String template = scanner.nextLine();

        System.out.println(containsTemplate(line, template) ? "YES" : "NO");
    }

    public static boolean containsTemplate(String line, String template) {

        boolean contains = false;
        int templatePointer = 0;
        int max = template.length();
        for (int i = 0; i < line.length(); i++) {
            if (templatePointer == max) {
                contains = true;
                break;
            }
            char charLine = line.charAt(i);
            char charTemplate = template.charAt(templatePointer);
            if (charLine == charTemplate)
                templatePointer++;
            else if (charTemplate == '?') {
                templatePointer++;
            } else if (charTemplate == '*') {
                if (templatePointer < template.length() - 1) {
                    char target = template.charAt(++templatePointer);
                    // The sequence is the same as the letter that is after the star
                    if (target == charLine) {
                        for (; i < line.length(); i++, charLine = line.charAt(i)) {
                            if (target != charLine) {
                                i--;
                                templatePointer++;
                                break;
                            }
                        }
                    }
                    // The sequence is the DIFFERENT than the letter that is after the star
                    else {
                        char lastInSequence = charLine;
                        charLine = line.charAt(++i);
                        for (; i < line.length(); i++, charLine = line.charAt(i)) {
                            if (target == charLine) {
                                templatePointer++;
                                break;
                            }
                            if (lastInSequence != charLine) {
                                templatePointer = 0;
                                break;
                            }
                        }
                    }
                }
            } else
                templatePointer = 0;
        }
        if (templatePointer == max)
            contains = true;
        return contains;
    }
}
