import java.util.List;

public interface TaskManager {
    Task createTask(Task task);

    Epic createEpic(Epic epic);

    Epic getEpic(int epicId);

    Subtask createSubtask(Subtask subtask, int epicId);

    List<Task> getHistory();

    Subtask createSubtask(Subtask subtask);

    List<Task> getTasks();

    List<Epic> getEpics();

    List<Subtask> getSubtasks();

    List<Subtask> getSubtasksByEpic(int epicId);

    List<Epic> getAllEpics();

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    void deleteTask(int taskId);

    void updateStatus();

    void addSubtask(Subtask subtask);
}