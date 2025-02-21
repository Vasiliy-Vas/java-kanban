import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    private Epic epic;

    @BeforeEach
    void setUp() {
        epic = new Epic("Epic Title", "Epic Description");
    }

    @Test
    void createEpicTest() {
        assertNotNull(epic, "Эпик не должен быть нулевым.");
        assertEquals("Epic Title", epic.getTitle(), "Название эпика должно совпадать.");
        assertEquals("Epic Description", epic.getDescription(), "Описание эпика должно совпадать.");
    }

    @Test
    void epicCanAddSubtask() {
        Subtask subtask = new Subtask("Subtask Title", "Subtask Description", epic.getId());
        epic.addSubtask(subtask);
        assertTrue(epic.getSubtasks().contains(subtask), "Подзадача должна быть добавлена в эпик.");
    }

    @Test
    void epicCannotAddItselfAsSubtask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            epic.addSubtask(new Subtask("Subtask Title", "Subtask Description", epic.getId()));
        });
        assertEquals("Нельзя добавить эпик в самого себя как подзадачу.", exception.getMessage());
    }

    @Test
    void epicCanHaveMultipleSubtasks() {
        Subtask subtask1 = new Subtask("Subtask 1", "Description 1", epic.getId());
        Subtask subtask2 = new Subtask("Subtask 2", "Description 2", epic.getId());

        epic.addSubtask(subtask1);
        epic.addSubtask(subtask2);

        assertEquals(2, epic.getSubtasks().size(), "Эпик должен иметь две подзадачи.");
    }

    @Test
    void epicSubtaskReferencesShouldBeCorrect() {
        Subtask subtask = new Subtask("Subtask", "Description", epic.getId());
        epic.addSubtask(subtask);

        assertEquals(epic.getId(), subtask.getEpicId(), "Эпик ID должен совпадать с ID подзадачи.");
    }

    @Test
    void epicToStringTest() {
        String expected = "Epic{id=" + epic.getId() + ", title='Epic Title', description='Epic Description'}";
        assertEquals(expected, epic.toString(), "Метод toString должен возвращать ожидаемую строку.");
    }
}