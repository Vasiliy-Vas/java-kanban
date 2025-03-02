import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task != null) {
            history.add(task);
            if (history.size() > 10) {
                history.remove(0);
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}