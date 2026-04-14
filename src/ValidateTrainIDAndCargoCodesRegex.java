import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTrainIDAndCargoCodesRegex {

    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static boolean isValidTrainID(String trainId) {
        if (trainId == null) return false;
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("=== UC11: Validate Train ID & Cargo Codes (Regex) ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testRegex_ValidTrainID()");
        System.out.println("TRN-1234 is valid: " + isValidTrainID("TRN-1234") + " (Expected: true)\n");

        System.out.println("testRegex_InvalidTrainIDFormat()");
        System.out.println("TRAIN12 is valid: " + isValidTrainID("TRAIN12") + " (Expected: false)");
        System.out.println("TRN12A is valid: " + isValidTrainID("TRN12A") + " (Expected: false)");
        System.out.println("1234-TRN is valid: " + isValidTrainID("1234-TRN") + " (Expected: false)\n");

        System.out.println("testRegex_ValidCargoCode()");
        System.out.println("PET-AB is valid: " + isValidCargoCode("PET-AB") + " (Expected: true)\n");

        System.out.println("testRegex_InvalidCargoCodeFormat()");
        System.out.println("PET-ab is valid: " + isValidCargoCode("PET-ab") + " (Expected: false)");
        System.out.println("PET123 is valid: " + isValidCargoCode("PET123") + " (Expected: false)");
        System.out.println("AB-PET is valid: " + isValidCargoCode("AB-PET") + " (Expected: false)\n");

        System.out.println("testRegex_TrainIDDigitLengthValidation()");
        System.out.println("TRN-123 is valid: " + isValidTrainID("TRN-123") + " (Expected: false)");
        System.out.println("TRN-12345 is valid: " + isValidTrainID("TRN-12345") + " (Expected: false)\n");

        System.out.println("testRegex_CargoCodeUppercaseValidation()");
        System.out.println("PET-aB is valid: " + isValidCargoCode("PET-aB") + " (Expected: false)");
        System.out.println("PET-Ab is valid: " + isValidCargoCode("PET-Ab") + " (Expected: false)\n");

        System.out.println("testRegex_EmptyInputHandling()");
        System.out.println("Empty Train ID is valid: " + isValidTrainID("") + " (Expected: false)");
        System.out.println("Empty Cargo Code is valid: " + isValidCargoCode("") + " (Expected: false)\n");

        System.out.println("testRegex_ExactPatternMatch()");
        System.out.println("TRN-1234X is valid: " + isValidTrainID("TRN-1234X") + " (Expected: false)");
        System.out.println("XTRN-1234 is valid: " + isValidTrainID("XTRN-1234") + " (Expected: false)");
        System.out.println("PET-ABC is valid: " + isValidCargoCode("PET-ABC") + " (Expected: false)");
        System.out.println("XPET-AB is valid: " + isValidCargoCode("XPET-AB") + " (Expected: false)\n");
    }
}
