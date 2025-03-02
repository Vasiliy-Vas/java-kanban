import java.security.cert.Extension;

public class Subtask extends Task {

    private int epicId;

    public Subtask(String title, String description, int epicId, Extension task1) {
        super(task1.getId(), title, description, TaskStatus.NEW);
        this.epicId = epicId;
    }

    public Subtask(String собратьКоробки, String description) {
        super();
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStatus() +
                '}';
    }
}