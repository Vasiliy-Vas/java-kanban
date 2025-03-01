import java.security.cert.Extension;

public class Main {

    public static void main(String[] args) {
        TaskManager manager = new InMemoryTaskManager();


        Extension task1;
        task1 = null;
        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.", task1);
        manager.createEpic(epic);

        Subtask subtask1 = new Subtask("Собрать коробки", "Упаковать вещи в коробки.", epic.getId(), task1);
        Subtask subtask2 = new Subtask("Упаковать кошку", "Убедиться, что кошка в переноске.", epic.getId(), task1);
        Subtask subtask3 = new Subtask("Сказать слова прощания", "Попрощаться с соседями.", epic.getId(), task1);

        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);


        System.out.println(epic);
    }
}