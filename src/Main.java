public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Epic epic = manager.createEpic("Переезд", "Организация переезда на новую квартиру.");

        Subtask subtask1 = manager.createSubtask("Собрать коробки", "Упаковать вещи в коробки." , epic.getId());
        Subtask subtask2 = manager.createSubtask("Упаковать кошку", "Убедиться, что кошка в переноске.", epic.getId());
        Subtask subtask3 = manager.createSubtask("Сказать слова прощания", "Попрощаться с соседями.", epic.getId());

        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);


        epic.addSubtask(subtask1);
        epic.addSubtask(subtask2);
        epic.addSubtask(subtask3);
        manager.updateEpicStatus(epic);


        System.out.println(epic);
    }
}
