import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {

    private final List<Subtask> subtasks;

    public Epic(String title, String description) {
        super();
        this.subtasks = new ArrayList<>();
    }

    public boolean addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        return false;
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
    }

    public void updateStatus() {
    }
}