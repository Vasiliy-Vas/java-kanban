import java.util.ArrayList;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {

    private List<Task> tasks;
    private List<Task> history;

    public InMemoryTaskManager() {
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Task getTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            addToHistory(task);
        }
        return task;
    }

    @Override
    public void updateTask(Task task) {
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void createEpic(Epic epic) {

    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void addToHistory(Task task) {
        if (!history.contains(task)) {
            history.add(task);
        }

        if (history.size() > 10) {
            history.remove(0);
        }
    }
}