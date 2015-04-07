package testlink.models;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class TestStep {
    public String stepActions = "Step 1";
    public String expectedResults = "Step succeed";

    public TestStep() {

    }

    public TestStep(String stepActions, String expectedResults) {
        this.stepActions = stepActions;
        this.expectedResults = expectedResults;
    }
}
