import java.util.ArrayList;
import java.util.List;
public class InMemoryHistoryManager extends HistoryManager {
    private final List<Task> history = new ArrayList<>();
    private static final int MAX_HISTORY_SIZE = 10;

    @Override
    public void add(Task task) {
        if (history.size() >= MAX_HISTORY_SIZE) {
            history.remove(0);
        }
        history.add(task);
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}

