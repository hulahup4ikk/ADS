package Assignment_1;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = sc.nextInt();
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                System.out.println("Composite");
                System.exit(0);
            }
        }
        System.out.println("Prime");
    }
}
