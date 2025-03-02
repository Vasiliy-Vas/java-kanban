import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {

    private final List<Subtask> subtasks;

    public Epic(String title, String description) {
        super(title, description);
        this.subtasks = new ArrayList<>();
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void updateStatus() {
        if (subtasks.isEmpty()) {
            setStatus(TaskStatus.NEW);
            return;
        }
        boolean allDone = subtasks.stream().allMatch(subtask -> subtask.getStatus() == TaskStatus.DONE);
        boolean anyInProgress = subtasks.stream().anyMatch(subtask -> subtask.getStatus() == TaskStatus.IN_PROGRESS);

        if (allDone) {
            setStatus(TaskStatus.DONE);
        } else if (anyInProgress) {
            setStatus(TaskStatus.IN_PROGRESS);
        } else {
            setStatus(TaskStatus.NEW);
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks.stream().map(Subtask::getId).collect(Collectors.toList()) +
                ", title='" + getTitle() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
}