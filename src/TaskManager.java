import java.util.List;

public interface TaskManager {

    Task getTask(int id);

    void deleteTask(int id);

    List<Task> getAllTasks();

    Task createTask(Task task);

    int createEpic(Epic epic);

    void addSubtask(Subtask subtask);

    Subtask createSubtask(Subtask subtask, int epicId);

    List<Task> getTasks();

    List<Epic> getEpics();

    List<Subtask> getSubtasks();

    void addTask(Task task);

    void updateTask(Task task);

    void updateEpic(Epic epic);

    Subtask createSubtask(Subtask subtask);

    void deleteEpic(int id);

    void addSubtask(Subtask subtask, int epicId);

    void updateSubtask(Subtask subtask);

    void removeSubtask(int subtaskId);

    Epic getEpic(int epicId);

    List<Epic> getAllEpics();

    List<Subtask> getSubtasksByEpic(int epicId);

    void updateStatus();

    Subtask getSubtask(int id);

    Subtask getSubtask(int id, int epicId);

    void deleteSubtask(int id, int epicId);

    void deleteSubtask(int id);

    List<Task> getHistory();

}