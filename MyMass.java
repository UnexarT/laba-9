import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;

public class MyMass {
    public void PntIntMas_x2(int mas[][]){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void PntDblMas(double mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf(mas[i]+"\t");
        }
        System.out.println();
    }
    public void PntStrMas(String mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("\""+mas[i]+"\""+"\t");
        }
        System.out.println();
    }
    public void PntStrMas_x2(String mas[][]){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void PntDblMas_x2(double mas[][]){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[] RandIntMas(int b, int min, int max) {
        Random rnd = new Random();
        int A[] = new int[b];
        for (int i = 0; i < A.length; i++) {
            A[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return A;
    }
    public int[][] RandIntMas_x2(int a,int b, int min, int max) {
        MyMass arr = new MyMass();
        Random rnd = new Random();
        int A[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            A[i] = arr.RandIntMas(b, min, max);
        }
        return A;
    }
    /*public static void IntSheker(int a[]) {
        MyMass arr = new MyMass();
        int left = 0, right = a.length - 1;
        int flag = 1;
        int count = 0;
        while ((left < right) && flag > 0) {
            flag = 0;
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    flag = 1;
                    count++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    int t = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = t;
                    flag = 1;
                    count++;
                }
            }
            left++;
        }
        arr.PntIntMas(a);
    }
    public void IntBubble(int mass[]){
        MyMass arr = new MyMass();
        int count = 0;
        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < mass.length; j++){
                if (mass[i] >= mass[j]) {
                    int x = mass[i];
                    mass[i] = mass[j];
                    mass[j] = x;
                    count++;
                }
            }
        }
        arr.PntIntMas(mass);
    }*/
    public int GetN(String a){
        Scanner scn = new Scanner(System.in);
        int N = 0;
        while(N == 0) {
            System.out.printf("%s = ", a);
            N = scn.nextInt();
            if (N <= 0) {
                System.out.println("Ошибка в веденных данных!");
                N = 0;
            }
        }
        System.out.println();
        return N;
    }
    public String[] GetStrMas() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите количество элементов массива M:");
        int M = GetN("M");
        String mas[] = new String[M];
        for (int j = 0; j < M; j++) {
            System.out.printf("Задайте %d элемент массива: ", j);
            mas[j] = scn.nextLine();
        }
        return mas;
    }
    public String[][] GetStrMas_x2() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите количество строчек массива N:");
        int N = GetN("N");
        System.out.println("Введите количество столбцов массива M:");
        int M = GetN("M");
        String mas[][] = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("Задайте %d элемент %d строки: ", j, i);
                mas[i][j] = scn.next();
            }
        }
        return mas;
    }
}

