package Test;

import java.util.Scanner;

import pr2.CalculationResult;
import pr2.TextTableResultDisplay;

public class CalculationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter parameter 1: ");
        int parameter1 = scanner.nextInt();

        System.out.print("Enter parameter 2: ");
        int parameter2 = scanner.nextInt();

        // Обчислення результату
        int result = parameter1 * parameter2;

        CalculationResult resultObject = new CalculationResult(parameter1, parameter2, result);

        // Тестирование результатов вычислений
        if (resultObject.getResult() != result) {
            throw new AssertionError("Calculation result is incorrect");
        } else {
            System.out.println("Calculatio5 10n result is correct: " + resultObject.getResult());
        }

        // Создание объекта для отображения результатов в виде таблицы
        TextTableResultDisplay resultDisplay = new TextTableResultDisplay();
        resultDisplay.displayTable(resultObject, 1, 3);

        scanner.close();
    }
}
