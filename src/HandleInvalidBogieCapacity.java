class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogieWithCapacityCheck {
    private String type;
    private int capacity;

    public PassengerBogieWithCapacityCheck(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class HandleInvalidBogieCapacity {
    public static void main(String[] args) {
        System.out.println("=== UC14: Handle Invalid Bogie Capacity (Custom Exception) ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testException_ValidCapacityCreation()");
        try {
            PassengerBogieWithCapacityCheck validBogie = new PassengerBogieWithCapacityCheck("Sleeper", 72);
            System.out.println("Result: Bogie instantiated successfully. (Expected: No Exception)\n");
        } catch (InvalidCapacityException e) {
            System.out.println("Result: Exception thrown improperly.\n");
        }

        System.out.println("testException_NegativeCapacityThrowsException()");
        try {
            new PassengerBogieWithCapacityCheck("AC Chair", -10);
            System.out.println("Result: Did not throw expected exception.\n");
        } catch (InvalidCapacityException e) {
            System.out.println("Result: Exception Thrown: " + e.getClass().getSimpleName() + " (Expected: InvalidCapacityException)\n");
        }

        System.out.println("testException_ZeroCapacityThrowsException()");
        try {
            new PassengerBogieWithCapacityCheck("General", 0);
            System.out.println("Result: Did not throw expected exception.\n");
        } catch (InvalidCapacityException e) {
            System.out.println("Result: Exception Thrown: " + e.getClass().getSimpleName() + " (Expected: InvalidCapacityException)\n");
        }

        System.out.println("testException_ExceptionMessageValidation()");
        try {
            new PassengerBogieWithCapacityCheck("First Class", -5);
            System.out.println("Result: Did not throw expected exception.\n");
        } catch (InvalidCapacityException e) {
            boolean isMatch = e.getMessage().equals("Capacity must be greater than zero");
            System.out.println("Result: Message matched? " + isMatch + " | Message: " + e.getMessage() + " (Expected: true)\n");
        }

        System.out.println("testException_ObjectIntegrityAfterCreation()");
        try {
            PassengerBogieWithCapacityCheck integrityBogie = new PassengerBogieWithCapacityCheck("First Class", 64);
            boolean checkType = "First Class".equals(integrityBogie.getType());
            boolean checkCapacity = integrityBogie.getCapacity() == 64;
            System.out.println("Result: Integrity check pass? " + (checkType && checkCapacity) + " (Expected: true)\n");
        } catch (InvalidCapacityException e) {
            System.out.println("Result: Test failed unexpectedly.\n");
        }

        System.out.println("testException_MultipleValidBogiesCreation()");
        try {
            new PassengerBogieWithCapacityCheck("AC Chair", 56);
            new PassengerBogieWithCapacityCheck("Sleeper", 72);
            new PassengerBogieWithCapacityCheck("General", 90);
            System.out.println("Result: Multiple objects created successfully. (Expected: No Exception)\n");
        } catch (InvalidCapacityException e) {
            System.out.println("Result: Failed unexpected exception during multiple creations.\n");
        }
    }
}
