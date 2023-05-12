import java.util.Scanner;

public class zad_3 {
    public void zad_3() {
        MyMass arr = new MyMass();
        System.out.println("Задайте массив символов: ");
        String[] mas = arr.GetStrMas();
        Scanner scn = new Scanner(System.in);
        System.out.printf("Задайте проверяемую латинскую букву: ");
        String n = scn.next();
        Check(Stats(mas,n),n);
    }

    public static void Check(int[] mas, String n) {
        System.out.printf("\nРезультаты:\n");
        System.out.printf("Прописных латинских букв %d штук \n", mas[0]);
        if (mas[1] == 1) { System.out.printf("Буква <<%s>> встречается в массиве\n", n);
        } else {  System.out.printf("Буква <<%s>> не встречается в массиве\n", n);}
        if (mas[2] >= 2){ System.out.println("Запятая встречается в массиве 2-а или более раз");
        } else {  System.out.println("Запятая встречается в массиве менее 2-х раз");}
        if (mas[3] == 1) { System.out.println("Среди элементов встречается <<во>> или <<ов>>");
        } else {  System.out.println("Среди букв не встречается <<во>> или <<ов>>");}
        if (mas[4] == 1) { System.out.println("Среди элементов встречаются одинаковый цифры стоящие подряд");
        } else {  System.out.println("Среди элементов не встречаются одинаковый цифры стоящие подряд");}
        if (mas[5] == 1) { System.out.println("Среди элементов встречаются одинаковые буквы " +
                "разного регистра и нули стоящие подряд");
        } else {  System.out.println("Среди элементов не встречаются одинаковые буквы " +
                "разного регистра и нули стоящие подряд");}
    }

    public static int[] Stats(String[] mas, String n) {
        int arr[] = new int[6];
        for(int i = 0; i < mas.length; i++){
            if (mas[i].matches("[а-яА-Я]+")){
                if (mas[i].matches("[А-Я]+")) {
                    arr[0]++;
                }
                if((mas[i].toUpperCase()).equals(n.toUpperCase())) {
                    arr[1] = 1;
                }
                if((i != mas.length - 1) && ((mas[i].equals("в") && mas[i+1].equals("о"))
                        || (mas[i].equals("о") && mas[i+1].equals("в")))){
                    arr[3] = 1;
                }
                if(i > 1 && i != mas.length-1 && !mas[i].equals(mas[i+1]) && (mas[i].toUpperCase().equals(mas[i+1])
                        || mas[i].toLowerCase().equals(mas[i+1]))) {
                    for (int j = i + 1; j < mas.length - 1; j++) {
                        if (mas[j].equals("0") && mas[j + 1].equals("0")) {
                            arr[5] = 1;
                        }
                    }
                }
            }else if (mas[i].equals(",")){
                arr[2]++;
            }else if (i != mas.length - 1 && mas[i].matches("[0-9]+")
                    && mas[i+1].matches("[0-9]+") && mas[i].equals(mas[i+1])){
                arr[4] = 1;
            }
        }
        return arr;
    }
}

