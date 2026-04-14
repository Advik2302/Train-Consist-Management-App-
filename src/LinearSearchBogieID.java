public class LinearSearchBogieID {

    public static boolean linearSearch(String[] bogieIds, String searchKey) {
        if (bogieIds == null || searchKey == null) return false;

        for (String id : bogieIds) {
            // Compare each ID safely
            if (searchKey.equals(id)) {
                return true; // Match found, stop searching early terminating
            }
        }
        return false; // Loop completed without match
    }

    public static void main(String[] args) {
        System.out.println("=== UC18: Linear Search for Bogie ID ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testSearch_BogieFound()");
        String[] arr1 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG309: " + linearSearch(arr1, "BG309") + " (Expected: true)\n");

        System.out.println("testSearch_BogieNotFound()");
        String[] arr2 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG999: " + linearSearch(arr2, "BG999") + " (Expected: false)\n");

        System.out.println("testSearch_FirstElementMatch()");
        String[] arr3 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG101: " + linearSearch(arr3, "BG101") + " (Expected: true)\n");

        System.out.println("testSearch_LastElementMatch()");
        String[] arr4 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("Result finding BG550: " + linearSearch(arr4, "BG550") + " (Expected: true)\n");

        System.out.println("testSearch_SingleElementArray()");
        String[] arr5 = {"BG101"};
        System.out.println("Result finding BG101: " + linearSearch(arr5, "BG101") + " (Expected: true)\n");
    }
}
