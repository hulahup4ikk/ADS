package Assignment_1;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        String s = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        s = sc.nextLine();
        int N = s.length()-1;

        IsDigit(s, N);
    }

    public static void IsDigit(String s, int N) {
        if (N == -1)
        {
            System.out.println("Yes");
            System.exit(0);
        }
        char ch = s.charAt(N);
        if (ch < 48 || ch >57)
        {
            System.out.println("No");
            System.exit(0);
        }
        IsDigit(s, N-1);
    }
}
