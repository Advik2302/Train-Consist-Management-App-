import java.util.Arrays;

public class BubbleSortBogieCapacities {

    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap adjacent elements
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UC16: Sort Passenger Bogies by Capacity (Bubble Sort) ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testSort_BasicSorting()");
        int[] arr1 = {72, 56, 24, 70, 60};
        System.out.println("Original: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1) + " (Expected: [24, 56, 60, 70, 72])\n");

        System.out.println("testSort_AlreadySortedArray()");
        int[] arr2 = {24, 56, 60, 70, 72};
        System.out.println("Original: " + Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("Sorted: " + Arrays.toString(arr2) + " (Expected: [24, 56, 60, 70, 72])\n");

        System.out.println("testSort_DuplicateValues()");
        int[] arr3 = {72, 56, 56, 24};
        System.out.println("Original: " + Arrays.toString(arr3));
        bubbleSort(arr3);
        System.out.println("Sorted: " + Arrays.toString(arr3) + " (Expected: [24, 56, 56, 72])\n");

        System.out.println("testSort_SingleElementArray()");
        int[] arr4 = {50};
        System.out.println("Original: " + Arrays.toString(arr4));
        bubbleSort(arr4);
        System.out.println("Sorted: " + Arrays.toString(arr4) + " (Expected: [50])\n");

        System.out.println("testSort_AllEqualValues()");
        int[] arr5 = {40, 40, 40};
        System.out.println("Original: " + Arrays.toString(arr5));
        bubbleSort(arr5);
        System.out.println("Sorted: " + Arrays.toString(arr5) + " (Expected: [40, 40, 40])\n");
    }
}
