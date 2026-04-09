import java.util.LinkedList;

public class MaintainOrderedBogieIDs {
    public static void main(String[] args) {

        // Step 1: Create LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Step 2: Add bogies in order
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // Step 3: Insert Pantry Car at position 2 (index starts from 0)
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Adding Pantry Car at position 2:");
        System.out.println(trainConsist);

        // Step 4: Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // Step 5: Display final ordered train consist
        System.out.println("\nFinal Train Consist after removing first and last bogies:");
        System.out.println(trainConsist);
    }
}
