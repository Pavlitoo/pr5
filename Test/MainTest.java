package Test;
import pr.Main;

public class MainTest {

    public static void main(String[] args) {
        MainTest tester = new MainTest(); // Створюємо об'єкт класу MainTest
        // Викликаємо методи для тестування
        tester.testNoArguments();
        tester.testWithArguments();
    }

    public void testNoArguments() {
        String[] args = {};
        Main.main(args); // Викликаємо метод main з класу Main
    }

    public void testWithArguments() {
        String[] args = {"Hello", "World!", "Pavlitoo"};
        Main.main(args); // Викликаємо метод main з класу Main
    }
}