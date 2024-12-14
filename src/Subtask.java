class Subtask extends Task {
    private int epicId; // Идентификатор эпика, к которому принадлежит подзадача

    public Subtask(String title, String description, int id, int epicId) {
        super(title, description, id);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
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
