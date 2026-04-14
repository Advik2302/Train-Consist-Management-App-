import java.util.Arrays;

public class BinarySearchBogieID {

    public static boolean binarySearch(String[] array, String key) {
        if (array == null || array.length == 0 || key == null) return false;

        // Ensure array is sorted before searching (as per requirements)
        String[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(sortedArray[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison < 0) {
                high = mid - 1; // Key is smaller, search left half
            } else {
                low = mid + 1; // Key is larger, search right half
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== UC19: Binary Search for Bogie ID ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testBinarySearch_BogieFound()");
        String[] arr1 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG309: " + binarySearch(arr1, "BG309") + " (Expected: true)\n");

        System.out.println("testBinarySearch_BogieNotFound()");
        String[] arr2 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG999: " + binarySearch(arr2, "BG999") + " (Expected: false)\n");

        System.out.println("testBinarySearch_FirstElementMatch()");
        String[] arr3 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG101: " + binarySearch(arr3, "BG101") + " (Expected: true)\n");

        System.out.println("testBinarySearch_LastElementMatch()");
        String[] arr4 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG550: " + binarySearch(arr4, "BG550") + " (Expected: true)\n");

        System.out.println("testBinarySearch_SingleElementArray()");
        String[] arr5 = {"BG101"};
        System.out.println("Result finding BG101: " + binarySearch(arr5, "BG101") + " (Expected: true)\n");

        System.out.println("testBinarySearch_EmptyArray()");
        String[] arr6 = {};
        System.out.println("Result finding BG101: " + binarySearch(arr6, "BG101") + " (Expected: false)\n");

        System.out.println("testBinarySearch_UnsortedInputHandled()");
        String[] arr7 = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        System.out.println("Result finding BG205: " + binarySearch(arr7, "BG205") + " (Expected: true)\n");
    }
}
