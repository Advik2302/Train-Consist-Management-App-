import java.util.*;
        import java.util.stream.Collectors;

// Bogie class


public class FilterPassengerBogiesUsingStreams {
    public static void main(String[] args) {

        System.out.println("UC8 - Filter Passenger Bogies Using Streams\n");

        // Reuse list from UC7
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 64));
        bogies.add(new Bogie("General", 90));

        // Display original list
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ✅ Stream filtering (capacity > 60)
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Display filtered list
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 filtering complete...");
    }
}