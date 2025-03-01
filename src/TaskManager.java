import java.util.List;

public interface TaskManager {

    Task getTask(int id);

    void deleteTask(int id);

    List<Task> getAllTasks();

    Task createTask(Task task);

    void createEpic(Epic epic);

    void addSubtask(Subtask subtask);

    Subtask createSubtask(Subtask subtask, int epicId);

    List<Task> getTasks();

    List<Epic> getEpics();

    List<Subtask> getSubtasks();

    void addTask(Task task);

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void deleteEpic(int id);

    void addSubtask(Subtask subtask, int epicId);

    void updateSubtask(Subtask subtask);

    void removeSubtask(int subtaskId);

    Epic getEpic(int epicId);

    List<Epic> getAllEpics();

    List<Subtask> getSubtasksByEpic(int epicId);

    void updateStatus();

    void getSubtask(int id);

    Subtask getSubtask(int id, int epicId);

    void deleteSubtask(int id, int epicId);

    Task[] getHistory();

}