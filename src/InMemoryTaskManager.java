import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private Map<Integer, Task> tasks;
    private Map<Integer, Epic> epics;
    private Map<Integer, Subtask> subtasks;
    private List<Task> history;
    private int nextId;

    public InMemoryTaskManager() {
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
        history = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Epic createEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
        return epic;
    }

    @Override
    public Subtask createSubtask(Subtask subtask, int epicId) {
        subtask.setId(nextId++);
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(epicId);
        if (epic != null) {
            epic.addSubtask(subtask);
            epic.updateStatus();
        }
        return subtask;
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public List<Task> getTasks() {
        return updateHistory(new ArrayList<>(tasks.values()));
    }

    @Override
    public List<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public List<Subtask> getSubtasksByEpic(int epicId) {
        Epic epic = epics.get(epicId);
        return epic != null ? epic.getSubtasks() : new ArrayList<>();
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.updateStatus();
        }
    }

    @Override
    public void deleteTask(int taskId) {
        tasks.remove(taskId);
        updateEpicStatus();
    }

    private void updateEpicStatus() {
        for (Epic epic : epics.values()) {
            epic.updateStatus();
        }
    }

    private List<Task> updateHistory(List<Task> tasks) {
        history.addAll(tasks);
        return tasks;
    }
}