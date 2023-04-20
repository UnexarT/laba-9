import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zad_4 {
    public static void main(String[] args) {
        MyMass arr = new MyMass();

        System.out.println("Задайте массив символов: ");
        String[][] mas = arr.GetStrMas_x2();
        if (mas.length < 13 && mas[0].length < 13) {
            System.out.println("В массиве недостаточно символов!");
        } else {
            System.out.println(Array(mas));
        }
    }

    public static ArrayList<String> Array(String[][] mas) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list = List(mas);
        Pattern pattern = Pattern.compile("[+-]|\\d+");
        for (String i : list) {
            Matcher matcher = pattern.matcher(i);
            while (matcher.find()) {
                list1.add(i.substring(matcher.start(), matcher.end()));
            }
            int[] mas1 = Check(list1);
            if (mas1[2] != Integer.parseInt(list1.get(6))){
                System.out.printf("Выражение %s неверно!\n",i);
                String tr = Integer.toString(mas1[2]);
                list.set(list.indexOf(i),"("+list1.get(0)+list1.get(1)+list1.get(2)+")/("
                        +list1.get(3)+list1.get(4)+list1.get(5)+")="+tr);
            }
            list1.clear();
        }
        System.out.printf("\nИтоговый ArrayList: \n");
        return list;
    }

    public static int[] Check(ArrayList<String> list) {
        int[] mas = new int[3];
        if (list.get(1).equals("+")) {
            mas[0] = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(2));
            if (list.get(4).equals("+")) {
                mas[1] = Integer.parseInt(list.get(3)) + Integer.parseInt(list.get(5));
            } else {
                mas[1] = Integer.parseInt(list.get(3)) - Integer.parseInt(list.get(5));
            }
        } else {
            mas[0] = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(2));
            if (list.get(4).equals("+")) {
                mas[1] = Integer.parseInt(list.get(3)) + Integer.parseInt(list.get(5));
            } else {
                mas[1] = Integer.parseInt(list.get(3)) - Integer.parseInt(list.get(5));
            }
        }
        mas[2] = mas[0]/mas[1];
        return mas;
    }

    public static ArrayList<String> List(String[][] mas) {
        Pattern pattern = Pattern.compile("\\(\\d+[+-]\\d+\\)/\\(\\d+[+-]\\d+\\)=\\d+");
        ArrayList<String> list = new ArrayList<>();
        String text1 = "";
        String text2 = "";
        for (int j = 0; j < mas.length; j++) {
            for (int i = 0; i < mas[0].length; i++) {
                text1 += mas[j][i];
                text2 += mas[i][j];
            }
            Matcher matcher1 = pattern.matcher(text1);
            while (matcher1.find()){
                list.add(text1.substring(matcher1.start(), matcher1.end()));
            }
            Matcher matcher2 = pattern.matcher(text2);
            while (matcher1.find()){
                list.add(text2.substring(matcher2.start(), matcher2.end()));
            }
            text1 = "";
            text2 = "";
        }
        return list;
    }
}
