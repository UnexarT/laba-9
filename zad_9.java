import java.util.Scanner;

public class zad_9 {
    public void zad_9() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scn.nextLine();
        String replace = Replace_Coms(text);
        if (replace.equals(text)){
            System.out.println("Комментарий в тексте нет");
        }else{
            System.out.printf("\nКомментарии удалены!\n\nИзмененный текст:\n%s",replace);
        }
    }

    public static String Replace_Coms(String text) {
        String replace = text.replaceAll("-.+-","");
        replace = replace.replaceAll("_.+_","");
        replace = replace.replaceAll("=.+=","");
        return replace;
    }

}
