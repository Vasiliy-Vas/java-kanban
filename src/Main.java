public class Main {
    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Epic epic : manager.getEpics()) {
            System.out.println(epic);
            for (Subtask subtask : manager.getSubtasksByEpic(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("Подзадачи:");
        for (Subtask subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }
        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();

        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.");
        manager.createEpic(epic);

        Subtask subtask1 = new Subtask("Собрать коробки", "Упаковать вещи в коробки.");
        Subtask subtask2 = new Subtask("Упаковать кошку", "Убедиться, что кошка в переноске.");
        Subtask subtask3 = new Subtask("Сказать слова прощания", "Попрощаться с соседями.");

        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);
        subtask3.setStatus(TaskStatus.DONE);

        // Создание подзадач через менеджер
        manager.createSubtask(subtask1, epic.getId());
        manager.createSubtask(subtask2, epic.getId());
        manager.createSubtask(subtask3, epic.getId());

        epic.updateStatus(); // Обновляем статус эпика
        manager.updateEpic(epic); // Обновляем эпик в менеджере

        // Печатаем все задачи и историю
        printAllTasks(manager);
    }
}
/*import java.security.cert.Extension;

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
}*/