import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {

    private final List<Subtask> subtasks;

    public Epic(String title, String description, Extension task1) {
        super(task1.getId(), title, description, TaskStatus.NEW);
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
                "subtasks=" + subtasks.stream().map(Subtask::getId).toList() +
                ", title='" + getTitle() + '\''
                +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
}