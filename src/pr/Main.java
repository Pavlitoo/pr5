package pr;

public class Main {
    public static void main(String[] args) {
        // Перевірка, чи є аргументи командного рядка
        if (args.length == 0) {
            System.out.println("Немає переданих аргументів командного рядка.");
        } else {
            System.out.println("Передані аргументи командного рядка:");
            // Виведення переданих аргументів командного рядка
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        }
    }
}
