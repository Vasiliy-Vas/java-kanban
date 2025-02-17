import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {

    private List<Subtask> subtasks;

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


    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks.stream().map(Subtask::getId).collect(Collectors.toList()) +
                ", title='" + getTitle() + '\''
                +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
    public void updateStatus() {
        if (subtasks.isEmpty()) {
            setStatus(TaskStatus.NEW);
            return;
        }

        long doneCount = subtasks.stream().filter(subtask -> subtask.getStatus() == TaskStatus.DONE).count();
        if (doneCount == subtasks.size()) {
            setStatus(TaskStatus.DONE);
        } else if (doneCount > 0) {
            setStatus(TaskStatus.IN_PROGRESS);
        } else {
            setStatus(TaskStatus.NEW);
        }
    }
}