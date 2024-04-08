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

