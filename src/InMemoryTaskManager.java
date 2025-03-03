import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();
    private int nextId = 1;

    @Override
    public Task createTask(Task task) {
        task.setId(nextId++);
        // tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public int createEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
        return epic.getId();
    }

    @Override
    public Subtask createSubtask(Subtask subtask, int epicId) {
        if (!epics.containsKey(epicId)) {
            throw new IllegalArgumentException("Эпик не найден");
        }
        subtask.setId(nextId++);
        subtasks.put(subtask.getId(), subtask);
        epics.get(epicId).addSubtask(subtask);
        return subtask;
    }

    @Override
    public void deleteEpic(int id) {
        if (epics.remove(id) != null) {
            List<Subtask> subtasksToDelete = getSubtasksByEpic(id);
            for (Subtask subtask : subtasksToDelete) {
                deleteSubtask(subtask.getId());
            }
        }
    }

    @Override
    public void addSubtask(Subtask subtask, int epicId) {

    }

    @Override
    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
        }
    }

    @Override
    public void removeSubtask(int subtaskId) {
        subtasks.remove(subtaskId);
    }

    @Override
    public Epic getEpic(int epicId) {
        return epics.get(epicId);
    }

    @Override
    public List<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public List<Subtask> getSubtasksByEpic(int epicId) {
        Epic epic = getEpic(epicId);
        return epic == null ? new ArrayList<>() : epic.getSubtasks();
    }

    @Override
    public void updateStatus() {

    }

    @Override
    public Subtask getSubtask(int id) {
        return null;
    }

    @Override
    public Subtask getSubtask(int id, int epicId) {
        return null;
    }

    @Override
    public void deleteSubtask(int id, int epicId) {

    }

    @Override
    public void deleteSubtask(int id) {

    }

    @Override
    public List<Task> getTasks() {
        // return new ArrayList<>(tasks.values());
        return List.of();
    }

    @Override
    public List<Epic> getEpics() {
        return getAllEpics();
    }

    @Override
    public List<Subtask> getSubtasks() {
        return List.of();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void updateEpic(Epic epic) {

    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        return null;
    }

    @Override
    public void deleteTask(int id) {
    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }
}