package class2;

import org.testng.annotations.Test;

public class PriorityClass {

    @Test (priority = 2)
    public void firstTest() {
        System.out.println("I am first");
    }
    @Test (priority = 3)
    public void secondTest() {
        System.out.println("I am first");
    }
    @Test (priority = 1)
    public void thirdTest() {
        System.out.println("I am first");
    }
}
