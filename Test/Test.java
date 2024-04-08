package Test;

import java.util.ArrayList;
import java.util.List;
import pr2.*;


public class Test {
    public static void main(String[] args) {
        CommandManager commandManager = CommandManager.getInstance();
        List<Integer> collection = new ArrayList<>();

        // Додамо елементи до колекції за допомогою окремих команд
        commandManager.executeCommand(new AddCommand(collection, 5));
        commandManager.executeCommand(new AddCommand(collection, 10));
        commandManager.executeCommand(new AddCommand(collection, 15));

        // Виконаємо макрокоманду, яка видаляє перші два елементи
        MacroCommand macroCommand = new MacroCommand();
        macroCommand.addCommand(new RemoveCommand(collection, 0));
        macroCommand.addCommand(new RemoveCommand(collection, 0));
        commandManager.executeCommand(macroCommand);

        // Відміна останньої виконаної операції
        commandManager.undoLastCommand();

        // Виведемо вміст колекції після операцій
        System.out.println("Collection after operations: " + collection);
    }
}

