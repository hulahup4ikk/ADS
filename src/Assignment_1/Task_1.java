package Assignment_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[1];
        for (int i = 1; i < N; i++) {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
