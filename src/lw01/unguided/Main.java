package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        int totalRecords = scanner.nextInt();
        Rental[] rentals = new Rental[totalRecords]; 

        int index = 0;
        while (scanner.hasNext() && index < totalRecords) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            Rental rental;
            if (type.equalsIgnoreCase("LAPTOP")) {
                rental = new LaptopRental(id, days, units);
            } else {
                rental = new ProjectorRental(id, days, units);
            }

            rentals[index] = rental;
            index++;
        }

        scanner.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}
