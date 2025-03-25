package Assignment_1;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = sc.nextInt();
        System.out.println(fact(N));
    }

    public static int fact(int N) {
        if (N <= 1)
        {
            return 1;
        }
         return N * fact(N - 1);
    }
}
