package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> transactions = new LinkedList<>();
        while (scanner.hasNext()) {
            String nama = scanner.next();
            String transactionType = scanner.next();
            Integer amount = scanner.nextInt();
            transactions.add(new String[]{nama, transactionType, amount.toString()});
        }
        scanner.close();

        LinkedList<String[]> customerRecords = new LinkedList<>();
        for (String[] tx : transactions) {
            String nama = tx[0];
            boolean ada = false;
            for (String[] c : customerRecords) {
                if (c[0].equals(nama)) {
                    ada = true;
                    break;
                }
            }
            if (!ada) {
                customerRecords.add(new String[]{nama, "0"});
            }
        }
        Queue<String[]> queue = new LinkedList<>(transactions);
        Stack<String[]> stack = new Stack<>();

        while (!queue.isEmpty()) {
            String[] tx = queue.poll();
            String nama = tx[0];
            String transactionType = tx[1];
            int amount = Integer.parseInt(tx[2]);
            
            String[] targetCustomer = null;
            for (String[] c : customerRecords) {
                if (c[0].equals(nama)) {
                    targetCustomer = c;
                    break;
                }
            }
            if (targetCustomer != null){
                int saldo = Integer.parseInt(targetCustomer[1]);
                if (transactionType.equals("DEPOSIT")){
                    saldo += amount;
                    targetCustomer[1] = String.valueOf(saldo);
                }else if (transactionType.equals("WITHDRAW")){
                    if (amount <= saldo) {
                        saldo -= amount;
                        targetCustomer[1] = String.valueOf(saldo);
                    } else {
                        stack.push(tx);
                    }
                }
            }
        }
        System.out.println("=== Final Balances ===");
        for (String[] c :customerRecords) {
            System.out.println(c[0] + ": " + c[1]);
        }
        System.out.println();

        System.out.println("=== Failed Transactions ===");
        while (!stack.isEmpty()) {
            String[] failedTx = stack.pop();
            System.out.println(failedTx[0] + " " + failedTx[1] + " " + failedTx[2]);
        }

    }
    
}
