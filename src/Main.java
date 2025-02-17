public class Main {

    public static void main(String[] args) {
        TaskManager manager = new InMemoryTaskManager();

        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.");
        manager.createEpic(epic);

        Subtask subtask1 = new Subtask("Собрать коробки", "Упаковать вещи в коробки.", epic.getId());
        Subtask subtask2 = new Subtask("Упаковать кошку", "Убедиться, что кошка в переноске.", epic.getId());
        Subtask subtask3 = new Subtask("Сказать слова прощания", "Попрощаться с соседями.", epic.getId());


        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);


        System.out.println(epic);
    }
}