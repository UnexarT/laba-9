
public class zad_8 {
    public void zad_8() {
        String text = "В стеклянной тумбочке под телевизором — видеомагнитофон Toshiba " +
                "модели super-high-band Beta со встроенной функцией редактирования, " +
                "включая буквенный генератор с восьмистраничной памятью, high-band-запись," +
                "обратное воспроизведение и трехнедельное предпрограммирование на восемь " +
                "записей. По углам стоят галогеновые лампы. Тонкие белые жалюзи закрывают " +
                "все восемь окон — от пола до потолка. Перед диваном — журнальный столик " +
                "от Turchin (стеклянный верх и дубовые ножки), на котором расставлены " +
                "стеклянные зверюшки от Steuben и дорогие хрустальные пепельницы от " +
                "Fortunoff, хоть я и не курю.";
        String OLDtext = text;
        text = Replace_Chars(text);
        if (!text.equals(OLDtext)){
            System.out.println("Текст зашифрован!");
            System.out.printf("В тексте произошло %d замен", Count(OLDtext));
        }else{
            System.out.println("В тексте нет подходящих замен");
        }
        System.out.println(text);
    }
    public static int Count(String text){
        String[] words = text.split("\\s+");
        int count = 0;
        for (int i = 0; i < words.length; i++){
            if (!words[i].equals(Replace_Chars(words[i]))){
                count++;
            }
        }
        return count;
    }

    public static String Replace_Chars(String text) {
        String replace = text.replaceAll("[mь]","0");
        replace = replace.replaceAll("[jо]","1");
        replace = replace.replaceAll("[lд]","3");
        replace = replace.replaceAll("[uг]","4");
        return replace;
    }
}
