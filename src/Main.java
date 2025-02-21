public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();
        HistoryManager historyManager = new InMemoryHistoryManager(); // Создаем экземпляр менеджера истории

        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.");
        manager.createEpic(epic);

        Subtask subtask1 = new Subtask("Собрать коробки", "Упаковать вещи в коробки.", epic.getId());
        Subtask subtask2 = new Subtask("Упаковать кошку", "Убедиться, что кошка в переноске.", epic.getId());
        Subtask subtask3 = new Subtask("Сказать слова прощания", "Попрощаться с соседями.", epic.getId());

        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);

        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
        manager.createSubtask(subtask3);

        ((InMemoryHistoryManager) historyManager).add(epic);
        ((InMemoryHistoryManager) historyManager).add(subtask1);
        ((InMemoryHistoryManager) historyManager).add(subtask2);
        ((InMemoryHistoryManager) historyManager).add(subtask3);

        System.out.println("История просмотров:");
        System.out.println(historyManager.getHistory());

        System.out.println(epic);
    }
}