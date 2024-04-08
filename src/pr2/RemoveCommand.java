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

