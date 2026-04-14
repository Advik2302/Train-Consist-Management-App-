import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class SafetyComplianceCheckGoodsBogies {

    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        // Enforce the rule: If Cylindrical, cargo MUST be Petroleum
        return bogies.stream()
                .allMatch(bogie -> !bogie.getType().equalsIgnoreCase("Cylindrical") 
                                || bogie.getCargo().equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {
        System.out.println("=== UC12: Safety Compliance Check for Goods Bogies ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testSafety_AllBogiesValid()");
        List<GoodsBogie> validTrain = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );
        System.out.println("Result: " + isTrainSafe(validTrain) + " (Expected: true)\n");

        System.out.println("testSafety_CylindricalWithInvalidCargo()");
        List<GoodsBogie> invalidCylindrical = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        System.out.println("Result: " + isTrainSafe(invalidCylindrical) + " (Expected: false)\n");

        System.out.println("testSafety_NonCylindricalBogiesAllowed()");
        List<GoodsBogie> nonCylindrical = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        System.out.println("Result: " + isTrainSafe(nonCylindrical) + " (Expected: true)\n");

        System.out.println("testSafety_MixedBogiesWithViolation()");
        List<GoodsBogie> mixedViolation = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Cylindrical", "Grain") // Violation
        );
        System.out.println("Result: " + isTrainSafe(mixedViolation) + " (Expected: false)\n");

        System.out.println("testSafety_EmptyBogieList()");
        List<GoodsBogie> emptyList = new ArrayList<>();
        System.out.println("Result: " + isTrainSafe(emptyList) + " (Expected: true)\n");
    }
}
