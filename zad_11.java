import java.io.IOException;
import java.util.Scanner;

public class zad_11 {
    public void zad_11(){
        MyMass arr = new MyMass();
        String[] text = arr.GetStrMas();
        String[] NEWtext = Format(text);
        arr.PntStrMas(NEWtext);
    }

    public static String[] Format(String[] text){
        MyMass arr = new MyMass();
        Scanner scn = new Scanner(System.in);
        String[] txt = text;
        System.out.printf("\nЗадайте тип форматирования.\n" +
                "1 - удаление всех букв и пробелов из строки\n" +
                "2 - удаление всех символов кроме букв, цифр и нижнего подчеркивания\n" +
                "3 - добавить тройное восклицание\nОтвет: ");
        int fl = scn.nextInt();
        while (fl > 3 || fl < 1) {
            System.out.printf("Недопустимое значение!\n" +
                    "Введите символы \"1\",\"2\" или \"3\": ");
            fl = scn.nextInt();
        }
        switch(fl){
            case 1:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("[A-Za-zА-Яа-я ]+","");
                }
                break;
            case 2:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("[^\\wА-Яа-я]","");
                }
                break;
            case 3:
                for (int i = 0; i < txt.length; i++){
                    txt[i] = txt[i].replaceAll("!{1,2}","!!!");
                }
                break;
        }
        return txt;
    }
}
