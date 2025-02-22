import java.util.List;

public interface HistoryManager {

    void addView(Task task);

    List<Task> getHistory();

    void clearHistory();

    void add(Task task1);
}