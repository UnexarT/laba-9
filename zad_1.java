public class zad_1 {
    public static void main(String[] args) {
        MyMass arr = new MyMass();
        String[][] mas = arr.GetStrMas_x2();
        System.out.printf("\nСлово <<no>> встречается %d раз(а)",no_Column(mas) + no_Line(mas));
    }

    public static int no_Line(String[][] mas) {
        int cnt = 0;
        for(int j = 0; j < mas.length; j++){
            for (int i = 0; i < mas[0].length - 1; i += 2) {
                if (mas[j][i].equals("n") && mas[j][i + 1].equals("o")) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int no_Column(String[][] mas) {
        int cnt = 0;
        for(int j = 0; j < mas[0].length; j++){
            for (int i = 0; i < mas.length - 1; i += 2) {
                if (mas[i][j].equals("n") && mas[i+1][j].equals("o")) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
