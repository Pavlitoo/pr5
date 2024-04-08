package pr2;


public class BinaryNumber {
    public static void main(String[] args) {
        int decimalNumber = 123; // Заданное десятичное число
        int binaryOnesCount = countOnesInBinary(decimalNumber);
        int fullQuartets = binaryOnesCount / 4; // Количество полных тетрад
        System.out.println("Number of full quartets in binary representation of " + decimalNumber + " is " + fullQuartets);
    }

    private static int countOnesInBinary(int decimalNumber) {
        String binaryString = Integer.toBinaryString(decimalNumber);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
