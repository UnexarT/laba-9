import java.util.Scanner;

public class zad_5 {
    public void zad_5() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Задайте строку: ");
        String text = scn.next();
        System.out.printf("\nТекущая строка:\n%s\n\nИзмененная строка:\n",text);
        System.out.println(Replace_adnz(text));
    }

    public static String Replace_adnz(String text) {
        String replace = text.replace('a','@');
        replace = replace.replace('d','$');
        replace = replace.replace('n','№');
        replace = replace.replace('z','*');
        return replace;
    }
}
