import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpicTest {
    private Epic epic;

    @BeforeEach
    public void setUp() {
        epic = new Epic("Тестовый эпик", "Описание тестового эпика");
    }

    @Test
    public void testEpicCreation() {
        assertNotNull(epic);
        assertEquals("Тестовый эпик", epic.getTitle());
        assertEquals("Описание тестового эпика", epic.getDescription());
    }

    @Test
    public void testAddSubtask() {
        Subtask subtask1 = new Subtask("Сабтаск 1", "Описание сабтаска 1");
        Subtask subtask2 = new Subtask("Сабтаск 2", "Описание сабтаска 2");

        epic.addSubtask(subtask1);
        epic.addSubtask(subtask2);

        assertEquals(2, epic.getSubtasks().size());
        assertTrue(epic.getSubtasks().contains(subtask1));
        assertTrue(epic.getSubtasks().contains(subtask2));
    }

    @Test
    public void testRemoveSubtask() {
        Subtask subtask = new Subtask("Сабтаск", "Описание сабтаска");
        epic.addSubtask(subtask);
        epic.removeSubtask(subtask);

        assertEquals(0, epic.getSubtasks().size());
        assertFalse(epic.getSubtasks().contains(subtask));
    }

    @Test
    public void testEpicIdSet() {
        epic.setId(1);
        assertEquals(1, epic.getId());
    }

    @Test
    public void testEpicStatusUpdate() {
        Subtask subtask1 = new Subtask("Сабтаск 1", "Описание сабтаска 1");
        subtask1.setStatus(TaskStatus.DONE);

        Subtask subtask2 = new Subtask("Сабтаск 2", "Описание сабтаска 2");
        subtask2.setStatus(TaskStatus.NEW);

        epic.addSubtask(subtask1);
        epic.addSubtask(subtask2);

        epic.updateStatus();

        assertEquals(TaskStatus.IN_PROGRESS, epic.getStatus());
    }
}