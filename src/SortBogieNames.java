import java.util.Arrays;

public class SortBogieNames {

    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        System.out.println("=== UC17: Sort Bogie Names Using Arrays.sort() ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testSort_BasicAlphabeticalSorting()");
        String[] arr1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Original: " + Arrays.toString(arr1));
        sortBogieNames(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1) + " (Expected: [AC Chair, First Class, General, Luxury, Sleeper])\n");

        System.out.println("testSort_UnsortedInput()");
        String[] arr2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        System.out.println("Original: " + Arrays.toString(arr2));
        sortBogieNames(arr2);
        System.out.println("Sorted: " + Arrays.toString(arr2) + " (Expected: [AC Chair, General, Luxury, Sleeper])\n");

        System.out.println("testSort_AlreadySortedArray()");
        String[] arr3 = {"AC Chair", "First Class", "General"};
        System.out.println("Original: " + Arrays.toString(arr3));
        sortBogieNames(arr3);
        System.out.println("Sorted: " + Arrays.toString(arr3) + " (Expected: [AC Chair, First Class, General])\n");

        System.out.println("testSort_DuplicateBogieNames()");
        String[] arr4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        System.out.println("Original: " + Arrays.toString(arr4));
        sortBogieNames(arr4);
        System.out.println("Sorted: " + Arrays.toString(arr4) + " (Expected: [AC Chair, General, Sleeper, Sleeper])\n");

        System.out.println("testSort_SingleElementArray()");
        String[] arr5 = {"Sleeper"};
        System.out.println("Original: " + Arrays.toString(arr5));
        sortBogieNames(arr5);
        System.out.println("Sorted: " + Arrays.toString(arr5) + " (Expected: [Sleeper])\n");
    }
}
