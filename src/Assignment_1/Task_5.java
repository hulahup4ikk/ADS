package Assignment_1;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = sc.nextInt();

        System.out.println(fibonacci(N));
    }

    public static int fibonacci(int n) {
        if (n < 2)
        {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
