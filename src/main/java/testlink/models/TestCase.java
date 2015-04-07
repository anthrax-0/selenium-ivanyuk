package testlink.models;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class TestCase {
    public String title = "New test case";
    public String summary = "Test summary";
    public String preconditions = "Test preconditions";

    public TestCase() {
    }

    public TestCase(String title, String summary, String preconditions) {
        this.title = title;
        this.summary = summary;
        this.preconditions = preconditions;
    }
}
