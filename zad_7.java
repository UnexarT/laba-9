import java.util.Scanner;

public class zad_7 {
    public void zad_7() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Задайте строку: ");
        String text = scn.nextLine();
        System.out.printf("\nТекущая строка:\n%s\n\nИзмененная строка:\n",text);
        System.out.println(Arguments(text));
    }

    public static String Arguments(String text) {
        String ln  = "ln", exp= "exp", ch = "ch", sh = "sh", arg ="(x-y)";
        String replace = text.replace(ln,ln+arg);
        replace = replace.replace(exp,exp+arg);
        replace = replace.replace(ch,ch+arg);
        replace = replace.replace(sh,sh+arg);
        return replace;
    }
}
