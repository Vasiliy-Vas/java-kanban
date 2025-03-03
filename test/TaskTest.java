import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TaskTest {
    @Test
    void testTaskEquality() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 1", "Description 1");
        assertEquals(task1, task2, "Задачи должны быть равны");
    }

    @Test
    void testEpicCannotAddSelfAsSubtask() {
        Epic epic = new Epic("Epic 1", "EpicDescription");
        Subtask subtask = new Subtask("Subtask 1", "SubtaskDescription", epic);
        // Проверка логики, которая запрещает добавление самой задачи в подзадачи
        assertFalse(epic.addSubtask(subtask), "Epic не должен добавлять себя в подзадачи");
    }
}