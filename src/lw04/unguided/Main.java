package lw04.unguided;

import java.util.Scanner;

public class Main {
    static void sortCards(int[] arr, int passes){
        for (int i = 0; i < passes; i++) {
            int index = i;

            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[index]) {
                    index = j;
                }
            }
            int simpan = arr[i];
            arr[i] = arr[index];
            arr[index] = simpan;

        }
    }

    static int findCard(int[] arr, int target){
        for(int i = 0; i<arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int N = scanner.nextInt();
        int[] kartu = new int[N];

        for (int i = 0 ; i < N; i++) {
            kartu[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] minta = new int[M];

        for (int i = 0; i < M; i++){
            minta[i] = scanner.nextInt();
        }

        scanner.close();
        sortCards(kartu, 2);

        for (int i = 0; i < N; i++) {
            if (i>0) System.out.print(" ");
            System.out.print(kartu[i]);
        }
        System.out.println();

        for(int i = 0; i < M; i++){
            int hasil = findCard(kartu, minta[i]);
            if (hasil != -1) {
                System.out.println(minta[i] + " : FOUND at index " + hasil);
            }else {
                System.out.println(minta[i] + " : NOT FOUND");
            }
        }


    }
}
