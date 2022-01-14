package class2;

import org.testng.annotations.Test;

public class EnableAndDisable {

    @Test
    public void firstTest() {
        System.out.println("I am first");
    }
    @Test (enabled = false)
    public void secondTest() {
        System.out.println("I am second");
    }
    @Test
    public void thirdTest() {
        System.out.println("I am third");
    }
}
