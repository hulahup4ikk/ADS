package Assignment_1;

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        System.out.print("Введите число: ");
        int k = sc.nextInt();
        System.out.println(BCoef(k, n));
    }

    public static int BCoef(int k, int n) {
        if (k == 0 || k==n)
        {
            return 1;
        }

        return BCoef(k-1, n - 1) + BCoef(k, n - 1);
    }
}
