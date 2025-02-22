import java.util.List;

public interface TaskManager {

    void addTask(Task task);
    Task getTask(int id);
    void updateTask(Task task);
    List<Task> getHistory();

    void createEpic(Epic epic);
}