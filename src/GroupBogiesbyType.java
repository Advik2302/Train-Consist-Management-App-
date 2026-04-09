import java.util.*;
import java.util.stream.Collectors;

public class  GroupBogiesbyType{
    public static void main(String[] args) {

        System.out.println("UC9 - Group Bogies by Type\n");

        // Reuse bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 64));
        bogies.add(new Bogie("AC Chair", 56));

        // Display original list
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ✅ Grouping using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped result
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity: " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping complete...");
    }
}