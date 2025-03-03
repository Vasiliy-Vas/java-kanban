import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryManagerTest {
    @Test
    void addTaskToHistory() {
        HistoryManager historyManager = new InMemoryHistoryManager();
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");

        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();

        assertNotNull(history, "История не должна быть null");
        assertEquals(2, history.size(), "Неверное количество задач в истории");
        assertEquals(task1, history.get(0), "Первая задача в истории не совпадает");
        assertEquals(task2, history.get(1), "Вторая задача в истории не совпадает");
    }

    @Test
    void limitHistoryToTenTasks() {
        HistoryManager historyManager = new InMemoryHistoryManager();

        for (int i = 1; i <= 12; i++) {
            historyManager.add(new Task("Task " + i, "Description " + i));
        }

        List<Task> history = historyManager.getHistory();
        assertEquals(10, history.size(), "История должна содержать только 10 задач");
    }
}
