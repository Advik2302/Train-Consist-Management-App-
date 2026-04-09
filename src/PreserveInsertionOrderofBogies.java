import java.util.LinkedHashSet;

public class PreserveInsertionOrderofBogies {
    public static void main(String[] args) {

        // Step 1: Create LinkedHashSet for train formation
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Step 2: Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Step 3: Attempt to add duplicate bogie
        trainFormation.add("Sleeper"); // Duplicate - will be ignored

        // Step 4: Display final formation
        System.out.println("Final Train Formation (Insertion Order Preserved):");
        System.out.println(trainFormation);
    }
}