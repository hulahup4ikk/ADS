package Assignment_1;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = sc.nextInt();
        System.out.print("Введите степень: ");
        int n = sc.nextInt();
        System.out.println(power(a,n));
    }

    public static int power(int a, int b) {
        if (b == 0)
        {
            return 1;
        }
        return a * power(a,b-1);
    }
}
