package Assignment_1;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        printArray(arr, N-1);
    }

    public static void printArray(int[] arr, int N) {
        if (N == 0)
        {
            System.out.println(arr[N]);
            return;
        }
        System.out.print(arr[N] + " ");
        printArray(arr, N-1);
    }
}
