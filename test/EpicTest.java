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
}