package testlink.models;

/**
 * Created by Ivan.Ivanyuk on 3/20/2015.
 */
public class TestSuite {
    public String name = "Conspicuous name";
    public String details = "Some details";

    public TestSuite(){
    }

    public TestSuite(String name, String details){
        this.name = name;
        this.details = details;
    }
}
