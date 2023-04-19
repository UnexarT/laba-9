import java.util.Scanner;


/*Дан массив символов, содержащий число в 12-ой системе счисления. Проверить правильность ввода этого
числа (в его записи должны быть только символы 0, 1, 2,…, 9, A, B). Если число введено неверно,
сообщить об этом пользователю и повторить ввод, ввод должен повторяться до тех пор, пока не будет
введено число. При правильном вводе перевести число в 16-ую систему счисления, записать число в новый
массив символов.
 */
public class zad_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean fl = false;
        while (!fl) {
            System.out.print("Введите число в 12-ой системе счисления: ");
            String input = scn.nextLine().toUpperCase();
            if (input.matches("[0-9A-B]+")) {
                fl = true;
                String hexString = Integer.toHexString(Integer.parseInt(input, 12));
                System.out.println("Введенное число в 16-ой системе счисления: " + hexString.toUpperCase());
            } else {
                System.out.println("Ошибка ввода. В числе могут быть только символы 0-9 и A-B.");
            }
        }
    }
}
