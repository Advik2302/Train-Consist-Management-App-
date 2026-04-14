class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class AssignedGoodsBogie {
    private String shape;
    private String cargo;

    public AssignedGoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = "Empty";
    }

    public void assignCargo(String newCargo) {
        if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Unsafe assignment: Cannot assign Petroleum to a Rectangular bogie.");
        }
        this.cargo = newCargo;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }
}

public class SafeCargoAssignment {
    public static void main(String[] args) {
        System.out.println("=== UC15: Safe Cargo Assignment Using try-catch-finally ===\n");
        runTests();
    }

    public static boolean attemptAssignmentAndLog(AssignedGoodsBogie bogie, String cargo) {
        boolean success = false;
        try {
            bogie.assignCargo(cargo);
            success = true;
            System.out.println("Successfully assigned " + cargo + " to " + bogie.getShape() + " bogie.");
        } catch (CargoSafetyException e) {
            System.out.println("Caught CargoSafetyException: " + e.getMessage());
        } finally {
            System.out.println("Finally Block Execution: Validation complete for " + bogie.getShape() + " bogie.\n");
        }
        return success;
    }

    public static void runTests() {
        System.out.println("testCargo_SafeAssignment()");
        AssignedGoodsBogie safeBogie = new AssignedGoodsBogie("Cylindrical");
        boolean safeResult = attemptAssignmentAndLog(safeBogie, "Petroleum");
        System.out.println("Result: Safe Assignment Match? " + (safeResult && safeBogie.getCargo().equals("Petroleum")) + " (Expected: true)\n");

        System.out.println("testCargo_UnsafeAssignmentHandled() and testCargo_CargoNotAssignedAfterFailure()");
        AssignedGoodsBogie unsafeBogie = new AssignedGoodsBogie("Rectangular");
        boolean unsafeResult = attemptAssignmentAndLog(unsafeBogie, "Petroleum");
        System.out.println("Result: Unsafe Assignment Prevented (Failure handled)? " + !unsafeResult + " (Expected: true)");
        System.out.println("Result: Cargo remained empty? " + unsafeBogie.getCargo().equals("Empty") + " (Expected: true)\n");

        System.out.println("testCargo_ProgramContinuesAfterException()");
        AssignedGoodsBogie anotherSafeBogie = new AssignedGoodsBogie("Rectangular");
        boolean nextResult = attemptAssignmentAndLog(anotherSafeBogie, "Coal");
        System.out.println("Result: Program kept running and safely assigned Coal? " + (nextResult && anotherSafeBogie.getCargo().equals("Coal")) + " (Expected: true)\n");

        System.out.println("testCargo_FinallyBlockExecution()");
        System.out.println("Result: You can visually verify in the print statements above that 'Finally Block Execution' logged exactly as many times as method calls. (Expected: true)\n");
    }
}
