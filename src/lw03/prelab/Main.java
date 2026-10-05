package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//problem 1
    Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();

    // ternyata aku belum split biar lagunya bisa dua kata g satu kata doang
    // while
    // String[] parts = line.split(" ", 2);
    //String operation = parts[0]
    //String song = parts[1];
    //if(operation.equals("ADD")){
    // playlist.add(song);
    //} else if( operation.equals("INSERT")){
    // String[] insertData = song.split( " ", 2);
    //int index = Integer.parseInt(insertData[0]);
    //String songName = insertData[1];
    // playlist.add(index, songName)}

    while(scanner.hasNext()){
        String type = scanner.next();
        

        if(type.equals("ADD")){
            String title = scanner.next();
            playlist.add(title);
        }else if(type.equals("INSERT")){
            int index = scanner.nextInt();
            String title = scanner.next();
            playlist.add(index, title);

        } else if(type.equals("REMOVE")){
            String title = scanner.next();
            playlist.remove(title);
        }
    } scanner.close();

    System.out.println("===== Problem 1 =====");
    System.out.println("Total songs:" + playlist.size());
    for (int i = 0 ; i  < playlist.size(); i++){
        System.out.println((i+1) + " : " + playlist.get(i));
    }
    System.out.println();
//problem 2
    Scanner scanner2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
    int duplicate = 0;
    int unik = 0;
    Set<String> participants = new LinkedHashSet<>();
    while(scanner2.hasNext()){
        String nama = scanner2.next();

        if(participants.contains(nama)){
            duplicate++;
        } else {
            unik++;
            participants.add(nama);
        }
    } scanner2.close();
    System.out.println("===== Problem 2 ===== ");
    System.out.println("Unique participants: " + unik);
    int nomor = 1;
    for(String nama : participants){
        System.out.println(nomor + ": " + nama); 
        nomor++;
    }
    System.out.println("Duplicate registrations: " + duplicate);
    System.out.println();

// problem 3
    Scanner scanner3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
    Map<String, Integer> inventory = new LinkedHashMap<>();
    int gagal = 0;
    while(scanner3.hasNext()){
        String type = scanner3.next();
        if(type.equals("ADD")){
            String product = scanner3.next();

            if(inventory.containsKey(product)){
             int quantity = scanner3.nextInt();
             int total = inventory.get(product);
             total += quantity;
            inventory.put(product, total);
            } else{
                int total = 0;
                int quantity = scanner3.nextInt();
                total = quantity;
                inventory.put(product, total);
            }
            
        }else if(type.equals("SELL")){
            String product = scanner3.next();
            int quantity = scanner3.nextInt();
            if(inventory.containsKey(product)&& inventory.get(product) > quantity){
                int total = inventory.get(product);
                total -= quantity;
                inventory.put(product, total);
            } else{
                gagal++;
            }
        }
        
        
    } scanner3.close();
    System.out.println("===== Problem 3 =====");
    for (String product : inventory.keySet()){
        System.out.println(product + " : " + inventory.get(product));
    }
    System.out.println("Failed sales: " + gagal);
    }

}
