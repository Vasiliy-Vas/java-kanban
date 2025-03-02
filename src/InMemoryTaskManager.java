import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, List<Subtask>> epicSubtasks = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();
    private int nextId = 1;

    @Override
    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public int createEpic(Epic epic) {
        epic.setId(nextId++);
        tasks.put(epic.getId(), epic);
        epicSubtasks.put(epic.getId(), new ArrayList<>());
        return epic.getId();
    }

    @Override
    public void addSubtask(Subtask subtask) {
        List<Subtask> subtasks = epicSubtasks.get(subtask.getEpicId());
        if (subtasks != null) {
            subtasks.add(subtask);
        }
    }

    @Override
    public Subtask createSubtask(Subtask subtask, int epicId) {
        subtask.setId(nextId++);
        subtask.setEpicId(epicId);
        tasks.put(subtask.getId(), subtask);
        addSubtask(subtask);
        return subtask;
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Epic> getEpics() {
        List<Epic> epics = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Epic) {
                epics.add((Epic) task);
            }
        }
        return epics;
    }

    @Override
    public List<Subtask> getSubtasks() {
        List<Subtask> subtasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Subtask) {
                subtasks.add((Subtask) task);
            }
        }
        return subtasks;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        tasks.put(epic.getId(), epic);
    }

    @Override
    public void deleteEpic(int id) {

    }

    @Override
    public void addSubtask(Subtask subtask, int epicId) {

    }

    @Override
    public void updateSubtask(Subtask subtask) {
        tasks.put(subtask.getId(), subtask);
    }

    @Override
    public void removeSubtask(int subtaskId) {
        tasks.remove(subtaskId);
        for (List<Subtask> subtasks : epicSubtasks.values()) {
            subtasks.removeIf(subtask -> subtask.getId() == subtaskId);
        }
    }

    @Override
    public Epic getEpic(int epicId) {
        return (Epic) tasks.get(epicId);
    }

    @Override
    public List<Epic> getAllEpics() {
        return getEpics();
    }

    @Override
    public List<Subtask> getSubtasksByEpic(int epicId) {
        return epicSubtasks.getOrDefault(epicId, new ArrayList<>());
    }

    @Override
    public void updateStatus() {
        for (Epic epic : getEpics()) {
            List<Subtask> subtasks = getSubtasksByEpic(epic.getId());
            if (subtasks.isEmpty()) {
                epic.setStatus(TaskStatus.NEW);
            } else {
                boolean allDone = true;
                boolean anyInProgress = false;

                for (Subtask subtask : subtasks) {
                    if (subtask.getStatus() != TaskStatus.DONE) {
                        allDone = false;
                        if (subtask.getStatus() == TaskStatus.IN_PROGRESS) {
                            anyInProgress = true;
                        }
                    }
                }

                if (allDone) {
                    epic.setStatus(TaskStatus.DONE);
                } else if (anyInProgress) {
                    epic.setStatus(TaskStatus.IN_PROGRESS);
                } else {
                    epic.setStatus(TaskStatus.NEW);
                }
            }
            updateEpic(epic);
        }
    }

    @Override
    public Task getTask(int id) {
        Task task = tasks.get(id);
        historyManager.add(task);
        return task;
    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public Subtask getSubtask(int id) {
        Subtask subtask = (Subtask) tasks.get(id);
        historyManager.add(subtask);
        return subtask;
    }

    @Override
    public Subtask getSubtask(int id, int epicId) {
        return null;
    }

    @Override
    public void deleteSubtask(int id, int epicId) {

    }

    @Override
    public Task[] getHistory() {
        return historyManager.getHistory().toArray(new Task[0]);
    }
}