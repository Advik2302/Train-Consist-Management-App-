import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PerformanceBogie {
    private String type;
    private int capacity;

    public PerformanceBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class PerformanceComparisonLoopsVsStreams {

    public static List<PerformanceBogie> filterWithLoop(List<PerformanceBogie> bogies) {
        List<PerformanceBogie> result = new ArrayList<>();
        for (PerformanceBogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<PerformanceBogie> filterWithStream(List<PerformanceBogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static List<PerformanceBogie> generateDataset(int size) {
        List<PerformanceBogie> dataset = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // Generate capacities alternating to ensure some pass (>60) and some fail
            int capacity = (i % 2 == 0) ? 50 : 72;
            dataset.add(new PerformanceBogie("Passenger", capacity));
        }
        return dataset;
    }

    public static void main(String[] args) {
        System.out.println("=== UC13: Performance Comparison (Loops vs Streams) ===\n");
        runTests();
    }

    public static void runTests() {
        System.out.println("testLoopFilteringLogic()");
        List<PerformanceBogie> smallList = generateDataset(10);
        List<PerformanceBogie> loopResult = filterWithLoop(smallList);
        boolean loopCorrect = loopResult.stream().allMatch(b -> b.getCapacity() > 60);
        System.out.println("Loop result condition matched: " + loopCorrect + " (Expected: true)\n");

        System.out.println("testStreamFilteringLogic()");
        List<PerformanceBogie> streamResult = filterWithStream(smallList);
        boolean streamCorrect = streamResult.stream().allMatch(b -> b.getCapacity() > 60);
        System.out.println("Stream result condition matched: " + streamCorrect + " (Expected: true)\n");

        System.out.println("testLoopAndStreamResultsMatch()");
        System.out.println("Loop size: " + loopResult.size() + ", Stream size: " + streamResult.size() + " (Sizes match: " + (loopResult.size() == streamResult.size()) + ")\n");

        System.out.println("testExecutionTimeMeasurement()");
        long start = System.nanoTime();
        filterWithLoop(smallList);
        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.println("Elapsed time for small list (nanoseconds): " + elapsed + " (> 0: " + (elapsed > 0) + ")\n");

        System.out.println("testLargeDatasetProcessing()");
        List<PerformanceBogie> largeList = generateDataset(1000000); // 1 million
        
        long startLoop = System.nanoTime();
        List<PerformanceBogie> largeLoopResult = filterWithLoop(largeList);
        long endLoop = System.nanoTime();
        long elapsedLoop = endLoop - startLoop;
        
        long startStream = System.nanoTime();
        List<PerformanceBogie> largeStreamResult = filterWithStream(largeList);
        long endStream = System.nanoTime();
        long elapsedStream = endStream - startStream;

        System.out.println("Large List (Size: 1,000,000) Processing Completed:");
        System.out.println("Loop Time (ns): " + elapsedLoop);
        System.out.println("Stream Time (ns): " + elapsedStream);
        System.out.println("Filtered size matching: " + (largeLoopResult.size() == largeStreamResult.size()) + "\n");
    }
}
