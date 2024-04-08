package pr2;

public class TextResultDisplay implements ResultDisplay {
    @Override
    public void displayResult(CalculationResult result) {
        System.out.println("Parameter 1: " + result.getParameter1());
        System.out.println("Parameter 2: " + result.getParameter2());
        System.out.println("Result: " + result.getResult());
    }
}

