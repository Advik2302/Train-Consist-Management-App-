public class ExceptionSearchHandling {

    public static boolean searchWithValidation(String[] bogieIds, String searchKey) {
        // Defensive validation strictly as requested
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search cannot be performed on an empty train consist.");
        }

        // Basic traversal
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== UC20: Exception Handling During Search Operations ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testSearch_ThrowsExceptionWhenEmpty()");
        try {
            String[] arr1 = {};
            searchWithValidation(arr1, "BG101");
            System.out.println("Result: Did not throw expected exception.\n");
        } catch (IllegalStateException e) {
            System.out.println("Result: Thrown " + e.getClass().getSimpleName() + " (Expected: true) | Message: " + e.getMessage() + "\n");
        }

        System.out.println("testSearch_AllowsSearchWhenDataExists()");
        try {
            String[] arr2 = {"BG101", "BG205"};
            searchWithValidation(arr2, "BG101");
            System.out.println("Result: Search executed without triggering exception! (Expected: true)\n");
        } catch (IllegalStateException e) {
            System.out.println("Result: Failed unexpectedly.\n");
        }

        System.out.println("testSearch_BogieFoundAfterValidation()");
        String[] arr3 = {"BG101", "BG205", "BG309"};
        System.out.println("Result finding BG205: " + searchWithValidation(arr3, "BG205") + " (Expected: true)\n");

        System.out.println("testSearch_BogieNotFoundAfterValidation()");
        String[] arr4 = {"BG101", "BG205", "BG309"};
        System.out.println("Result finding BG999: " + searchWithValidation(arr4, "BG999") + " (Expected: false)\n");

        System.out.println("testSearch_SingleElementValidCase()");
        String[] arr5 = {"BG101"};
        System.out.println("Result finding BG101: " + searchWithValidation(arr5, "BG101") + " (Expected: true)\n");
    }
}
