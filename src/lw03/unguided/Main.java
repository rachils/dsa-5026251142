package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        
        Map<String, Integer> enrollment = new LinkedHashMap<>();

        int gagal = 0;
        System.out.println("===== Enrollment Checks =====");

        while(scanner.hasNext()){
            String operation = scanner.next();
            if(operation.equals("REGISTER")){
                String id = scanner.next();
                int count = scanner.nextInt();

                if (count <= 0){
                    gagal++;
                } else if(enrollment.containsKey(id) && count > 0){
                    int total = enrollment.get(id);
                    total += count;
                    enrollment.put(id, total);
                } else{
                    int total = 0;
                    total = count;
                    enrollment.put(id, total);
                }
            } else if(operation.equals("WITHDRAW")){
                String id = scanner.next();
                int count = scanner.nextInt();

                if(enrollment.containsKey(id) && enrollment.get(id) >= count){
                    int total = enrollment.get(id);
                    total -= count;
                    enrollment.put(id, total);
                } else{
                    gagal++;
                }
        }     else if(operation.equals("CHECK")){
                  String id = scanner.next();
                  if(enrollment.containsKey(id)){
                    System.out.println(id + " : " + enrollment.get(id));
                  } else{
                    System.out.println(id + " : " + "Not Found" );
                  }
        }       
        }  scanner.close();
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String id : enrollment.keySet()){
            System.out.println(id + " : " + enrollment.get(id));
        }
        System.out.println();
        System.out.println("Rejected operations: " + gagal);
    }
    
}
