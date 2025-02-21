import java.util.*;

public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    private final List<Task> history = new ArrayList<>();
    private int idCounter = 1;

    public void addTask(Task task) {
        task.setId(idCounter++);
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epic.setId(idCounter++);
        epics.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) {
        subtask.setId(idCounter++);
        subtasks.put(subtask.getId(), subtask);
        if (epics.containsKey(subtask.getEpicId())) {
            Epic epic = epics.get(subtask.getEpicId());
            epic.addSubtask(subtask);
        }
    }

    public Task getTaskById(int id) {
        if (tasks.containsKey(id)) {
            addToHistory(tasks.get(id));
            return tasks.get(id);
        }
        return null;
    }

    public Epic getEpicById(int id) {
        if (epics.containsKey(id)) {
            addToHistory(epics.get(id));
            return epics.get(id);
        }
        return null;
    }

    public Subtask getSubtaskById(int id) {
        if (subtasks.containsKey(id)) {
            addToHistory(subtasks.get(id));
            return subtasks.get(id);
        }
        return null;
    }

    private void addToHistory(Task task) {
        if (!history.contains(task)) {
            history.add(task);
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }

    public List<Subtask> getEpicSubtasks(int epicId) {
        if (epics.containsKey(epicId)) {
            return epics.get(epicId).getSubtasks();
        }
        return new ArrayList<>();
    }

    public void createEpic(Epic epic) {
    }

    public void createSubtask(Subtask subtask1) {
    }
}
