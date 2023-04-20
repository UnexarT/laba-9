public class zad_1 {
    public static void main(String[] args) {
        MyMass arr = new MyMass();
        System.out.println("Задайте матрицу символов: ");
        String[][] mas = arr.GetStrMas_x2();
        int[] no = no_count(mas);
        System.out.printf("\nСлово <<no>> встречается %d раз(а) в строке и %d раз в столбце",no[0],no[1]);
    }

    public static int[] no_count(String[][] mas) {
        int[] arr = new int[2];
        for (int j = 0; j < mas.length; j++) {
            for (int i = 0; i < mas[0].length - 1; i++) {
                if (mas[j][i].equals("n") && mas[j][i + 1].equals("o")) {
                    arr[0]++;
                }
                if (mas[i][j].equals("n") && mas[i + 1][j].equals("o")) {
                    arr[1]++;
                }
            }
        }
        return arr;
    }
}
