import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {

    private final List<Subtask> subtasks;

    public Epic(String title, String description) {
        super(title, description);
        this.subtasks = new ArrayList<>();
    }

    public Subtask addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        return subtask;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
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

    public void removeSubtask(Subtask subtask) {
        subtasks.remove(subtask);
    }

    public void updateStatus() {

    }
}