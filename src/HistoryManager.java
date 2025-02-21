import java.util.ArrayList;
import java.util.List;

public abstract class HistoryManager {
    private List<String> history;

    public HistoryManager() {
        this.history = new ArrayList<>();
    }

    public void addView(String item) {
        history.add(item);
    }

    public abstract void add(Task task);

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void clearHistory() {
        history.clear();
    }
}