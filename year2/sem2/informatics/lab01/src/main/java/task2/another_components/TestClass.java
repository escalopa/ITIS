package task2.another_components;
import task2.annotations.Autowire;
import task2.annotations.Component;

@Component
public class TestClass {

    @Autowire
    private TestComponent testComponent;

    public void print() {
        System.out.println(testComponent.getComponentInfo());
    }

}
