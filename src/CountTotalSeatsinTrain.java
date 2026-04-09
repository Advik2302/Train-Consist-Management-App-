
import java.util.*;

public class CountTotalSeatsinTrain {
    public static void main(String[] args) {

        System.out.println("UC10 - Total Seating Capacity using reduce()\n");

        // Reuse bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 64));
        bogies.add(new Bogie("General", 90));

        // Display bogies
        System.out.println("Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ✅ Step 1: Convert to stream
        // ✅ Step 2: map() to extract capacity
        // ✅ Step 3: reduce() to sum
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 aggregation complete...");
    }
}