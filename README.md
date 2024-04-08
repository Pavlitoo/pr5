### Використання командного рядка Java для обчислення кількість повних тетрад у двійковому поданні заданого

Даний Java-застосунок дозволяє обчислювати кількість повних тетрад у двійковому поданні заданого
десяткового числа, та тестувати різноманітні функції через командний рядок.


## AddCommand.java

```java
package pr2;

import java.util.List;

public class AddCommand implements Command {
    private List<Integer> collection;
    private int element;

    public AddCommand(List<Integer> collection, int element) {
        this.collection = collection;
        this.element = element;
    }

    @Override
    public void execute() {
        collection.add(element);
    }

    @Override
    public void undo() {
        collection.remove(collection.size() - 1);
    }
}

```

## Command.java

```java

package pr2;

public interface Command {
    void execute();
    void undo();
}
```

## CommanManager.java

```java
package pr2;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static CommandManager instance;
    private List<Command> commandHistory = new ArrayList<>();

    private CommandManager() {}

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
        }
    }
}
```

## MacroCommand.java


```java
package pr2;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
```

## RemoveCommand.java

```java
package pr2;

import java.util.List;

public class RemoveCommand implements Command {
    private List<Integer> collection;
    private int index;
    private int removedElement;

    public RemoveCommand(List<Integer> collection, int index) {
        this.collection = collection;
        this.index = index;
    }

    @Override
    public void execute() {
        removedElement = collection.remove(index);
    }

    @Override
    public void undo() {
        collection.add(index, removedElement);
    }
}
```

## Test.java

```java
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
```


### Ось результат ↓

![Результат](/screenshot/pr5.jpg)




