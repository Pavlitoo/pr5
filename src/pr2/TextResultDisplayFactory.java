package pr2;

public class TextResultDisplayFactory implements ResultDisplayFactory {
    @Override
    public ResultDisplay createResultDisplay() {
        return new TextResultDisplay();
    }
}
