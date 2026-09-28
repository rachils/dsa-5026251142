package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

       while(scanner.hasNext()){
            String[] borrow = new String[2];
            borrow[0] = scanner.next();
            borrow[1] = scanner.next();
            request.add(borrow);
        }
        scanner.close();

        queue.addAll(request);

        System.out.println("=== Successfully Processed Requests ===");

         while(!queue.isEmpty()){
            String[] borrow = queue.poll();

            String name = borrow[0];
            String bookTitle = borrow[1];

            String[] member = null;

            for(String[] data : members){
                if(data[0].equals(name)){
                    member = data;
                    break;
                }
            }
             if(member == null){
                member = new String[]{name,"0"};
                members.add(member);
            }

            String[] book = null;
            for(String[] data : books){
                if(data[0].equals(bookTitle)){
                    book = data;
                    break;
                }
            }
            int stock = Integer.parseInt(book[1]);
            int maxBorrow = Integer.parseInt(member[1]);

            if(stock > 0 && maxBorrow < 2){
                stock--;
                maxBorrow++;
                book[1] = String.valueOf(stock);
                member[1] = String.valueOf(maxBorrow);

                System.out.println(borrow[0] + " " + borrow[1]);
            } else {
                failed.push(borrow);
            }
        }
    
        System.out.println("=== Remaining Book Stock ===");
        for(String[]buku : books){
            System.out.println(buku[0] + " : " + buku[1]);
        }
        System.out.println("=== Failed Requests === ");
        while (!failed.isEmpty()) {
            String[] borrow = failed.pop();
            System.out.println(borrow[0] + " " + borrow[1]);
        }




    }
    
}
