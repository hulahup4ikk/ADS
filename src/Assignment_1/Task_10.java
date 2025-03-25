package Assignment_1;

import java.util.Scanner;

public class Task_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = sc.nextInt();
        System.out.print("Введите число: ");
        int b = sc.nextInt();

        System.out.println(GCD(a,b));
    }

    public static int GCD(int a, int b) {
        if (a%b == 0)
            return b;
        else
            return GCD(b, a % b);
    }
}
