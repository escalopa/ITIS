package task2;

import task2.another_components.TestClass;
import task2.another_components.TestComponent;

public class Main {

    public static void main(String[] args) {

        //Init class & attributes
        String path = "task2.another_components";
        Context context = new Context(path);

        //Testing context functionality
        TestClass testClass = (TestClass) context.get("TestClass");
        System.out.println("Test1\n\tTestClass was initialized >>> " + testClass);

        //Call
        System.out.print("Test2\n\tTestCalling print method from testClass \n\t\t");
        testClass.print();
    }
}
