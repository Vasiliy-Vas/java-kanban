import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task("Task Title", "Task Description");
    }

    @Test
    void createTaskTest() {
        assertNotNull(task, "Задача не должна быть нулевой.");
        assertEquals("Task Title", task.getTitle(), "Название задачи должно совпадать.");
        assertEquals("Task Description", task.getDescription(), "Описание задачи должно совпадать.");
    }

    @Test
    void taskCanChangeStatus() {
        task.setStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus(), "Статус задачи должен обновиться на 'В процессе'.");

        task.setStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus(), "Статус задачи должен обновиться на 'Выполнена'.");
    }

    @Test
    void taskCannotBeCreatedWithEmptyTitle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "Description");
        });
        assertEquals("Название задачи не может быть пустым.", exception.getMessage());
    }

    @Test
    void taskToStringTest() {
        String expected = "Task{id=" + task.getId() + ", title='Task Title', description='Task Description', status='NEW'}";
        assertEquals(expected, task.toString(), "Метод toString должен возвращать ожидаемую строку.");
    }

    @Test
    void taskCanBeAssignedToEpic() {
        Epic epic = new Epic("Epic Title", "Epic Description");
        task.setEpicId(epic.getId());
        assertEquals(epic.getId(), task.getEpicId(), "ID эпика должен совпадать с ID задачи.");
    }
}