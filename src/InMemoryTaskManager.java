import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;


public class InMemoryTaskManager implements TaskManager {

    private final Map<Integer, Subtask> subtasks = new HashMap<>();

    private final Map<Integer, Epic> epics = new HashMap<>();

    private final Map<Integer, Task> tasks = new HashMap<>();

    private final HistoryManager historyManager = Managers.getDefaultHistory();

    private int nextId = 1;

    private void updateEpicStatus(int epicId) {
        Epic epic = epics.get(epicId);
        if (epic != null) {
            List<Subtask> subtasks = epic.getSubtasks();
            if (subtasks.isEmpty()) {
                epic.setStatus(TaskStatus.NEW);
            } else {
                int completedCount = 0;
                for (Subtask subtask : subtasks) {
                    if (subtask.getStatus() == TaskStatus.DONE) {
                        completedCount++;
                    }
                }
                if (completedCount == subtasks.size()) {
                    epic.setStatus(TaskStatus.DONE);
                } else if (completedCount > 0) {
                    epic.setStatus(TaskStatus.IN_PROGRESS);
                } else {
                    epic.setStatus(TaskStatus.NEW);
                }
            }
        }
    }

    @Override
    public Task getTask(int id) {
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
    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public int createEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
        return epic.getId();
    }

    @Override
    public void addSubtask(Subtask subtask) {

    }

    @Override
    public Subtask createSubtask(Subtask subtask, int epicId) {
        if (!epics.containsKey(epicId)) {
            throw new IllegalArgumentException("Эпик не найден");
        }

        subtask.setId(nextId++);
        subtasks.put(subtask.getId(), subtask);
        epics.get(epicId).addSubtask(subtask);

        updateEpicStatus(epicId);

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
    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            updateEpicStatus(subtask.getEpicId());
        }
    }

    @Override
    public void removeSubtask(int subtaskId) {
        Subtask subtask = subtasks.remove(subtaskId);
        if (subtask != null) {
            updateEpicStatus(subtask.getEpicId());
        }
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
        return subtasks.get(id);
    }

    @Override
    public Subtask getSubtask(int id, int epicId) {
        return getSubtask(id);
    }

    @Override
    public void deleteSubtask(int id, int epicId) {

    }

    @Override
    public void deleteSubtask(int id) {
        subtasks.remove(id);
    }

    @Override
    public List<Task> getHistory() {
        return List.of();
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Epic> getEpics() {
        return getAllEpics();
    }

    @Override
    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void updateEpic(Epic epic) {

    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        return null;
    }
}