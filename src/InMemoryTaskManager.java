import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {

    private final List<Task> tasks;
    private final List<Epic> epics;
    private final Map<Integer, List<Subtask>> subtasks;
    private final List<Task> history;

    public InMemoryTaskManager() {
        this.tasks = new ArrayList<>();
        this.epics = new ArrayList<>();
        this.subtasks = new HashMap<>();
        this.history = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void updateTask(Task task) {
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
    public void deleteTask(int id) {
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public void createEpic(Epic epic) {
        epics.add(epic);
    }

    @Override
    public void addSubtask(Subtask subtask) {

    }

    @Override
    public Subtask createSubtask(Subtask subtask, int epicId) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return List.of();
    }

    @Override
    public List<Epic> getEpics() {
        return List.of();
    }

    @Override
    public List<Subtask> getSubtasks() {
        return List.of();
    }

    @Override
    public void updateEpic(Epic epic) {
    }

    @Override
    public Epic getEpic(int id) {
        return null;
    }

    @Override
    public List<Epic> getAllEpics() {
        return List.of();
    }

    @Override
    public List<Subtask> getSubtasksByEpic(int epicId) {
        return List.of();
    }

    @Override
    public void updateStatus() {

    }

    @Override
    public void getSubtask(int id) {

    }

    @Override
    public void deleteEpic(int id) {
    }

    @Override
    public void addSubtask(Subtask subtask, int epicId) {
        subtasks.computeIfAbsent(epicId, k -> new ArrayList<>()).add(subtask);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
    }

    @Override
    public void removeSubtask(int subtaskId) {

    }

    @Override
    public Subtask getSubtask(int id, int epicId) {
        // Код получения сабтаска по id и epicId
        return null;
    }

    @Override
    public void deleteSubtask(int id, int epicId) {
    }

    @Override
    public Task[] getHistory() {
        return new ArrayList<>(history).toArray(new Task[0]);
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
            history.removeFirst();
        }
    }
}