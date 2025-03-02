public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager(); // Возвращаем реализацию InMemoryTaskManager
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager(); // Возвращаем реализацию InMemoryHistoryManager
    }
}