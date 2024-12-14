public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Создаем эпик
        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.", 1);

        // Создаем подзадачи
        Subtask subtask1 = manager.createSubtask("Собрать коробки", "Упаковать вещи в коробки.", 2, epic.getId());
        Subtask subtask2 = manager.createSubtask("Упаковать кошку", "Убедиться, что кошка в переноске.", 3, epic.getId());
        Subtask subtask3 = manager.createSubtask("Сказать слова прощания", "Попрощаться с соседями.", 4, epic.getId());
        // Завершим подзадачи
        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);

        // Обновим статус эпика
        epic.addSubtask(subtask1);
        epic.addSubtask(subtask2);
        epic.addSubtask(subtask3);
        epic.updateStatus();

        // Вывод всех задач
        System.out.println(epic);
    }
}
