package lw04.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(Main.class.getResourceAsStream("branches.txt"));

      int n = scanner.nextInt();
      int[] a = new int[n];

       for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        int[] target = new int[m];

        for (int i = 0; i < m; i++) {
            target[i] = scanner.nextInt();
        }

        scanner.close();
for (int j = 1; j <= 3; j++) {

            int key = a[j];
            int i = j - 1;

            while (i >= 0 && a[i] < key) {
                a[i + 1] = a[i];
                i--;
            }

            a[i + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < m; i++) {

            int index = -1;

            for (int j = 0; j < n; j++) {
                if (a[j] == target[i]) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                System.out.println(target[i] + ": FOUND at index " + index);
            } else {
                System.out.println(target[i] + ": NOT FOUND");
            }
        }
    }

}
