import java.util.Scanner;

public class zad_11 {
    public static void main(String[] args) {
        MyMass arr = new MyMass();
        String[] text = arr.GetStrMas();
        String[] NEWtext = Format(text);
        arr.PntStrMas(NEWtext);
    }

    public static String[] Format(String[] text){
        String[] txt = text;
        System.out.printf("\nЗадайте тип форматирования.\n" +
                "1 - удаление всех букв и пробелов из строки\n" +
                "2 - удаление всех символов кроме букв, цифр и нижнего подчеркивания\n" +
                "3 - добавить тройное восклицание\n");
        Scanner scn = new Scanner(System.in);
        switch(scn.nextInt()){
            case 1:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("[A-Za-z]+"," ");
                }
            case 2:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("[^\\w]","");
                }
            case 3:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("!{1,2}","!!!");
                }
        }
        return txt;
    }
}
