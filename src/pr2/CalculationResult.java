package pr2;

import java.io.Serializable;

public class CalculationResult implements Serializable {
    private int parameter1;
    private int parameter2;
    private int result;

    public CalculationResult(int parameter1, int parameter2, int result) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = result;
    }

    // Геттеры и сеттеры для всех полей

    public int getResult() {
        return result;
    }

    public int getParameter1() {
        return parameter1;
    }

    public int getParameter2() {
        return parameter2;
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "parameter1=" + parameter1 +
                ", parameter2=" + parameter2 +
                ", result=" + result +
                '}';
    }
}
