import java.util.HashMap;
import java.util.Map;

public class MapBogietoCapacity {
    public static void main(String[] args) {

        // Create HashMap to store bogie and capacity
        HashMap<String, Integer> bogieMap = new HashMap<>();

        // Insert values using put()
        bogieMap.put("Sleeper", 72);
        bogieMap.put("AC Chair", 78);
        bogieMap.put("First Class", 24);
        bogieMap.put("Goods Rectangular", 100);
        bogieMap.put("Goods Cylindrical", 120);

        // Display bogie capacity details
        System.out.println("Train Bogie Capacity Details:\n");

        // Iterate using entrySet()
        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }
    }
}