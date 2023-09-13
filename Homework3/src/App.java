import Cars.Car;
import Cars.CleaningMachine;
import Cars.Toyota;

public class App {
    public static void main(String[] args) {
        Car markII = new Toyota("markII","black","sedan", "95","Auto", 4, 2.0);
        System.out.println(markII);
        Car harvester = new CleaningMachine("model1","white","Honda", "DT", "Auto", 6, 3.0);
        System.out.println(harvester);
    }
}
